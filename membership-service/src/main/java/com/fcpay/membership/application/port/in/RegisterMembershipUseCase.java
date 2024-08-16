package com.fcpay.membership.application.port.in;

import common.UseCase;
import com.fcpay.membership.domain.Membership;

@UseCase
public interface RegisterMembershipUseCase {

    Membership registerMembership(RegisterMembershipCommand command);
}
