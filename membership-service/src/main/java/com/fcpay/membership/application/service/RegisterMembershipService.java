package com.fcpay.membership.application.service;

import com.fcpay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.fcpay.membership.adapter.out.persistence.MembershipMapper;
import com.fcpay.membership.application.port.in.RegisterMembershipCommand;
import com.fcpay.membership.application.port.in.RegisterMembershipUseCase;
import com.fcpay.membership.application.port.out.RegisterMembershipPort;
import com.fcpay.membership.domain.Membership;
import common.UseCase;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;

    private final MembershipMapper membershipMapper;

    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {

        MembershipJpaEntity jpaEntity = registerMembershipPort.createMemberShip(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );

        //entity -> Membership

        return membershipMapper.mapToDomainEntity(jpaEntity);
    }
}
