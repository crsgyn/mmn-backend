package com.mmn.account.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PassRecoveryDto {
    private String id;
    private String token;
    private String newPassword;
}
