package me.jincrates.api.order.service.request;

public record OrderPrepareRequest(
    Long userId,  // 사용자 ID
    Long couponId, // 쿠폰 ID
    Long couponGroupId, // 그룹 쿠폰 ID
    String deliveryLocationMessage,  // 배송 수령장소
    String deliveryRequestMessage,  // 배송 요청 메시지
    String mobileOsCode,  // 모바일 OS 코드
    String paymentMethodCode,  // 결제 수단 코드
    String recipientName,  // 수령인 이름
    String recipientMobileNo  // 수령인 번호
) {

}
