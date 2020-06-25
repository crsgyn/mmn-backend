
package com.mmn.payment.model.paypal.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@SuppressWarnings("unused")
public class CatalogUpdateRequest {

    private String op;
    private String path;
    private String value;

}
