package me.jincrates.domain.core.repository;

import me.jincrates.domain.core.entity.OrderEntity;
import me.jincrates.domain.core.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
