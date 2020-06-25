package com.mmn.payment.client;

import com.mmn.payment.model.paypal.request.SubscriptionRequest;
import com.mmn.payment.model.paypal.response.SubscriptionResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * NOT BEING USED
 */
@RequestMapping("catalogs/products")
interface SubscriptionClient {
    @PostMapping("billing/plans")
    SubscriptionResponse createSubscription(@RequestBody final SubscriptionRequest body);
}
