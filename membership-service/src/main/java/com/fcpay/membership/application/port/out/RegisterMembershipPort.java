package com.fcpay.membership.application.port.out;

import com.fcpay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.fcpay.membership.domain.Membership;

public interface RegisterMembershipPort {

    MembershipJpaEntity createMemberShip(
            Membership.MembershipName membershipName
            , Membership.MembershipEmail membershipEmail
            , Membership.MembershipAddress membershipAddress
            , Membership.MembershipIsValid membershipIsValid
            , Membership.MembershipIsCorp membershipIsCorp
    );
}
