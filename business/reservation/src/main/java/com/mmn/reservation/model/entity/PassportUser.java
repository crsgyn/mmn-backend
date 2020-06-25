package com.mmn.reservation.model.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassportUser {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(length = 36)
    private String id;

    @JsonProperty("Address")
    private String Address;
    @JsonProperty("Birthday")
    private String Birthday;
    @JsonProperty("City")
    private String City;
    @JsonProperty("Country")
    private String Country;
    @JsonProperty("Email")
    private String Email;
    @JsonProperty("Contract Number")
    private String ContractNumber;
    @JsonProperty("Fax")
    private String Fax;
    @JsonProperty("FirstName")
    private String FirstName;
    @JsonProperty("Gender")
    private String Gender;
    @JsonProperty("LastName")
    private String LastName;
    @JsonProperty("Marital Status")
    private String MaritalStatus;
    @JsonProperty("Middle Name")
    private String MiddleName;
    @JsonProperty("")
    private String Nationality;
    @JsonProperty("Passport Number")
    private String PassportNumber;
    @JsonProperty("Platform Name")
    private String PlatformName;
    @JsonProperty("Referring Contract Number")
    private String ReferringContractNumber ;
    @JsonProperty("Referring User ID")
    private String ReferringUserID ;
    @JsonProperty("SaveOn User ID")
    private String SaveOnUserID;
    @JsonProperty("Savings Code")
    private String SavingsCode;
    @JsonProperty("Secondary Phone")
    private String SecondaryPhone;
    @JsonProperty("State or Province")
    private String StateOrProvince;
    @JsonProperty("Title")
    private String Title;
    @JsonProperty("Zip or Postal Code")
    private String ZipOrPostalCode;

}
