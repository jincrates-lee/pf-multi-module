package me.jincrates.domain.core.entity;

/**
 * 사용 가능한 쿠폰 정보
 */
public record UsableCouponInfo(
    Long couponId,
    Long couponGroupId
) {

}
