package me.jincrates.apiclient.order.usecase;

import me.jincrates.apiclient.order.dto.OrderPrepareRequestDto;
import me.jincrates.apiclient.order.dto.OrderPrepareResponseDto;
import me.jincrates.apiclient.order.dto.OrderCompleteRequestDto;
import me.jincrates.apiclient.order.dto.OrderResponseDto;

public interface OrderUseCase {

    OrderPrepareResponseDto prepareOrder(OrderPrepareRequestDto request);
    OrderResponseDto completeOrder(OrderCompleteRequestDto request);
}
