package me.jincrates.apiclient.order.api;

import lombok.RequiredArgsConstructor;
import me.jincrates.apiclient.order.dto.OrderPrepareRequestDto;
import me.jincrates.apiclient.order.dto.OrderPrepareResponseDto;
import me.jincrates.apiclient.order.dto.OrderCompleteRequestDto;
import me.jincrates.apiclient.order.dto.OrderResponseDto;
import me.jincrates.apiclient.order.usecase.OrderUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderApi extends BaseController {
    private final OrderUseCase orderUseCase;
    @PostMapping("/prepare")
    public ResponseEntity<ApiResponse<OrderPrepareResponseDto>> prepare(
        @RequestBody OrderPrepareRequestDto request
    ) {
        OrderPrepareResponseDto response = orderUseCase.prepareOrder(request);
        return create("주문 준비 완료", response);
    }

    @PostMapping("/complete")
    public ResponseEntity<ApiResponse<OrderResponseDto>> complete(
        @RequestBody OrderCompleteRequestDto request
    ) {
        OrderResponseDto response = orderUseCase.completeOrder(request);
        return ok("주문 완료", response);
    }
}
