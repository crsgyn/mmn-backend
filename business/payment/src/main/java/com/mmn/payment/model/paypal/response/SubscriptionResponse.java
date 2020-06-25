
package com.mmn.payment.model.paypal.response;

import com.mmn.payment.model.paypal.BillingCycle;
import com.mmn.payment.model.paypal.Link;
import com.mmn.payment.model.paypal.PaymentPreferences;
import com.mmn.payment.model.paypal.Taxes;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@SuppressWarnings("unused")
public class SubscriptionResponse {

    private List<BillingCycle> billingCycles;
    private String createTime;
    private String description;
    private String id;
    private List<Link> links;
    private String name;
    private PaymentPreferences paymentPreferences;
    private String productId;
    private String status;
    private Taxes taxes;
    private String updateTime;

}
