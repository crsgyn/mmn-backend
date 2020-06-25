package com.mmn.account;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class PasswordMain {
    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    static void encode(String password) {
        System.out.println(bCryptPasswordEncoder.encode(password));
    }

    public static void main(String[] args) {
        encode("travined123");
    }
}
