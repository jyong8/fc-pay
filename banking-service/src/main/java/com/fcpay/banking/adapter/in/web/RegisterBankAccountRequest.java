package com.fcpay.banking.adapter.in.web;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterBankAccountRequest {

    private Long membershipId;

    private String bank;

    private String bankAccountNumber;

    private boolean isValid;


}
