package com.mmn.payment.model.paypal.request;

import com.mmn.payment.model.paypal.PurchaseUnit;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@SuppressWarnings("unused")
public class OrderRequest {

    private String intent;
    private List<PurchaseUnit> purchaseUnits;

}
