package com.mmn.reservation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListMembersResponseDto {

    @JsonProperty("UserID")
    private Integer UserID;
    @JsonProperty("Email")
    private String Email;
    @JsonProperty("ContractNumber")
    private String ContractNumber;
    @JsonProperty("OtherID")
    private String OtherID;
    @JsonProperty("VacationClubId")
    private Integer VacationClubId;

    @JsonProperty("CurrentPointBalance")
    private Integer CurrentPointBalance;
    @JsonProperty("DateCreated")
    private String DateCreated;
    @JsonProperty("ExpirationDate")
    private String ExpirationDate;

    @JsonProperty("MyUserSettings")
    private List<Map<String, String>> MyUserSettings;

    @JsonProperty("PrimaryPerson")
    private PrimaryPerson PrimaryPerson;

    @JsonProperty("Reason")
    private String Reason;

    @JsonProperty("Status")
    private String Status;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class PrimaryPerson {
        @JsonProperty("StreetAddress")
        private String StreetAddress;
        @JsonProperty("City")
        private String City;
        @JsonProperty("State")
        private String State;
        @JsonProperty("Country")
        private String Country;
        @JsonProperty("FirstName")
        private String FirstName;
        @JsonProperty("LastName")
        private String LastName;
        @JsonProperty("Phone")
        private String Phone;
        @JsonProperty("PostalCode")
        private String PostalCode;
        @JsonProperty("SecondaryPhone")
        private String SecondaryPhone;
    }
}
