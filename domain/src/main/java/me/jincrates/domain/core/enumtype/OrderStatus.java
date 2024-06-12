package me.jincrates.domain.core.enumtype;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    PAYMENT_WAITING("결제 대기 중"),
    PAYMENT_COMPLETED("결제 완료"),
    PAYMENT_FAILED("결제 실패"),
    ORDER_CANCELLED("주문 취소"),
    ORDER_PARTIAL_CANCELLED("주문 부분 취소"),
    ;
    private final String description;
}
