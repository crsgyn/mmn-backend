package com.mmn.payment.client;

import com.mmn.payment.model.paypal.request.CatalogProductsRequest;
import com.mmn.payment.model.paypal.request.CatalogUpdateRequest;
import com.mmn.payment.model.paypal.response.CatalogProductsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * NOT BEING USED
 */
@RequestMapping("catalogs/products")
interface CatalogClient {
    @PostMapping
    CatalogProductsResponse createProduct(@RequestBody final CatalogProductsRequest body);

    @GetMapping
    List<CatalogProductsResponse> listProducts();

    @PatchMapping
    ResponseEntity<?> updateCatalog(@PathVariable final String product_id, @RequestBody final CatalogUpdateRequest body);
}
