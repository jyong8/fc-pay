package com.fcpay.banking.adapter.out.persistence;

import com.fcpay.banking.domain.FirmbankingRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FirmbankingRequestMapper {

    public FirmbankingRequest mapToDomainEntity(FirmbankingRequestJpaEntity firmbankingRequestJpaEntity, UUID uuid) {
        return  FirmbankingRequest.generateFirmbankingRequest(
                    new FirmbankingRequest.FirmbankingRequestId(firmbankingRequestJpaEntity.getRequestFirmbankingId()+""),
                    new FirmbankingRequest.FromBankName(firmbankingRequestJpaEntity.getFromBankName()),
                    new FirmbankingRequest.FromBankAccountNumber(firmbankingRequestJpaEntity.getFromBankAccountNumber()),
                    new FirmbankingRequest.ToBankName(firmbankingRequestJpaEntity.getToBankName()),
                    new FirmbankingRequest.ToBankAccountNumber(firmbankingRequestJpaEntity.getToBankAccountNumber()),
                    new FirmbankingRequest.MoneyAmount(firmbankingRequestJpaEntity.getMoneyAmount()),
                    new FirmbankingRequest.FirmbankingStatus(firmbankingRequestJpaEntity.getFirmbankingStatus()),
                    uuid
        );
    }

}
