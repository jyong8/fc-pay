package com.fcpay.money.application.port.in;

import com.fcpay.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class IncreaseMoneyRequestCommand extends SelfValidating<IncreaseMoneyRequestCommand> {

    @NotNull
    private final String targetMembershipId;

    @NotNull
    private final int amount;

    public IncreaseMoneyRequestCommand(String targetMembershipId, int amount) {
        this.targetMembershipId = targetMembershipId;
        this.amount = amount;
        this.validateSelf();
    }
}
