package me.jincrates.api.order.service.request;

import java.util.List;

public record OrderProductIdsRequest(
    List<Long> orderProductIds
) {

}
