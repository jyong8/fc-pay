package com.fcpay.money.adapter.out.persistence;

import com.fcpay.common.PersistenceAdapter;
import com.fcpay.money.application.port.out.IncreaseMoneyPort;
import com.fcpay.money.domain.MemberMoney;
import com.fcpay.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@PersistenceAdapter
public class MoneyChangingPersistenceAdapter implements IncreaseMoneyPort {

    private final SpringDataMoneyChangingRepository moneyChangingRepository;

    private final SpringDataMemberMoneyRepository memberMoneyRepository;


    @Override
    public MoneyChangingRequestJpaEntity createMoneyChangingReqeust(MoneyChangingRequest.TargetMembershipId targetMembershipId, MoneyChangingRequest.ChangingType changingType, MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount, MoneyChangingRequest.ChangingMoneyStatus changingMoneyStatus, MoneyChangingRequest.Uuid uuid) {
        return moneyChangingRepository.save(
                new MoneyChangingRequestJpaEntity(
                        targetMembershipId.getTargetMembershipId(),
                        changingType.getChangingType(),
                        changingMoneyAmount.getChangingMoneyAmount(),
                        new Timestamp(System.currentTimeMillis()),
                        changingMoneyStatus.getChangingMoneyStatus(),
                        UUID.randomUUID()
                )
        );
    }

    @Override
    public MemberMoneyJpaEntity increaseMoney(MemberMoney.MembershipId membershipId, int increaseMoneyAmount) {

        MemberMoneyJpaEntity entity;
        try {
            List<MemberMoneyJpaEntity> entityList = memberMoneyRepository.findByMembershipId(Long.parseLong(membershipId.getMembershipId()));
            entity = entityList.get(0);

            entity.setBalance(entity.getBalance() + increaseMoneyAmount);
            return memberMoneyRepository.save(entity);
        } catch (Exception e){
            entity = new MemberMoneyJpaEntity(
                    membershipId.getMembershipId(),
                    increaseMoneyAmount
            );
            entity = memberMoneyRepository.save(entity);
            return entity;
        }

    }
}
