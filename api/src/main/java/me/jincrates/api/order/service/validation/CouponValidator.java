package me.jincrates.api.order.service.validation;

import me.jincrates.domain.core.entity.UsableCouponInfo;
import org.springframework.stereotype.Component;

@Component
public class CouponValidator {

    /**
     * 쿠폰 사용 가능 여부 검증
     */
    public void validateUsableCoupon(UsableCouponInfo usableCouponInfo) {
//        쿠폰 조회
//        Coupon coupon = couponReader.findByCouponId(usableCouponInfo.couponId());
//        if (coupon == null) {
//            throw new IllegalArgumentException("존재하지 않는 쿠폰입니다.");
//        }
//        if (coupon.active()) {
//            throw new IllegalArgumentException("사용할 수 없는 쿠폰입니다.");
//        }
//
//        CouponGroup couponGroup = couponReader.findByCouponGroupId(usableCouponInfo.couponGroupId());
//        if (couponGroup == null) {
//            throw new IllegalArgumentException("존재하지 않는 쿠폰 그룹입니다.");
//        }
//        if (couponGroup.active()) {
//            throw new IllegalArgumentException("사용할 수 없는 쿠폰 그룹입니다.");
//        }
    }
}
