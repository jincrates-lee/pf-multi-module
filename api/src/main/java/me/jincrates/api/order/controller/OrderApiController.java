package me.jincrates.api.order.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import me.jincrates.api.order.service.CancelOrderUseCase;
import me.jincrates.api.order.service.CompleteOrderUseCase;
import me.jincrates.api.order.service.GetOrderUseCase;
import me.jincrates.api.order.service.PrepareOrderUseCase;
import me.jincrates.api.order.service.request.OrderCancelRequest;
import me.jincrates.api.order.service.request.OrderCompleteRequest;
import me.jincrates.api.order.service.request.OrderPrepareRequest;
import me.jincrates.api.order.service.request.OrderProductIdsRequest;
import me.jincrates.api.order.service.response.OrderPrepareResponse;
import me.jincrates.api.order.service.response.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderApiController extends BaseController {

    private final PrepareOrderUseCase prepareOrderUseCase;
    private final CompleteOrderUseCase completeOrderUseCase;
    private final GetOrderUseCase getOrderUseCase;
    private final CancelOrderUseCase cancelOrderUseCase;

    @PostMapping("/prepare")
    public ResponseEntity<ApiResponse<OrderPrepareResponse>> prepare(
        @Valid @RequestBody OrderPrepareRequest request
    ) {
        OrderPrepareResponse response = prepareOrderUseCase.prepareOrder(request);
        return create("주문 준비 성공", response);
    }

    @PostMapping("/complete")
    public ResponseEntity<ApiResponse<OrderResponse>> complete(
        @Valid @RequestBody OrderCompleteRequest request
    ) {
        OrderResponse response = completeOrderUseCase.completeOrder(request);
        return ok("주문 완료 성공", response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<OrderResponse>>> getOrders() {
        Long authUseId = 1L;
        List<OrderResponse> response = getOrderUseCase.getOrders(authUseId);
        return ok("주문 목록 조회 성공", response);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<ApiResponse<OrderResponse>> getOrder(
        @PathVariable(name = "orderId") Long orderId
    ) {
        Long authUseId = 1L;
        OrderResponse response = getOrderUseCase.getOrder(orderId, authUseId);
        return ok("주문 조회 성공", response);
    }

    @PutMapping("/{orderId}/cancel")
    public ResponseEntity<ApiResponse<Long>> cancel(
        @PathVariable(name = "orderId") Long orderId,
        @Valid @RequestBody OrderProductIdsRequest request
    ) {
        Long authUseId = 1L;
        cancelOrderUseCase.cancelOrder(
            new OrderCancelRequest(
                orderId,
                authUseId,
                request.orderProductIds()
            )
        );
        return ok("주문 취소 성공", orderId);
    }
}
