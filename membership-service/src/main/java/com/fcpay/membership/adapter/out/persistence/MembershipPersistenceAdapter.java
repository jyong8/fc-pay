package com.fcpay.membership.adapter.out.persistence;

import com.fcpay.membership.application.port.out.FindMembershipPort;
import com.fcpay.membership.application.port.out.RegisterMembershipPort;
import common.PersistenceAdapter;
import com.fcpay.membership.domain.Membership;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMemberShip(
            Membership.MembershipName membershipName,
            Membership.MembershipEmail membershipEmail,
            Membership.MembershipAddress membershipAddress,
            Membership.MembershipIsValid membershipIsValid,
            Membership.MembershipIsCorp membershipIsCorp) {
        return membershipRepository.save(
                    new MembershipJpaEntity(
                            membershipName.getNameValue(),
                            membershipEmail.getEmailValue(),
                            membershipAddress.getAddressValue(),
                            membershipIsValid.isValidValue(),
                            membershipIsCorp.isCorpValue()
                    )
        );
    }

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.getById(membershipId.getMembershipIdValue());
    }
}
