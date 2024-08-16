package com.fcpay.membership.application.port.in;

import com.fcpay.membership.adapter.in.web.ModifyMembershipRequest;
import com.fcpay.membership.domain.Membership;
import com.fcpay.common.UseCase;

@UseCase
public interface ModifyMembershipUseCase {

    Membership modifyMembership(ModifyMembershipRequest command);
}
