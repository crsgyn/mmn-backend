package com.mmn.mail.impl.controller;

import com.mmn.mail.api.dto.Email;
import com.mmn.mail.api.service.EmailService;
import com.mmn.mail.impl.service.MailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MailControllerImpl implements EmailService {
    private final MailServiceImpl service;

    @PostMapping("/send")
    public void sendEmail(@RequestBody Email email) throws MessagingException {
        if (this.service.validate(email)) {
            this.service.sendEmail(email);
        }
    }
}
