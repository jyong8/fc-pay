package com.fcpay.banking.adapter.out.persistence;

import com.fcpay.banking.application.port.out.RegisterBankAccountPort;
import com.fcpay.banking.domain.RegisteredBankAccount;
import com.fcpay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@PersistenceAdapter
public class RegisteredBankAccountAdapter implements RegisterBankAccountPort {

    private final SpringDataRegisteredBankAccountRepository registeredBankAccountRepository;


    @Override
    public RegisteredBankAccountJpaEntity createRegisteredBankAccount(RegisteredBankAccount.MembershipId membershipId, RegisteredBankAccount.BankName bankName, RegisteredBankAccount.BankAccountNumber bankAccountNumber, RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid) {
        return registeredBankAccountRepository.save(
                new RegisteredBankAccountJpaEntity(
                        membershipId.getMembershipId(),
                        bankName.getBankName(),
                        bankAccountNumber.getBankAccountNumber(),
                        linkedStatusIsValid.isLinkedStatusIsValid()
                )
        );
    }
}
