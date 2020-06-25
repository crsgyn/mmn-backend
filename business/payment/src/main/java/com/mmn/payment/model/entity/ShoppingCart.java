package com.mmn.payment.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mmn.payment.model.Address;
import com.mmn.payment.model.type.ShoppingCartStatus;
import com.mmn.payment.model.type.ShoppingType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShoppingCart {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(length=36)
    private String id;
    @Column(length=36)
    private String accountId;
    @Embedded
    private Address alternativeAddress;
    @OneToMany(targetEntity = CartProduct.class, mappedBy = "shoppingCart")
    @JsonIgnoreProperties("shoppingCart")
    private List<CartProduct> products;
    private LocalDate creationDate;
    private ShoppingType shoppingType;
    private ShoppingCartStatus shoppingCartStatus;

    @JsonProperty("productDescription")
    public String getProductDescription() {
        try {
            return products.stream().map(p -> p.getProduct().getDescription()).collect(Collectors.joining(","));
        } catch (Exception e) {
            return null;
        }
    }

	public boolean isSubscrition() {
		return this.shoppingType.equals(ShoppingType.Subscription);
	}

	public boolean isRenovation() {
		return this.shoppingType.equals(ShoppingType.Renovation);
	}
}
