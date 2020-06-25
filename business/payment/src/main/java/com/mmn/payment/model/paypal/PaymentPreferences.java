
package com.mmn.payment.model.paypal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@SuppressWarnings("unused")
public class PaymentPreferences {

    private Boolean autoBillOutstanding;
    private Long paymentFailureThreshold;
    private SetupFee setupFee;
    private String setupFeeFailureAction;

}
