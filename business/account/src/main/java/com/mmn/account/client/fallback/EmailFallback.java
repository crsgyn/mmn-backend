package com.mmn.account.client.fallback;

import com.mmn.account.client.EmailClient;
import com.mmn.mail.api.dto.Email;
import com.mmn.mail.impl.service.MailServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;


@Slf4j
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailFallback implements EmailClient {
    private final MailServiceImpl emailService;

    @Override
    public void sendEmail(final Email email) throws MessagingException {
        log.info("Fallback... -> Sending email directly!");
        emailService.sendEmail(email);
    }
}
