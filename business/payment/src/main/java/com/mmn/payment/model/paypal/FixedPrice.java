
package com.mmn.payment.model.paypal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@SuppressWarnings("unused")
public class FixedPrice {

    private String currencyCode;
    private String value;

}
