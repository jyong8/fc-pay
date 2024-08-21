package com.fcpay.banking.application.service;

import com.fcpay.banking.adapter.out.external.bank.BankAccount;
import com.fcpay.banking.adapter.out.external.bank.GetBankAccountRequest;
import com.fcpay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.fcpay.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.fcpay.banking.application.port.in.RegisterBankAccountCommand;
import com.fcpay.banking.application.port.in.RegisterBankAccountUseCase;
import com.fcpay.banking.application.port.out.RegisterBankAccountPort;
import com.fcpay.banking.application.port.out.RequestBankAccountInfoPort;
import com.fcpay.banking.domain.RegisteredBankAccount;
import com.fcpay.common.UseCase;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;

    private final RequestBankAccountInfoPort requestBankAccountInfoPort;

    private final RegisteredBankAccountMapper mapper;

    @Override
    public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {

        //은행 계좌를 등록해야하는 서비스(비즈니스 로직)
        // command.getMembershipId()

        //1. 등록 된 계좌인지 확인 > '외부' 은행에 이 계좌가 정상인지 확인
        //Biz Logic > External System
        //Port > Adapter > External System
        //Port
        //실제 외부의 은행계좌 정보를 Get
        BankAccount accountInfo = requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));
        boolean accountIsValid = accountInfo.isValid();

        //2. 등록 가능 > 등록 > 성공 > 성공한 등록 정보 리턴
        //2-1. 등록 가능x 계좌 > 에러 리턴
        if (accountIsValid) {
            RegisteredBankAccountJpaEntity savedAccountInfo = registerBankAccountPort.createRegisteredBankAccount(
                    //new RegisteredBankAccount.RegisteredBankAccountId(command.getBankAccountNumber()),
                    new RegisteredBankAccount.MembershipId(command.getMembershipId()),
                    new RegisteredBankAccount.BankName(command.getBankName()),
                    new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                    new RegisteredBankAccount.LinkedStatusIsValid(command.isValid())
            );
            return mapper.mapToDomainEntity(savedAccountInfo);
        }else{
            return null;
        }

    }

}
