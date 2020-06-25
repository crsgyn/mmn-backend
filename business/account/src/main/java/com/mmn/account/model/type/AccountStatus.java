package com.mmn.account.model.type;

import lombok.Getter;

@Getter
public enum AccountStatus {
    New,
    Authenticated,
    WaitingPasswordRecovery,
    Recovered,
    Canceled
}
