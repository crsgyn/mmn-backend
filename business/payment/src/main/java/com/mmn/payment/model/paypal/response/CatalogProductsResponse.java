package com.mmn.payment.model.paypal.response;

import com.mmn.payment.model.paypal.Link;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@SuppressWarnings("unused")
public class CatalogProductsResponse {

    private String category;
    private String createTime;
    private String description;
    private String homeUrl;
    private String id;
    private String imageUrl;
    private List<Link> links;
    private String name;
    private String type;
    private String updateTime;

}
