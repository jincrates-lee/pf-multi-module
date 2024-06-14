package me.jincrates.domain.persistence;

import me.jincrates.domain.core.entity.Coupon;
import me.jincrates.domain.core.entity.CouponGroup;

public interface CouponReader {

    Coupon findCoupon(Long couponId, Long userId);

    CouponGroup findCouponGroup(Long couponGroupId, Long userId);
}


