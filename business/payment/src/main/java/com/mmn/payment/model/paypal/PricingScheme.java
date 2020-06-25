
package com.mmn.payment.model.paypal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@SuppressWarnings("unused")
public class PricingScheme {

    private String createTime;
    private FixedPrice fixedPrice;
    private String status;
    private String updateTime;
    private Long version;

}
