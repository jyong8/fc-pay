package com.fcpay.banking.application.port.in;


import com.fcpay.banking.domain.FirmbankingRequest;
import com.fcpay.common.UseCase;

@UseCase
public interface RequestFirmbankingUseCase {

    FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command);
}
