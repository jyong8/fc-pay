package com.fcpay.membership.application.port.in;


import com.fcpay.common.UseCase;
import com.fcpay.membership.domain.Membership;

@UseCase
public interface RegisterMembershipUseCase {

    Membership registerMembership(RegisterMembershipCommand command);
}
