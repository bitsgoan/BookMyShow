package com.scaler.bookmyshowscaler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Payment  extends BaseClass {
    private String thirdPartyRefId;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
