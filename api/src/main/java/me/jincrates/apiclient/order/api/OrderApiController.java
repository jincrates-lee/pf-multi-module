package me.jincrates.apiclient.order.api;

import lombok.RequiredArgsConstructor;
import me.jincrates.apiclient.order.service.OrderService;
import me.jincrates.apiclient.order.service.request.OrderCancelRequest;
import me.jincrates.apiclient.order.service.request.OrderCompleteRequest;
import me.jincrates.apiclient.order.service.request.OrderPrepareRequest;
import me.jincrates.apiclient.order.service.response.OrderPrepareResponse;
import me.jincrates.apiclient.order.service.response.OrderResponse;
import org.springframework.http.ResponseEntity;
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

    private final OrderService orderService;

    @PostMapping("/prepare")
    public ResponseEntity<ApiResponse<OrderPrepareResponse>> prepare(
        @RequestBody OrderPrepareRequest request
    ) {
        OrderPrepareResponse response = orderService.prepareOrder(request);
        return create("주문준비 성공", response);
    }

    @PostMapping("/complete")
    public ResponseEntity<ApiResponse<OrderResponse>> complete(
        @RequestBody OrderCompleteRequest request
    ) {
        OrderResponse response = orderService.completeOrder(request);
        return ok("주문완료 성공", response);
    }

    @PutMapping("/{orderId}/cancel}")
    public ResponseEntity<ApiResponse<Long>> cancel(
        @PathVariable Long orderId
    ) {
        Long authUseId = 1L;
        orderService.cancelOrder(new OrderCancelRequest(
            orderId,
            authUseId
        ));
        return ok("주문취소 성공", orderId);
    }
}
