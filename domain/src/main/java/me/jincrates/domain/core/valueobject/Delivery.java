package me.jincrates.domain.core.valueobject;

public record Delivery(
    String locationMessage, // 배송 수령장소
    String requestMessage  // 배송 요청 메시지
) {

    public Delivery {
        if (locationMessage == null) {
            throw new IllegalArgumentException("locationMessage must not be null");
        }
        if (requestMessage == null) {
            throw new IllegalArgumentException("requestMessage must not be null");
        }
    }
}
