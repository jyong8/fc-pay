package com.fcpay.membership.application.port.in;

import com.fcpay.membership.domain.Membership;
import com.fcpay.common.UseCase;

@UseCase
public interface FindMembershipUseCase {

    Membership findMembership(FindMembershipCommand command);
}
