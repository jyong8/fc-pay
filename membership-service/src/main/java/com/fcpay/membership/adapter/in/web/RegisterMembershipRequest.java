package com.fcpay.membership.adapter.in.web;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterMembershipRequest {

    private String name;

    private String address;

    private String email;

    private boolean isValid;

    private boolean isCorp;


    public RegisterMembershipRequest(String name, String address, String email, boolean isCorp) {
    }
}
