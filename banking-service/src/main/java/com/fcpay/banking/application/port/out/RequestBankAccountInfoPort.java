package com.fcpay.banking.application.port.out;

import com.fcpay.banking.adapter.out.external.bank.BankAccount;
import com.fcpay.banking.adapter.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {

    BankAccount getBankAccountInfo(GetBankAccountRequest request);

}
