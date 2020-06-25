package com.mmn.payment.client;

import com.mmn.payment.config.PaymentConfig;
import feign.Headers;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;

/**
 * NOT BEING USED
 */
@FeignClient(
        name = "PayPalV1",
        url = "https://api.sandbox.paypal.com/v1/",
        configuration = PaypalClientV1.PaypalClientV1Config.class
)
@Headers({"Content-Type: application/json", "Basic {clientId}:{secret}"})
public interface PaypalClientV1 extends CatalogClient, SubscriptionClient {


    class PaypalClientV1Config {

        @Bean
        @Autowired
        public BasicAuthRequestInterceptor basicAuthRequestInterceptor(final PaymentConfig config) {
            return new BasicAuthRequestInterceptor(config.getClientId(), config.getClientSecret());
        }
    }
}

