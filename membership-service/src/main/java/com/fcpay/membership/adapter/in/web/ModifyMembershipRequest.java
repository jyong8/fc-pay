package com.fcpay.membership.adapter.in.web;

import com.fcpay.membership.application.port.in.ModifyMembershipCommand;
import com.fcpay.common.SelfValidating;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModifyMembershipRequest extends SelfValidating<ModifyMembershipCommand> {

    private long membershipId;

    private String name;

    private String address;

    private String email;

    private boolean isValid;

    private boolean isCorp;

}
