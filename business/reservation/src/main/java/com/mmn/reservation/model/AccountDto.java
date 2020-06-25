package com.mmn.reservation.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {
    @JsonProperty("Email")
    private String Email;
    @JsonProperty("ContractNumber")
    private String ContractNumber;
    @JsonProperty("Password")
    private String Password;
    @JsonProperty("FirstName")
    private String FirstName;
    @JsonProperty("LastName")
    private String LastName;
    @JsonProperty("Address")
    private String Address;
    @JsonProperty("City")
    private String City;
    @JsonProperty("TwoLetterCountryCode")
    private String TwoLetterCountryCode;
    @JsonProperty("Phone")
    private String Phone;
    @JsonProperty("UserAccountTypeId")
    private String UserAccountTypeId;
    @JsonProperty("ReferringUserId")
    private String ReferringUserId;
}
