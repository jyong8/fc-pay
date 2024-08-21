package com.fcpay.banking.application.service;

import com.fcpay.banking.adapter.out.external.bank.ExternalFirmBankingRequest;
import com.fcpay.banking.adapter.out.external.bank.FirmbankingResult;
import com.fcpay.banking.adapter.out.persistence.FirmbankingRequestJpaEntity;
import com.fcpay.banking.adapter.out.persistence.FirmbankingRequestMapper;
import com.fcpay.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.fcpay.banking.application.port.in.RequestFirmbankingCommand;
import com.fcpay.banking.application.port.in.RequestFirmbankingUseCase;
import com.fcpay.banking.application.port.out.RegisterBankAccountPort;
import com.fcpay.banking.application.port.out.RequestBankAccountInfoPort;
import com.fcpay.banking.application.port.out.RequestExternalFirmbankingPort;
import com.fcpay.banking.application.port.out.RequestFirmbankingPort;
import com.fcpay.banking.domain.FirmbankingRequest;
import com.fcpay.common.UseCase;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.UUID;

@RequiredArgsConstructor
@UseCase
@Transactional
public class RequestFirmbankingService implements RequestFirmbankingUseCase {

    private final FirmbankingRequestMapper mapper;
    private final RequestFirmbankingPort requestFirmbankingPort;

    private final RequestExternalFirmbankingPort requestExternalFirmbankingPort;


    @Override
    public FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command) {

        //Business Login
        // a > b 계좌

        //1. 요청에 대해 정보를 먼저 write "요청" 상태로
        FirmbankingRequestJpaEntity requestedEntity = requestFirmbankingPort.createFirmbankingRequest(
                new FirmbankingRequest.FromBankName(command.getFromBankName()),
                new FirmbankingRequest.FromBankAccountNumber(command.getFromBankAccountNumber()),
                new FirmbankingRequest.ToBankName(command.getToBankName()),
                new FirmbankingRequest.ToBankAccountNumber(command.getToBankAccountNumber()),
                new FirmbankingRequest.MoneyAmount(command.getMoneyAmount()),
                new FirmbankingRequest.FirmbankingStatus(0)
        );

        //2. 외부 은행에 펌뱅킹 요청
        FirmbankingResult result = requestExternalFirmbankingPort.requestExternalFirmbankingPort(new ExternalFirmBankingRequest(
                command.getFromBankName(),
                command.getFromBankAccountNumber(),
                command.getToBankName(),
                command.getToBankAccountNumber(),
                command.getMoneyAmount()
        ));

        //Transaction
        UUID randomUUID = UUID.randomUUID();
        requestedEntity.setUuid(randomUUID);

        //3. 결과에 딸라서 1번에 작성했던 FirmbankingRequest 정보를 update
        if (result.getResultCode() == 0){
            requestedEntity.setFirmbankingStatus(1);
        } else {
            requestedEntity.setFirmbankingStatus(2);
        }

        //4. 결과를 return
        return mapper.mapToDomainEntity(requestFirmbankingPort.modifyFirmbankingRequest(requestedEntity), randomUUID);
    }
}
