package me.jincrates.pf.api.controller.v1;

import lombok.RequiredArgsConstructor;
import me.jincrates.pf.api.controller.ApiResponse;
import me.jincrates.pf.api.controller.BaseController;
import me.jincrates.pf.core.usecase.OrderUseCase;
import me.jincrates.pf.core.usecase.dto.CreateOrderCommand;
import me.jincrates.pf.core.usecase.dto.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderRestController extends BaseController {

    private final OrderUseCase orderUseCase;

    @PostMapping
    public ResponseEntity<ApiResponse<OrderResponse>> createOrder(
        @Validated @RequestBody
        CreateOrderCommand command
    ) {
        OrderResponse response = orderUseCase.saveOrder(command);
        return create(
            "주문 생성",
            response
        );
    }

    @GetMapping("/{orderCode}")
    public ResponseEntity<ApiResponse<OrderResponse>> getOrder(
        @PathVariable(name = "orderCode") String orderCode
    ) {
        return ok(
            "주문 조회",
            orderUseCase.getOrderByCode(orderCode)
        );
    }
}
