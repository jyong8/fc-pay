package com.fcpay.money.application.port.out;

import com.fcpay.money.adapter.out.persistence.MemberMoneyJpaEntity;
import com.fcpay.money.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import com.fcpay.money.domain.MemberMoney;
import com.fcpay.money.domain.MoneyChangingRequest;

public interface IncreaseMoneyPort {

    MoneyChangingRequestJpaEntity createMoneyChangingReqeust(
            MoneyChangingRequest.TargetMembershipId targetMembershipId,
            MoneyChangingRequest.ChangingType changingType,
            MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
            MoneyChangingRequest.ChangingMoneyStatus changingMoneyStatus,
            MoneyChangingRequest.Uuid uuid
    );

    MemberMoneyJpaEntity increaseMoney(
            MemberMoney.MembershipId membershipId,
            int increaseMoneyAmount
    );
}
