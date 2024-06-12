package me.jincrates.infrastructure.persistence.repository;

import me.jincrates.domain.core.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {

}
