package com.fcpay.money.domain;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MoneyChangingRequest {

    @Getter private String moneyChangingRequestId;

    @Getter private final String targetMembershipId ;

    @Getter private final int changingType;
    /*@Getter private final ChangingType changingType; // enum 0 증액 1 감액
    enum ChangingTypeEnum {
        INCREASING,
        DECREASING
    }*/

    @Getter private final int changingMoneyAmount;

    @Getter private final int changingMoneyStatus; // 0 요청 1 성공 2 실패
    /*@Getter private final ChangingMoneyStatus changingMoneyStatus;
    enum ChangingMoneyStatusEnum {
        REQUESTED,
        SUCCEEDED,
        FAILED,
        CANCELLED,
    }*/

    @Getter private final String uuid;

    @Getter private final Date createAt;

    public static MoneyChangingRequest generateMoneyChangingRequest(
            //MoneyChangingRequestId moneyChangingRequestId,
            TargetMembershipId targetMembershipId,
            ChangingType changingType,
            ChangingMoneyAmount changingMoneyAmount,
            ChangingMoneyStatus changingMoneyStatus,
            Uuid uuid
    ) {
        return new MoneyChangingRequest(
                //moneyChangingRequestId.getMoneyChangingRequestId(),
                targetMembershipId.getTargetMembershipId(),
                changingType.getChangingType(),
                changingMoneyAmount.getChangingMoneyAmount(),
                changingMoneyStatus.getChangingMoneyStatus(),
                uuid.uuid,
                new Date()
        );
    }

    public MoneyChangingRequest(String targetMembershipId, int changingType, int changingMoneyAmount, int changingMoneyStatus, String uuid, Date createAt) {
        //this.moneyChangingRequestId = moneyChangingRequestId;
        this.targetMembershipId = targetMembershipId;
        this.changingType = changingType;
        this.changingMoneyAmount = changingMoneyAmount;
        this.changingMoneyStatus = changingMoneyStatus;
        this.uuid = uuid;
        this.createAt = createAt;
    }

    @Value
    public static class MoneyChangingRequestId {
        public MoneyChangingRequestId(String value) {
            this.moneyChangingRequestId = value;
        }
        String moneyChangingRequestId ;
    }

    @Value
    public static class TargetMembershipId {
        public TargetMembershipId(String value) {
            this.targetMembershipId = value;
        }
        String targetMembershipId ;
    }

    @Value
    public static class ChangingType {
        public ChangingType(int value) {
            this.changingType = value;
        }
        int changingType;
    }

    /*@Value
    public static class ChangingType {
        public ChangingType(ChangingTypeEnum value) {
            this.changingType = value;
        }
        ChangingTypeEnum changingType;
    }*/

    @Value
    public static class ChangingMoneyAmount {
        public ChangingMoneyAmount(int value) {
            this.changingMoneyAmount = value;
        }
        int changingMoneyAmount;
    }

    @Value
    public static class ChangingMoneyStatus {
        public ChangingMoneyStatus(int value) {
            this.changingMoneyStatus = value;
        }
        int changingMoneyStatus;
    }
    /*@Value
    public static class ChangingMoneyStatus {
        public ChangingMoneyStatus(ChangingMoneyStatusEnum value) {
            this.changingMoneyStatus = value;
        }
        ChangingMoneyStatusEnum changingMoneyStatus;
    }*/

    @Value
    public static class Uuid {
        public Uuid(UUID uuid){
            this.uuid = uuid.toString();
        }
        String uuid;
    }

    @Value
    public static class CreateAt {
        public CreateAt(Date value) {
            this.createAt = value;
        }
        Date createAt;
    }


}
