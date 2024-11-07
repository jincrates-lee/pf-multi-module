package me.jincrates.pf.infrastructure.dataaccess.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.jincrates.domain.enums.OrderStatus;
import org.hibernate.annotations.Comment;

@Getter
@Builder
@Entity
@Table(name = "orders")
@Comment("주문")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("PK")
    private Long id;

    @Column(unique = true, length = 40, nullable = false, updatable = false)
    @Comment("주문 코드")
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Comment("주문 상태")
    private OrderStatus status;
}
