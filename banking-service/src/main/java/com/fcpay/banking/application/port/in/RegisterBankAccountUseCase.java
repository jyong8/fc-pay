package com.fcpay.banking.application.port.in;


import com.fcpay.banking.domain.RegisteredBankAccount;
import com.fcpay.common.UseCase;

@UseCase
public interface RegisterBankAccountUseCase {

    RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command);
}
