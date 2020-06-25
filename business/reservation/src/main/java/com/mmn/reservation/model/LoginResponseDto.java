package com.mmn.reservation.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {
    private String token;
    private long generateTimeMilis;
    private long expireTimeMilis;
}
