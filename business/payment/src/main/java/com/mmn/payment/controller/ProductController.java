package com.mmn.payment.controller;

import com.mmn.payment.model.entity.Product;
import com.mmn.payment.repository.ProductRepository;
import com.mmn.payment.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable("id") final String id) {
        return productRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Product save(final Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping
    public void delete(final Product product) {
        productRepository.delete(product);
    }


    @GetMapping("/my-trip/{subscriptonId}")
    public List<Product> listAvaiableMyTrip(@PathVariable String subscriptonId) {
    	return productService.listAvaiableMyTrip(subscriptonId);
    }
    
    @GetMapping("/system/{subscriptonId}")
    public List<Product> listAvaiableSystemProducts(@PathVariable String subscriptonId) {
    	return this.productService.listAvaiableSystemProducts(subscriptonId);
    }
    
}
