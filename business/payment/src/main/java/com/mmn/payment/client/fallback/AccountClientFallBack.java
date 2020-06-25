package com.mmn.payment.client.fallback;

import com.mmn.payment.client.AccountClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class AccountClientFallBack implements AccountClient {

    @Override
    public void updateLevelActive(final String accountId) {
        // TODO Auto-generated method stub
		log.error("could not contact account client");
    }

}
