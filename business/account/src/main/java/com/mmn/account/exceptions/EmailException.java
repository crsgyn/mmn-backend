package com.mmn.account.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailException extends RuntimeException {

    public EmailException(String message) {
        super();
        log.error(message);
    }
}
