package com.mmn.payment.service;

import com.mmn.payment.model.entity.Product;
import com.mmn.payment.model.entity.ShoppingCart;
import com.mmn.payment.repository.CartProductRepository;
import com.mmn.payment.repository.ProductRepository;
import com.mmn.payment.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final CartProductRepository cartProductRepository;
    private final ProductRepository productRepository;

    public ShoppingCart save(final ShoppingCart cart) {
        final ShoppingCart save = shoppingCartRepository.save(cart);
        save.getProducts().stream().forEach(cartProduct -> {
            cartProduct.setShoppingCart(save);
            final Optional<Product> byId = productRepository.findById(cartProduct.getProduct().getId());
            cartProduct.setProduct(byId.get());
            cartProductRepository.save(cartProduct);
        });
        return save;
    }

    public Optional<ShoppingCart> byId(final String  id) {
        return this.shoppingCartRepository.findById(id);
    }

    public void delete(final ShoppingCart shoppingCart) {
        this.shoppingCartRepository.delete(shoppingCart);
    }
}
