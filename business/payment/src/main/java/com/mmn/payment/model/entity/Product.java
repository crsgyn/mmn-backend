package com.mmn.payment.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mmn.payment.model.type.ProductCategoryType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Table(
		indexes = {
				@Index(columnList = "category")
		}
		)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(length=36)
    private String id;
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private ProductCategoryType category;
    private String imageUrl;
    //marca se produto é um subscricao <> None
    @Enumerated(EnumType.STRING)
    private Renovation renovation = Renovation.None;
    private BigDecimal price; 
    private BigDecimal priceTC;
    @OneToMany(targetEntity = ProductParam.class, mappedBy = "product")
    private List<ProductParam> params = new ArrayList<>();

    private BigDecimal renovationPrice; 
    private BigDecimal renovationPriceTC;

    //usado para ser mapeado
    public ProductParam param(ProductCategoryType type) {
    	return params.stream().collect(
    			Collectors.toMap(ProductParam::getParam, ProductParam::productParam)
    			).get(type);
    }

	public ProductCategoryType contains(ProductCategoryType productCategoryType) {
		Optional<ProductParam> param = this.params.stream().filter(
				p -> p.getParam().equals(productCategoryType)
				).findFirst();
		if (param.isPresent() && param.get().containsValue()) {
			return productCategoryType;
		}
		return null;
	}
    
}
