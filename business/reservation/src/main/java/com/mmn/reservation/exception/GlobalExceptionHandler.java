package com.mmn.reservation.exception;

import com.google.common.base.Throwables;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignErrorException.class)
    public String handleFeignErrorException(
            final FeignErrorException e,
            final HttpServletResponse response) {
        response.setStatus(HttpStatus.OK.value());
        return e.getBody();
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
