package com.mmn.account.model.dto;

import com.mmn.account.model.entity.Account;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountResponseDto {
	private Account account;
	private String levelId;
}
