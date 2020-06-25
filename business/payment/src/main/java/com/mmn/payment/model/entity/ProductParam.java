package com.mmn.payment.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mmn.payment.model.type.ProductCategoryType;

import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties({"id", "booleanValue", "product"})
public class ProductParam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Product product;
	@Enumerated(EnumType.STRING)
	private ProductCategoryType param;
	private String value;
	
	public Boolean getBooleanValue() {
		try {
			return Boolean.valueOf(this.value);
		} catch (Exception e) {
			return false;
		}
	}
	
	public void setBooleanValue(Boolean value) {
		try {
			this.value = value.toString();
		} catch (Exception e) {
			
		}
	}
	
	public ProductParam productParam() {
		return this;
	}

	public boolean containsValue() {
		try {
			return Integer.valueOf(this.value) > 0;
		} catch (NumberFormatException e) {
			return Boolean.valueOf(this.value);
		}
	}
	
}
