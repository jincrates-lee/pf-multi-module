package me.jincrates.apiclient.order.service;

import lombok.RequiredArgsConstructor;
import me.jincrates.apiclient.order.service.request.OrderCancelRequest;
import me.jincrates.apiclient.order.service.request.OrderCompleteRequest;
import me.jincrates.apiclient.order.service.request.OrderPrepareRequest;
import me.jincrates.apiclient.order.service.response.OrderPrepareResponse;
import me.jincrates.apiclient.order.service.response.OrderResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    /**
     * 주문 준비
     */
    public OrderPrepareResponse prepareOrder(OrderPrepareRequest request) {
        return null;
    }

    /**
     * 주문 완료
     */
    public OrderResponse completeOrder(OrderCompleteRequest request) {
        return null;
    }

    /**
     * 주문 취소
     */
    public void cancelOrder(OrderCancelRequest request) {

    }
}
