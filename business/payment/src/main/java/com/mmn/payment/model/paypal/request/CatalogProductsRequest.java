package com.mmn.payment.model.paypal.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@SuppressWarnings("unused")
public class CatalogProductsRequest {

    private String category;
    private String description;
    private String homeUrl;
    private String imageUrl;
    private String name;
    private String type;

}
