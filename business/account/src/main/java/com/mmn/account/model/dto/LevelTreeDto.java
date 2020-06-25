package com.mmn.account.model.dto;

import java.util.List;

import com.mmn.account.model.entity.Account;

import com.mmn.account.model.entity.Level;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LevelTreeDto {
	private Account parent;
	private List<LevelTreeDto> children;
}
