package com.fcpay.membership.domain;

import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {
    @Getter private final Long membershipId;
    @Getter private final String name;
    @Getter private final String email;
    @Getter private final String address;
    @Getter private final boolean isValid;
    @Getter private final boolean isCorp;

    public static Membership generateMember(
            MembershipId membershipId, MembershipName membershipName, MembershipEmail membershipEmail, MembershipAddress membershipAddress, MembershipIsValid membershipIsValid,
            MembershipIsCorp membershipIsCorp) {
        return new Membership(
                membershipId.membershipIdValue,
                membershipName.nameValue,
                membershipEmail.emailValue,
                membershipAddress.addressValue,
                membershipIsValid.isValidValue,
                membershipIsCorp.isCorpValue
        );
    }


    @Value
    public static class MembershipId {
        public MembershipId(Long value) {
            this.membershipIdValue = value;
        }
        Long membershipIdValue ;
    }

    @Value
    public static class MembershipName {
        public MembershipName(String value) {
            this.nameValue = value;
        }

        String nameValue;
    }
    @Value
    public static class MembershipEmail {
        public MembershipEmail(String value) {
            this.emailValue = value;
        }
        String emailValue;
    }

    @Value
    public static class MembershipAddress {
        public MembershipAddress(String value) {
            this.addressValue = value;
        }
        String addressValue;
    }

    @Value
    public static class MembershipIsValid {
        public MembershipIsValid(boolean value) {
            this.isValidValue = value;
        }
        boolean isValidValue;
    }

    @Value
    public static class MembershipIsCorp {
        public MembershipIsCorp(boolean value) {
            this.isCorpValue = value;
        }
        boolean isCorpValue;
    }

}
