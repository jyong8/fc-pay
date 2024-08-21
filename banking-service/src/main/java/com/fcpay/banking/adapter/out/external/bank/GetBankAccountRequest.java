package com.fcpay.banking.adapter.out.external.bank;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class GetBankAccountRequest {

    private String bankName;
    private String bankAccountNumber;


    public GetBankAccountRequest(String bankName, String bankAccountNumber) {
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
    }
}
