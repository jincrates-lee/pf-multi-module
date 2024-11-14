package me.jincrates.pf.core.domain.model;

import lombok.Builder;

@Builder
public record OrderProduct(
    Long id,
    String orderCode,
    Long productId,
    int quantity
) {

}
