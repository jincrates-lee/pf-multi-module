package me.jincrates.api.order.service.request;

import java.util.List;

public record OrderCancelRequest(
    Long orderId,
    Long userId,
    List<Long> orderProductIds
) {

}
