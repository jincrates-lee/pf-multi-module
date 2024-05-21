package me.jincrates.domain.core.repository;

import me.jincrates.domain.core.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
