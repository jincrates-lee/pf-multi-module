package me.jincrates.api.order.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.jincrates.api.order.mapper.OrderMapper;
import me.jincrates.api.order.service.request.OrderCancelRequest;
import me.jincrates.api.order.service.request.OrderCompleteRequest;
import me.jincrates.api.order.service.request.OrderPrepareRequest;
import me.jincrates.api.order.service.response.OrderPrepareResponse;
import me.jincrates.api.order.service.response.OrderResponse;
import me.jincrates.api.order.service.validation.CouponValidator;
import me.jincrates.domain.core.entity.Coupon;
import me.jincrates.domain.core.entity.CouponGroup;
import me.jincrates.domain.core.entity.Customer;
import me.jincrates.domain.core.entity.OrderRequest;
import me.jincrates.domain.persistence.CouponReader;
import me.jincrates.domain.persistence.CouponWriter;
import me.jincrates.domain.persistence.OrderIdGenerator;
import me.jincrates.domain.persistence.OrderReader;
import me.jincrates.domain.persistence.OrderWriter;
import me.jincrates.domain.pg.PaymentGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class OrderService implements PrepareOrderUseCase, CompleteOrderUseCase, CancelOrderUseCase,
    GetOrderUseCase {

    private OrderReader orderReader;
    private OrderWriter orderWriter;
    private OrderMapper orderMapper;
    private CouponValidator couponValidator;
    private CouponReader couponReader;
    private CouponWriter couponWriter;
    private OrderIdGenerator orderIdGenerator;
    private PaymentGateway paymentGateway;

    /**
     * 주문 준비
     */
    @Override
    public OrderPrepareResponse prepareOrder(OrderPrepareRequest request) {
        // 1. 파라미터에 대한 유효성 체크는 validation 어노테이션으로

        // ex) 도메인 객체 생성시 검증
        Customer customer = new Customer(
            request.userId(),
            request.recipientName(),
            request.recipientMobileNo()
        );

        // ex) 사용하는 곳에서 검증
        Coupon usedCoupon = couponReader.findCoupon(request.couponId(), customer.id())
            .use();
        couponWriter.update(usedCoupon);

        CouponGroup usedCouponGroup = couponReader.findCouponGroup(
                request.couponGroupId(),
                customer.id()
            )
            .use();
        couponWriter.update(usedCouponGroup);

        // 주문 번호 생성
        Long generatedOrderId = orderIdGenerator.generate();

        // 주문 준비 생성
        OrderRequest orderRequest = orderWriter.persist(
            orderMapper.toDomain(request, generatedOrderId)
        );

        // PG 주문 준비

        return orderMapper.toResponse(orderRequest);
    }

    /**
     * 주문 완료
     */
    @Override
    public OrderResponse completeOrder(OrderCompleteRequest request) {
        // 중복 요청 체크
        // PG 결제
        // 결제 생성
        // 주문 생성

        return null;
    }

    /**
     * 주문 목록 조회
     */
    @Override
    public List<OrderResponse> getOrders(Long userId) {
        return List.of();
    }

    /**
     * 주문 조회
     */
    @Override
    public OrderResponse getOrder(Long orderId, Long userId) {
        return null;
    }

    /**
     * 주문 취소
     */
    @Override
    public void cancelOrder(OrderCancelRequest request) {
        // 주문 조회
        // 주문 취소
    }
}
