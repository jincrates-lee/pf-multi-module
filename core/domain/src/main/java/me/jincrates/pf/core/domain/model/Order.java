package me.jincrates.pf.core.domain.model;

import java.util.List;
import lombok.Builder;
import me.jincrates.pf.core.domain.enums.OrderStatus;

@Builder
public record Order(
    Long id,
    String code,
    Long userId,
    OrderStatus status,
    List<OrderProduct> products
) {

}
