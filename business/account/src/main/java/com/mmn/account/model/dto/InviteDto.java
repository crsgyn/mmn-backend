package com.mmn.account.model.dto;

import java.util.List;

import com.mmn.account.model.entity.Account;
import lombok.Data;

@Data
public class InviteDto {

    private Account account; //no convite será a conta pai/ confirmação será a conta filho
    private List<String> emailsInvited;//to

    private String id; //id será usado na confirmacão
    private String link;
}
