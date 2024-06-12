package me.jincrates.infrastructure.persistence.repository;

import me.jincrates.domain.core.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, Long> {

}
