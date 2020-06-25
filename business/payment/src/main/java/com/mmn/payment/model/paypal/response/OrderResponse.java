package com.mmn.payment.model.paypal.response;

import com.mmn.payment.model.paypal.Link;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@SuppressWarnings("unused")
public class OrderResponse {

    private String id;
    private List<Link> links;
    private String status;

}
