package me.jincrates.apiclient.order.mapper;

import me.jincrates.apiclient.order.dto.OrderPrepareRequestDto;
import me.jincrates.apiclient.order.dto.OrderPrepareResponseDto;
import me.jincrates.domain.core.dto.Order;
import me.jincrates.domain.core.dto.OrderRequest;
import me.jincrates.domain.core.dto.Payment;
import me.jincrates.domain.core.valueobject.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public Payment toDomain(String paymentMethodCode, String transKey) {
        return new Payment(
            null,
            paymentMethodCode,
            transKey
        );
    }
}
