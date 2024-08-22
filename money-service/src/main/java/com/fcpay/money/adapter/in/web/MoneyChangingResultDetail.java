package com.fcpay.money.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingResultDetail {

    private String moneyChangingRequestId;

    private int moneyChangingType;// enum 0 증액 1 감액

    private int MoneyChangingResultStatus;

    private int amount;

}

enum MoneyChangingType{
    INCRESING,
    DECRESING,
}

enum MoneyChangingResultStatus{
    SUCCEDED,
    FAILED,
    FAILED_NOT_EXIST_MEMBERSHIP,
    FAILED_NOT_ENOUGH_MONEY,
    FAILED_NOT_EXIST_MONEY_CHANGING_REQUEST,
}