package com.mmn.reservation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDto {

    @JsonProperty("Account")
    private Account Account;
    @JsonProperty("ResultType")
    private String ResultType;
    @JsonProperty("Message")
    private String Message;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Account {
        @JsonProperty("UserId")
        private String UserId;
    }
}
