package me.jincrates.domain.core.entity;

import me.jincrates.domain.core.enumtype.CouponStatus;

public record Coupon(
    Long id,
    CouponStatus status
) {

    public boolean isUsable() {
        return status == CouponStatus.CREATED;
    }

    public Coupon use() {
        if (!isUsable()) {
            throw new IllegalStateException("이미 사용한 쿠폰입니다.");
        }
        return new Coupon(this.id, CouponStatus.USED);
    }

    public Coupon cancel() {
        if (status != CouponStatus.CREATED) {
            throw new IllegalStateException("사용 또는 취소된 쿠폰은 취소할 수 없습니다.");
        }
        return new Coupon(this.id, CouponStatus.CANCELED);
    }
}
