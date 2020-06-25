package com.mmn.account.controller.advice;

import com.google.common.base.Throwables;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestControllerAdvice
public class AccountControllerAdvice {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorInfo> duplicatePhoneOrEmail(final HttpServletRequest req, final DataIntegrityViolationException e) {
        final int httpStatus = HttpStatus.CONFLICT.value();
        return ResponseEntity.status(httpStatus).body(ErrorInfo.builder()
                .timestamp(new Date())
                .status(httpStatus)
                .error(DataIntegrityViolationException.class.toString())
                .message(e.getRootCause().getMessage())
                .trace(Throwables.getStackTraceAsString(e))
                .path(req.getPathInfo())
                .build());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorInfo> anyRuntimeException(final HttpServletRequest req, final RuntimeException e) {
        final int httpStatus = HttpStatus.CONFLICT.value();
        return ResponseEntity.status(httpStatus).body(ErrorInfo.builder()
                .timestamp(new Date())
                .status(httpStatus)
                .error(RuntimeException.class.toString())
                .message(e.getMessage())
                .trace(Throwables.getStackTraceAsString(e))
                .path(req.getPathInfo())
                .build());
    }
}
