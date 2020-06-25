package com.mmn.reservation.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FeignErrorException extends Exception {
    final int status;
    final String reason;
    final String body;
}
