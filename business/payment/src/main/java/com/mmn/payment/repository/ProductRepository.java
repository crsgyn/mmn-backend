package com.mmn.payment.repository;

import com.mmn.payment.model.entity.Product;
import com.mmn.payment.model.entity.Renovation;
import com.mmn.payment.model.type.ProductCategoryType;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByRenovationNotOrderByPriceAsc(final Renovation renovationNone);

	List<Product> findByCategoryIn(List<ProductCategoryType> list);
    
}
