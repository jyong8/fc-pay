package com.fcpay.money.adapter.in.web;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncreasingMoneyChangingRequest {

    private String targetMembershipId;

    private int amount;

}
