package com.fcpay.membership.application.service;

import com.fcpay.membership.adapter.out.persistence.MembershipJpaEntity;
import com.fcpay.membership.adapter.out.persistence.MembershipMapper;
import com.fcpay.membership.application.port.in.FindMembershipCommand;
import com.fcpay.membership.application.port.in.FindMembershipUseCase;
import com.fcpay.membership.application.port.out.FindMembershipPort;
import com.fcpay.membership.domain.Membership;
import common.UseCase;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;

    private final MembershipMapper membershipMapper;

    @Override
    public Membership findMembership(FindMembershipCommand command) {
        MembershipJpaEntity entity = findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));
        return membershipMapper.mapToDomainEntity(entity);

    }
}
