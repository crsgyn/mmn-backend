package com.mmn.payment.repository;

import com.mmn.payment.model.entity.Subscription;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, String> {
    List<Subscription> findByAccountIdOrderByStartDesc(final String accountId, final Pageable pageable);
}
