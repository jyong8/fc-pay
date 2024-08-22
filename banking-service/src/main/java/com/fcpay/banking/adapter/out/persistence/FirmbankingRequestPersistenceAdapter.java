package com.fcpay.banking.adapter.out.persistence;

import com.fcpay.banking.application.port.out.RegisterBankAccountPort;
import com.fcpay.banking.application.port.out.RequestFirmbankingPort;
import com.fcpay.banking.domain.FirmbankingRequest;
import com.fcpay.banking.domain.RegisteredBankAccount;
import com.fcpay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;


@RequiredArgsConstructor
@PersistenceAdapter
public class FirmbankingRequestPersistenceAdapter implements RequestFirmbankingPort {

    private final SpringDataFirmbankingRequestRepository repository;

    @Override
    public FirmbankingRequestJpaEntity createFirmbankingRequest(FirmbankingRequest.FromBankName fromBankName, FirmbankingRequest.FromBankAccountNumber fromBankAccountNumber, FirmbankingRequest.ToBankName toBankName, FirmbankingRequest.ToBankAccountNumber toBankAccountNumber, FirmbankingRequest.MoneyAmount moneyAmount, FirmbankingRequest.FirmbankingStatus firmbankingStatus) {
        FirmbankingRequestJpaEntity entity = repository.save(
                new FirmbankingRequestJpaEntity(
                        fromBankName.getFromBankName(),
                        fromBankAccountNumber.getFromBankAccountNumber(),
                        toBankName.getToBankName(),
                        toBankAccountNumber.getToBankAccountNumber(),
                        moneyAmount.getMoneyAmount(),
                        firmbankingStatus.getFirmbankingStatus(),
                        UUID.randomUUID()
                )
        );

        return entity;
    }

    @Override
    public FirmbankingRequestJpaEntity modifyFirmbankingRequest(FirmbankingRequestJpaEntity entity) {
        return repository.save(entity);
    }

}
