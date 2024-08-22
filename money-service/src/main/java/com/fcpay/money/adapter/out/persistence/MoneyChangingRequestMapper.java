package com.fcpay.money.adapter.out.persistence;

import com.fcpay.money.domain.MoneyChangingRequest;
import org.springframework.stereotype.Component;

@Component
public class MoneyChangingRequestMapper {

    public MoneyChangingRequest mapToDomainEntity(MoneyChangingRequestJpaEntity entity) {
        return  MoneyChangingRequest.generateMoneyChangingRequest(
                //new MoneyChangingRequest.MoneyChangingRequestId(entity.getMoneyChangingRequestId()+""),
                new MoneyChangingRequest.TargetMembershipId(entity.getTargetMembershipId()),
                new MoneyChangingRequest.ChangingType(entity.getMoneyChangingType()),
                new MoneyChangingRequest.ChangingMoneyAmount(entity.getMoneyAmount()),
                new MoneyChangingRequest.ChangingMoneyStatus(entity.getChangingMoneyStatus()),
                new MoneyChangingRequest.Uuid(entity.getUuid())
        );
    }

}
