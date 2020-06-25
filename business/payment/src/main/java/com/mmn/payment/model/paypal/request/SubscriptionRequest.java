package com.mmn.payment.model.paypal.request;

import com.mmn.payment.model.paypal.BillingCycle;
import com.mmn.payment.model.paypal.PaymentPreferences;
import com.mmn.payment.model.paypal.Taxes;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@SuppressWarnings("unused")
public class SubscriptionRequest {

    private List<BillingCycle> billingCycles;
    private String description;
    private String name;
    private PaymentPreferences paymentPreferences;
    private String productId;
    private String status;
    private Taxes taxes;

}
