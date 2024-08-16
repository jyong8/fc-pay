package com.fcpay.membership.adapter.out.persistence;

import com.fcpay.membership.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface SpringDataMembershipRepository extends JpaRepository<MembershipJpaEntity, Long> {
}
