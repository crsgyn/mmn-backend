package com.mmn.reservation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FullLoginDto implements Serializable {
    @JsonProperty("APIUsername")
    private String APIUsername;
    @JsonProperty("APIPassword")
    private String APIPassword;
    @JsonProperty("Email")
    private String Email;
    @JsonProperty("ContractNumber")
    private String ContractNumber;
}
