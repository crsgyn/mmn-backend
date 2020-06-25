package com.mmn.mail.api.service;

import com.mmn.mail.api.dto.Email;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.mail.MessagingException;

public interface EmailService {
    @PostMapping("/send")
    void sendEmail(@RequestBody Email email) throws MessagingException;

}
