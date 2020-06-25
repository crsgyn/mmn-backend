
package com.mmn.payment.model.paypal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@SuppressWarnings("unused")
public class Taxes {

    private Boolean inclusive;
    private String percentage;

}
