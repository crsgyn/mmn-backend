package com.mmn.account.controller;

import com.mmn.account.model.dto.*;
import com.mmn.account.model.entity.Account;
import com.mmn.account.model.entity.IDecideAccount;
import com.mmn.account.model.type.AccountStatus;
import com.mmn.account.model.type.RoleEnum;
import com.mmn.account.repository.IDecideAccountRepository;
import com.mmn.account.service.AccountService;
import com.mmn.account.service.LevelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final LevelService levelService;
    private final IDecideAccountRepository iDecideAccountRepository;

    /**
     * Account login
     *
     * @param loginDto
     * @return
     */
    @PostMapping("/login")
    public Account login(@RequestBody final LoginDto loginDto) {
        return accountService.login(loginDto);
    }

    @GetMapping
    public List<Account> listAccounts() {
        return accountService.all();
    }

    @PostMapping("/exists")
    public boolean exists(@RequestBody Account account) {
        return accountService.exists(account);
    }

    /**
     * Create influencers account (called by Admin)
     *
     * @param account
     * @return
     */
    @PostMapping("/influencers")
    public Account saveInfluencer(@RequestBody final AccountLinkDto account) {
        account.getAccount().setRole(RoleEnum.INVESTOR);
        return saveAccount(account);
    }

    /**
     * Normal save account
     *
     * @param account
     * @return
     */
    @PostMapping
    public Account saveAccount(@RequestBody final AccountLinkDto account) {
        if (Objects.isNull(account.getAccount()))
            return null;
        final Account savedAccount = accountService.save(account);
        log.debug("Account saved successfully");
        return savedAccount;
    }

    @PostMapping("/idecide-account")
    public IDecideAccount saveIDecide(@RequestBody final IDecideAccount iDecideAccount) {
        return this.iDecideAccountRepository.save(iDecideAccount);
    }

    /**
     * Update account
     *
     * @param account
     * @return
     */
    @PutMapping
    public Account updateAccount(@RequestBody final Account account) {
        final Account body = accountService.update(account);
        log.debug("Account updated successfully");
        return body;
    }

    /**
     * Send email to user to get recover Token
     *
     * @param changePassDto
     * @return
     */
    @PostMapping("/pass/forgot")
    public String forgot(@RequestBody final ChangePassDto changePassDto) {
        if (accountService.forgot(changePassDto)) {
            return AccountStatus.WaitingPasswordRecovery.toString();
        }
        return null;
    }

    /**
     * Update account password
     *
     * @param account
     */
    @PutMapping("/pass/update")
    public int updatePassword(@RequestBody final Account account) {
        return accountService.updatePassword(account);
    }

    //
    // send to to invite new commers
    @PostMapping("/invite/send")
    public void invite(@RequestBody final InviteDto invite) {
        accountService.invite(invite);
    }

    // Confirm account by email;
    @GetMapping("/mail/confirm")
    public Account confirmAccount(@RequestParam("id") final String id) {
        return accountService.confirmAccount(id);
    }

    // Confirm recover account by email;
    @GetMapping("/mail/recover")
    public Account recoverAccount(@RequestParam("token") final String token) {
        return accountService.recoverAccount(token);
    }

    // verificar invite
    // retorna o id do account parent, pai do invite ou null, se nao existir
    @PostMapping("/invite/verify-token")
    public String verifyInviteToken(@RequestBody final InviteTokenDto tokenDto) {
        return accountService.findByInviteToken(tokenDto.getInviteToken());
    }

    @PutMapping("/level/active")
    public void updateLevelActive(@RequestBody final String accountId) {
        this.levelService.validateReferralCode(accountId);
    }

    @GetMapping("/level/tree/{accountId}")
    public List<LevelTreeDto> listAccountTree(@PathVariable final String accountId) {
        return this.accountService.listAccountTree(accountId);
    }

}
