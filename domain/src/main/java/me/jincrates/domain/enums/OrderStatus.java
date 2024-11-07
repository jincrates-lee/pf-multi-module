package me.jincrates.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    REQUESTED("주문접수"),
    COMPLETED("주문완료"),
    CANCELED("주문취소"),
    ;
    private final String description;
}
