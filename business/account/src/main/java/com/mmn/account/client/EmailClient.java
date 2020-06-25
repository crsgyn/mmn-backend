package com.mmn.account.client;

import com.mmn.account.client.fallback.EmailFallback;
import com.mmn.mail.api.service.EmailService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "${MMN_BUSINESS_MAIL_NAME:business-mail-service}",
        fallback = EmailFallback.class
)
public interface EmailClient extends EmailService {
}
