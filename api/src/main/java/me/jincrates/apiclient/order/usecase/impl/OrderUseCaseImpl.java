package me.jincrates.apiclient.order.usecase.impl;

import lombok.RequiredArgsConstructor;
import me.jincrates.apiclient.order.dto.OrderCompleteRequestDto;
import me.jincrates.apiclient.order.dto.OrderPrepareRequestDto;
import me.jincrates.apiclient.order.dto.OrderPrepareResponseDto;
import me.jincrates.apiclient.order.dto.OrderResponseDto;
import me.jincrates.apiclient.order.mapper.OrderMapper;
import me.jincrates.apiclient.order.mapper.PaymentMapper;
import me.jincrates.apiclient.order.usecase.OrderUseCase;
import me.jincrates.domain.core.entity.Order;
import me.jincrates.domain.core.entity.OrderRequest;
import me.jincrates.domain.core.entity.Payment;
import me.jincrates.domain.core.enumtype.OrderStatus;
import me.jincrates.domain.service.OrderDomainService;
import me.jincrates.domain.service.PaymentDomainService;
import me.jincrates.pf.pg.PaymentGateway;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderUseCaseImpl implements OrderUseCase {

    private final OrderMapper orderMapper;
    private final PaymentMapper paymentMapper;
    private final OrderDomainService orderDomainService;
    private final PaymentDomainService paymentDomainService;
    private final PaymentGateway paymentGateway;

    @Override
    @Transactional
    public OrderPrepareResponseDto prepareOrder(OrderPrepareRequestDto request) {
        // 주문 번호 채번
        Long orderId = generateOrderId();
        OrderRequest orderRequest = orderMapper.toDomain(request, orderId);
        // ORDER_REQUEST 저장
        return orderMapper.toResponse(orderDomainService.saveOrderRequest(orderRequest));
    }

    @Override
    @Transactional
    public OrderResponseDto completeOrder(OrderCompleteRequestDto request) {
        OrderRequest orderRequest = orderDomainService.findOrderRequestByOrderId(request.orderId());
        // PG 처리
        String transKey = paymentGateway.approve(
            orderRequest.orderId(),
            orderRequest.paymentMethodCode()
        );
        // PAYMENT 저장
        Payment payment = paymentMapper.toDomain(orderRequest.paymentMethodCode(), transKey);
        Payment savedPayment = paymentDomainService.save(payment);
        // ORDER 저장
        Order order = orderMapper.toOrder(request.orderId(), OrderStatus.PAYMENT_COMPLETED,
            savedPayment.id());
        orderDomainService.saveOrder(order);
        return orderMapper.toResponse(order, savedPayment);
    }

    /**
     * 주문번호 채번
     */
    private long generateOrderId() {
        return System.currentTimeMillis();
    }
}
