package me.jincrates.infrastructure.persistence.mapper;

import me.jincrates.domain.core.entity.Payment;
import me.jincrates.infrastructure.persistence.entity.PaymentEntity;
import org.springframework.stereotype.Component;

@Component
public class PaymentPersistenceMapper {

    public PaymentEntity toEntity(Payment domain) {
        return PaymentEntity.builder()
            .id(domain.id())
            .paymentMethodCode(domain.paymentMethodCode())
            .transKey(domain.transKey())
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
