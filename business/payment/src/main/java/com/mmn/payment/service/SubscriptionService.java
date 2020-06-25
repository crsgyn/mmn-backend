package com.mmn.payment.service;

import com.mmn.payment.model.entity.Product;
import com.mmn.payment.model.entity.Subscription;
import com.mmn.payment.model.type.ProductCategoryType;
import com.mmn.payment.repository.SubscriptionRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public Subscription findLatestSubscriptionBy(@NonNull final String accountId) {
        try {
            return subscriptionRepository.findByAccountIdOrderByStartDesc(
                    accountId,
                    PageRequest.of(0, 1)
            ).iterator().next();
        } catch (Exception e) {
            return null;
        }
    }

    public void createSubscription(@NonNull final String accountId, @NonNull final Product product) {
        Subscription subscription = findLatestSubscriptionBy(accountId);
        subscription = subscription == null ? new Subscription() : subscription;
        if (subscription.getInvitationLeft() == null) {
            final Optional<String> invitesLeft = product.getParams()
                    .stream()
                    .filter(Objects::nonNull)
                    .filter(productParam -> productParam.getParam().equals(ProductCategoryType.UNLIMITED_PASSPORTS_TO_SEND))
                    .findFirst()
                    .map(productParam -> productParam.getValue());
            if (invitesLeft.isPresent()) {
                subscription.setInvitationLeft(Integer.parseInt(invitesLeft.get()));
            }
        }
        subscription.setProduct(product);
        subscription.setAccountId(accountId);
        this.subscriptionRepository.save(subscription.toBegin());
    }

	public void toRenovation(String accountId) {
		Subscription subscription = findLatestSubscriptionBy(accountId);
		this.subscriptionRepository.save(
				subscription.toRenovation()
				);
	}

}
