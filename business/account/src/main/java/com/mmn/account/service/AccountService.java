package com.mmn.account.service;

import com.mmn.account.exceptions.AccountException;
import com.mmn.account.model.dto.*;
import com.mmn.account.model.entity.Account;
import com.mmn.account.model.entity.Level;
import com.mmn.account.repository.AccountRepository;
import com.mmn.account.repository.LevelRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountEmailService accountEmailService;
    private final PasswordHandler passwordHandler;
    private final LevelRepository levelRepository;

    public Account save(final AccountLinkDto accountLinkDto) {
        final Account account = accountLinkDto.getAccount();
        final Optional<Account> existingAccount = this.accountRepository.findByEmail(account.getEmail());
        if (existingAccount.isPresent()) {
            log.info("Account already exists -> Update...");
            throw new AccountException("Account already exists");
            // return _update(account, existingAccount.get());
        }
        log.info("New account -> Encrypting password and saving...");
        // encryptPass
        account.setPassword(
                passwordHandler.encode(account.getPassword())
        );
        final Account savedAccount = accountRepository.save(
                account.newTokens()
        );
        //controle de nível
        createLevel(account, accountLinkDto.getParentId());
        // sendEmail
        if (Objects.nonNull(accountLinkDto.getLink())) {
            accountEmailService.sendConfirmationEmail(savedAccount, accountLinkDto.getLink());
        }
        return savedAccount.hidePassAndToken();
    }

    //criar o controle de níveis
    private void createLevel(@NonNull final Account account, final String parentId) {
        //exceto pra admin
        if (account.isAdmin() || parentId == null) {
            return;
        }
        levelRepository.save(
                Level.builder()
                        .child(account)
                        .parent(accountRepository.findById(parentId).get())
                        .build()
        ).getId();
    }

    public Account update(final Account account) {
        final Optional<Account> existing = this.accountRepository.findByEmail(account.getEmail());
        if (!existing.isPresent()) {
            return account;
        }
        account.setId(existing.get().getId());
        return accountRepository.save(account).hidePassAndToken();
    }

    public boolean exists(final Account account) {
        return this.accountRepository.existsByEmailOrPhone(account.getEmail(), account.getPhone());
    }


    public Account login(final LoginDto loginDto) {
        final Optional<Account> existingAccount = this.accountRepository.findByEmailOrPhone(loginDto.getLogin(), loginDto.getLogin());
        if (existingAccount.isPresent()) {
            final Account acc = existingAccount.get();
            if (this.passwordHandler.match(loginDto.getPassword(), acc.getPassword()))
                return acc.hidePassAndToken();
        }
        throw new AccountException("Account doesn't exist");
    }

    public boolean forgot(final ChangePassDto changePassDto) {
        final Optional<Account> existingAccount = this.accountRepository.findByEmailOrPhone(changePassDto.getEmail(), changePassDto.getEmail());
        if (existingAccount.isPresent()) {
            accountEmailService.sendRecoveryEmail(existingAccount.get(), changePassDto.getLink());
            return true;
        }
        throw new AccountException("Account doesn't exist");
    }


    public Account confirmAccount(final String id) {
        final Optional<Account> existingAccount = this.accountRepository.findById(id);
        if (existingAccount.isPresent()) {
            return accountRepository.save(existingAccount.get().confirmed());
        }
        throw new AccountException("Account doesn't exist");
    }

    public Account recoverAccount(final String token) {
        final Optional<Account> existingAccount = this.accountRepository.findByResetToken(token);
        if (existingAccount.isPresent()) {
            return this.accountRepository.save(existingAccount.get().updateToken()).hidePassAndToken();
        }
        throw new AccountException("Account doesn't exist");
    }

    public void invite(final InviteDto invite) {
        accountEmailService.sendInviteEmail(invite);
    }

    @Transactional
    public int updatePassword(final Account account) {
        log.info(account.toString());
        return accountRepository.updatePassword(
                passwordHandler.encode(
                        account.getPassword()
                ),
                account.getId()
        );
    }

    public String findByInviteToken(String inviteToken) {
        final Optional<Account> optional = accountRepository.findByInviteToken(inviteToken);
        if (optional.isPresent()) {
            if (optional.get().isinvestor()) {
                throw new AccountException("Investor do not have invites!");
            }
            return optional.get().getId();
        }
        throw new AccountException("Invalid Token");
    }

    public List<Account> all() {
        return accountRepository.findAll().stream().map(Account::hidePassAndToken).collect(Collectors.toList());
    }

    public List<LevelTreeDto> listAccountTree(final String accountId) {
        final List<LevelTreeDto> treeList = new ArrayList<>();
        final Optional<Account> optionalAccount = accountRepository.findById(accountId);
        if (!optionalAccount.isPresent()) {
            return treeList;
        }
        final LevelTreeDto top = new LevelTreeDto(optionalAccount.get().treeInfo(), new ArrayList<>());
        final List<Level> firstLevelNodes = levelRepository.findByParentId(accountId);
        for (final Level node : firstLevelNodes) {
            makeTree(node, top);
        }
        treeList.add(top);
        return treeList;
    }

    private void makeTree(Level selfNode, LevelTreeDto listTree) {
        final List<Level> children = levelRepository.findByParentId(selfNode.getChild().getId());
        final LevelTreeDto node = new LevelTreeDto(selfNode.getChild().treeInfo(), new ArrayList<>());
        listTree.getChildren().add(node);
        for (Level level : children) {
            makeTree(level, node);
        }
    }

}
