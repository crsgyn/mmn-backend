package com.mmn.reservation.exception;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ErrorInfo {
    private Date timestamp;
    private Integer status;
    private String error;
    private String message;
    private String trace;
    private String path;
}
