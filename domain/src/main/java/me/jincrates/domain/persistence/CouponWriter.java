package me.jincrates.domain.persistence;

import me.jincrates.domain.core.entity.Coupon;
import me.jincrates.domain.core.entity.CouponGroup;

public interface CouponWriter {

    Coupon persist(Coupon coupon);

    Coupon update(Coupon newCoupon);

    CouponGroup persist(CouponGroup couponGroup);

    CouponGroup update(CouponGroup newCouponGroup);
}
