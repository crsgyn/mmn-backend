package com.mmn.account.model.dto;

import lombok.Data;

@Data
public class ChangePassDto {
    private String email;
    private String newPass;
    private String link;
}
