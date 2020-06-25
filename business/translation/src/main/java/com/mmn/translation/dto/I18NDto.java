package com.mmn.translation.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class I18NDto {
    private String locale;
    private Map<String, String> dictionary;
}
