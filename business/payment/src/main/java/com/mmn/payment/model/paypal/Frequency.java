
package com.mmn.payment.model.paypal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@SuppressWarnings("unused")
public class Frequency {

    private Long intervalCount;
    private String intervalUnit;

}
