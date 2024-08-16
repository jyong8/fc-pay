package com.fcpay.membership.application.service;

import com.fcpay.membership.adapter.in.web.ModifyMembershipRequest;
import com.fcpay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.fcpay.membership.adapter.out.persistence.MembershipMapper;
import com.fcpay.membership.application.port.in.ModifyMembershipUseCase;
import com.fcpay.membership.application.port.out.ModifyMembershipPort;
import com.fcpay.membership.domain.Membership;
import com.fcpay.common.UseCase;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;

    private final MembershipMapper membershipMapper;

    @Override
    public Membership modifyMembership(ModifyMembershipRequest command) {
        MembershipJpaEntity entity = modifyMembershipPort.modifyMembership(
                new Membership.MembershipId(command.getMembershipId()),
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())
        );
        return membershipMapper.mapToDomainEntity(entity);
    }
}
