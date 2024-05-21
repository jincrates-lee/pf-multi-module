package me.jincrates.domain.mapper;

import me.jincrates.domain.core.dto.Payment;
import me.jincrates.domain.core.entity.PaymentEntity;
import org.springframework.stereotype.Component;

@Component
public class PaymentDomainMapper {

    public PaymentEntity toEntity(Payment domain) {
        return PaymentEntity.builder()
                .id(domain.id())
                .build();
    }

    public Payment toDomain(PaymentEntity entity) {
        return new Payment(
            entity.getId(),
            entity.getPaymentMethodCode(),
            entity.getTransKey()
        );
    }
}
