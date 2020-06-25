package com.mmn.payment.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mmn.payment.model.type.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Payment {
    @Id
    @Column(length = 36)
    private String id;
    @Enumerated(EnumType.STRING)
    private PaymentMethod method;
    private String value;
    private String currency_code;
    @ManyToOne
    private ShoppingCart shoppingCart;
}
