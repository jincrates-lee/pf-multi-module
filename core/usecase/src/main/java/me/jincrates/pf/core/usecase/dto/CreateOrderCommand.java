package me.jincrates.pf.core.usecase.dto;

import java.util.List;
import org.springframework.util.Assert;

public record CreateOrderCommand(
    Long userId,
    List<CreateOrderProductCommand> products
) {

    public CreateOrderCommand {
        Assert.notNull(
            userId,
            "사용자 ID는 필수입니다."
        );
        Assert.notEmpty(
            products,
            "주문 상품은 필수입니다."
        );
    }

    public record CreateOrderProductCommand(
        Long productId,
        int quantity
    ) {

        public CreateOrderProductCommand {
            Assert.notNull(
                productId,
                "상품 ID는 필수입니다."
            );
            Assert.isTrue(
                quantity > 0,
                "상품 수량은 0보다 커야 합니다."
            );
        }
    }
}
