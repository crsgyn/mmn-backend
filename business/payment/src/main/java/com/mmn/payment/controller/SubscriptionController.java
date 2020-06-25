package com.mmn.payment.controller;

import com.mmn.payment.model.entity.Subscription;
import com.mmn.payment.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @GetMapping("/{accountId}")
    public Subscription findLatestSubscriptionBy(@PathVariable("accountId") final String accountId) {
        return subscriptionService.findLatestSubscriptionBy(accountId);
    }

}
