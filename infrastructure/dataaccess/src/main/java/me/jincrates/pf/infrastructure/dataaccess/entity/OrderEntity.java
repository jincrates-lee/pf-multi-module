package me.jincrates.pf.infrastructure.dataaccess.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.jincrates.pf.core.domain.enums.OrderStatus;
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

    @Column(nullable = false, updatable = false)
    @Comment("주문자 ID")
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Comment("주문 상태")
    private OrderStatus status;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<OrderProductEntity> products = new ArrayList<>();

    /**
     * 주문에 상품을 추가하는 메서드
     */
    public void addProduct(OrderProductEntity product) {
        if (products == null) {
            this.products = new ArrayList<>();
        }

        this.products.add(product);
        product.setOrder(this); // 양방향 관계 설정
    }
}
