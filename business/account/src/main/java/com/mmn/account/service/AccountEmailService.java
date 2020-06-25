package com.mmn.account.service;

import com.mmn.account.client.EmailClient;
import com.mmn.account.config.AccountAsyncTaskConfig;
import com.mmn.account.exceptions.EmailException;
import com.mmn.account.model.dto.InviteDto;
import com.mmn.account.model.entity.Account;
import com.mmn.mail.api.dto.Email;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountEmailService {
    private static final String CONFIRMATION_SUB = "Travined - Welcome! just need to confirm your Account! :)";
    private static final String RECOVERY_SUB = "Travined - Forgot your password? don't worry! :)";
    private static final String INVITE_SUB = "Travined - You received an invitation to join us! :)";

    private final EmailClient emailService;

    @Async(AccountAsyncTaskConfig.THREAD_POOL_TASK_EXECUTOR)
    public void sendConfirmationEmail(final Account account, final String link) {
        log.info("Sending confirmation to...");
        try {
            emailService.sendEmail(
                    Email.builder()
                            .to(account.getEmail())
                            .subject(CONFIRMATION_SUB)
                            .text(link + account.getId())
                            .build());
        } catch (final MessagingException e) {
            throw new EmailException(e.getStackTrace().toString());
        }
    }

    @Async(AccountAsyncTaskConfig.THREAD_POOL_TASK_EXECUTOR)
    public void sendRecoveryEmail(final Account account, final String link) {
        log.info("Sending recovery to...");
        try {
            emailService.sendEmail(
                    Email.builder()
                            .to(account.getEmail())
                            .subject(RECOVERY_SUB)
                            .text(link + account.getResetToken())
                            .build());
        } catch (final MessagingException e) {
            throw new EmailException(e.getStackTrace().toString());
        }
    }

    @Async(AccountAsyncTaskConfig.THREAD_POOL_TASK_EXECUTOR)
    public void sendInviteEmail(final InviteDto invite) {
        log.info("Sending invite to...");
        invite.getEmailsInvited().forEach(
                email -> {
                    try {
                        emailService.sendEmail(
                                Email.builder()
                                        .to(email)
                                        .subject(INVITE_SUB)
                                        .text(invite.getLink() + invite.getAccount().getInviteToken())
                                        .build()
                        );
                    } catch (MessagingException e) {
                        log.error(e.getStackTrace().toString());
                    }
                }
        );
    }

}
