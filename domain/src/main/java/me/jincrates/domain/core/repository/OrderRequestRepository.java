package me.jincrates.domain.core.repository;

import java.util.Optional;
import me.jincrates.domain.core.entity.OrderRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRequestRepository extends JpaRepository<OrderRequestEntity, Long> {
    Optional<OrderRequestEntity> findByOrderId(Long orderId);
}
