package me.jincrates.infrastructure.persistence.repository;

import java.util.Optional;
import me.jincrates.infrastructure.persistence.entity.OrderRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRequestJpaRepository extends JpaRepository<OrderRequestEntity, Long> {

    Optional<OrderRequestEntity> findByOrderId(Long orderId);
}
