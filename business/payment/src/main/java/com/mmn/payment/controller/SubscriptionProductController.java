package com.mmn.payment.controller;

import com.mmn.payment.model.entity.Product;
import com.mmn.payment.model.entity.Renovation;
import com.mmn.payment.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * listar produtos de subscrição
 */
@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/subscription-products")
@RequiredArgsConstructor
public class SubscriptionProductController {

    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> findAll() {
        return this.productRepository.findByRenovationNotOrderByPriceAsc(Renovation.None);
    }

}
