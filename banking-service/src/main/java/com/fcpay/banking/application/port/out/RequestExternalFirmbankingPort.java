package com.fcpay.banking.application.port.out;

import com.fcpay.banking.adapter.out.external.bank.ExternalFirmBankingRequest;
import com.fcpay.banking.adapter.out.external.bank.FirmbankingResult;

public interface RequestExternalFirmbankingPort {

    FirmbankingResult requestExternalFirmbankingPort(ExternalFirmBankingRequest request);
}
