package com.fcpay.money.application.port.in;


import com.fcpay.common.UseCase;
import com.fcpay.money.adapter.in.web.MoneyChangingResultDetail;
import com.fcpay.money.domain.MoneyChangingRequest;

@UseCase
public interface IncreaseMoneyRequestUseCase {

    MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command);
}
