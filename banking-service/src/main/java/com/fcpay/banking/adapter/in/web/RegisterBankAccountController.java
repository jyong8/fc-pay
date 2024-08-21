package com.fcpay.banking.adapter.in.web;

import com.fcpay.banking.application.port.in.RegisterBankAccountCommand;
import com.fcpay.banking.application.port.in.RegisterBankAccountUseCase;
import com.fcpay.banking.domain.RegisteredBankAccount;
import com.fcpay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registerBankAccountUseCase;

    @PostMapping(path = "/banking/account/register")
    RegisteredBankAccount registerBankAccount(@RequestBody RegisterBankAccountRequest request) {

        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .membershipId(request.getMembershipId())
                .bankName(request.getBank())
                .bankAccountNumber(request.getBankAccountNumber())
                .isValid(true)
                .build();

        RegisteredBankAccount registeredBankAccount = registerBankAccountUseCase.registerBankAccount(command);
        if(registeredBankAccount == null) {
            return null;
        }

        return registeredBankAccount;
    }


}
