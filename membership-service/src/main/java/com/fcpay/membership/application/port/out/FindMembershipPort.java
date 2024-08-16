package com.fcpay.membership.application.port.out;

import com.fcpay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.fcpay.membership.domain.Membership;

public interface FindMembershipPort {

    MembershipJpaEntity findMembership(
            Membership.MembershipId membershipId
    );

}
