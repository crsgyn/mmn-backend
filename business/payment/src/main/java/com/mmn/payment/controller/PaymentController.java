package com.mmn.payment.controller;

import com.mmn.payment.model.entity.Payment;
import com.mmn.payment.service.PaymentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public Payment save(@RequestBody final Payment payment) {
        final Payment savedPayment = paymentService.save(payment);        
        return savedPayment;
    }
    
}
