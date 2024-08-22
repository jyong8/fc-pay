package com.fcpay.money.application.service;

import com.fcpay.common.UseCase;
import com.fcpay.money.adapter.in.web.MoneyChangingResultDetail;
import com.fcpay.money.adapter.out.persistence.MemberMoneyJpaEntity;
import com.fcpay.money.adapter.out.persistence.MoneyChangingRequestMapper;
import com.fcpay.money.application.port.in.IncreaseMoneyRequestCommand;
import com.fcpay.money.application.port.in.IncreaseMoneyRequestUseCase;
import com.fcpay.money.application.port.out.IncreaseMoneyPort;
import com.fcpay.money.domain.MemberMoney;
import com.fcpay.money.domain.MoneyChangingRequest;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.UUID;

@RequiredArgsConstructor
@UseCase
@Transactional
public class IncreaseMoneyRequestService implements IncreaseMoneyRequestUseCase {

    private final IncreaseMoneyPort increaseMoneyPort;

    private final MoneyChangingRequestMapper mapper;

    @Override
    public MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command) {
        // 머니의 충전/증액 과정
        // 1. 고객 정보 정상여부 확인 (외부 어댑터 필요 : 멤버)

        // 2. 고객 연동 계좌가 있는지, 잔액이 충분한지 확인 (외부 어댑터 필요 : 뱅킹)

        // 3. 법인 계좌 정상여부 확인 (외부 어댑터 필요 : 뱅킹)

        // 4. 증액을 위한 기록(히스토리) 요청상태로 MoneyChangingRequest 생성 (MoneyChangingRequest)

        // 5. 펌뱅킹 수행 (고객 연동 계좌 > 패캠페이 법인 계좌) (외부 어댑터 필요 : 뱅킹)

        // 6-1. 수행 결과 정상 - 성공으로 MoneyChangingRequest 상태값을 변동 후에 리턴

        //성공 시 멤버의 MemberMoney 값 증액
        MemberMoneyJpaEntity memberMoneyJpaEntity = increaseMoneyPort.increaseMoney(
                new MemberMoney.MembershipId(command.getTargetMembershipId()),
                command.getAmount()
        );

        if(memberMoneyJpaEntity != null) {
            return mapper.mapToDomainEntity(increaseMoneyPort.createMoneyChangingReqeust(
                    new MoneyChangingRequest.TargetMembershipId(command.getTargetMembershipId()),
                    new MoneyChangingRequest.ChangingType(1),
                    new MoneyChangingRequest.ChangingMoneyAmount(command.getAmount()),
                    new MoneyChangingRequest.ChangingMoneyStatus(1),
                    new MoneyChangingRequest.Uuid(UUID.randomUUID())
            ));
        }


        return null;
        // 6-2. 수행 결과 실패 - 실패라고 MoneyChangingRequest 상태값을 변동 후에 리턴

    }
}
