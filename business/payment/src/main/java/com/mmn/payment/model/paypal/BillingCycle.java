package com.mmn.payment.model.paypal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@SuppressWarnings("unused")
public class BillingCycle {

    private Frequency frequency;
    private PricingScheme pricingScheme;
    private Long sequence;
    private String tenureType;
    private Long totalCycles;

}
