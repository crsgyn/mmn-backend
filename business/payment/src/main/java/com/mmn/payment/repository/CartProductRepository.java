package com.mmn.payment.repository;

import com.mmn.payment.model.entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProduct, String> {
}
