package me.jincrates.pf.infrastructure.dataaccess.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Builder
@Entity
@Table(name = "order_products")
@Comment("주문 상품")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("PK")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_code")
    @Comment("주문 코드")
    private OrderEntity order;

    @Column(nullable = false)
    @Comment("상품 ID")
    private Long productId;

    @Column(nullable = false)
    @Comment("주문 수량")
    private int quantity;

    protected void setOrder(OrderEntity order) {
        this.order = order;
    }
}
