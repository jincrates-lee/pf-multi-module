package me.jincrates.pf.api.controller.v1;

import lombok.RequiredArgsConstructor;
import me.jincrates.pf.application.usecase.OrderUseCase;
import me.jincrates.pf.application.usecase.dto.CreateOrderCommand;
import me.jincrates.pf.application.usecase.dto.OrderResponse;
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
public class OrderRestController {

    private final OrderUseCase orderUseCase;

    @PostMapping
    public OrderResponse createOrder(
        @Validated @RequestBody
        CreateOrderCommand command
    ) {
        return orderUseCase.saveOrder(command);
    }

    @GetMapping("/{orderCode}")
    public OrderResponse getOrder(
        @PathVariable(name = "orderCode") String orderCode
    ) {
        return orderUseCase.getOrderByCode(orderCode);
    }
}
