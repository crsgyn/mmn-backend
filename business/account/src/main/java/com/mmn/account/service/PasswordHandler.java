package com.mmn.account.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PasswordHandler {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String encode(final String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public boolean match(final String rawPass, final String encodedPass) {
        return bCryptPasswordEncoder.matches(rawPass, encodedPass);
    }
}
