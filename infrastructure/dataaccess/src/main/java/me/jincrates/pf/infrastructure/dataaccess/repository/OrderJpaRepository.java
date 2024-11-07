package me.jincrates.pf.infrastructure.dataaccess.repository;

import java.util.Optional;
import me.jincrates.pf.infrastructure.dataaccess.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {

    Optional<OrderEntity> findByCode(String orderCode);
}
