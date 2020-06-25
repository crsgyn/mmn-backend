package com.mmn.reservation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ListMembersDto {
    @JsonProperty("APIUsername")
    private String APIUsername;
    @JsonProperty("APIPassword")
    private String APIPassword;
    @JsonProperty("MemberSearchList")
    private List<MemberSearchListDto> MemberSearchList;

    @Data
    @Builder
    public static class MemberSearchListDto {
        @JsonProperty("Email")
        private String Email;
        @JsonProperty("ContractNumber")
        private String ContractNumber;
        @JsonProperty("OtherID")
        private String OtherID;

    }
}
