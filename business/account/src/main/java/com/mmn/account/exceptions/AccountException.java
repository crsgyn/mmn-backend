package com.mmn.account.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccountException extends RuntimeException {

    public AccountException(final String message) {
        super(message);
        log.error(message);
    }
}
