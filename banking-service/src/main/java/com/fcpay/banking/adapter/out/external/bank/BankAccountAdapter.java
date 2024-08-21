package com.fcpay.banking.adapter.out.external.bank;

import com.fcpay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.fcpay.banking.adapter.out.persistence.SpringDataRegisteredBankAccountRepository;
import com.fcpay.banking.application.port.out.RegisterBankAccountPort;
import com.fcpay.banking.application.port.out.RequestBankAccountInfoPort;
import com.fcpay.banking.application.port.out.RequestExternalFirmbankingPort;
import com.fcpay.banking.domain.RegisteredBankAccount;
import com.fcpay.common.ExternalSystemAdapter;
import com.fcpay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@ExternalSystemAdapter
public class BankAccountAdapter implements RequestBankAccountInfoPort, RequestExternalFirmbankingPort {

    private final SpringDataRegisteredBankAccountRepository registeredBankAccountRepository;

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest request) {
        //실제 외부 은행에 http을 통해서
        //실제 은행 계좌 정보를 get

        return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
    }

    @Override
    public FirmbankingResult requestExternalFirmbankingPort(ExternalFirmBankingRequest request) {
        // 실제로 외부 은행에 http 통신
        // 펌뱅킹 요청

        // 결과
        // 외부 은행의 실제 결과 > 패캠페이 FirmbankingResult 파싱

        return new FirmbankingResult(0);
    }
}
