package me.jincrates.apiclient.order.mapper;

import me.jincrates.domain.core.entity.Payment;
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
