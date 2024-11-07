package me.jincrates.pf.infrastructure.dataaccess.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrderEntity is a Querydsl query type for OrderEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderEntity extends EntityPathBase<OrderEntity> {

    private static final long serialVersionUID = -1657229938L;

    public static final QOrderEntity orderEntity = new QOrderEntity("orderEntity");

    public final StringPath code = createString("code");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<me.jincrates.domain.enums.OrderStatus> status = createEnum("status", me.jincrates.domain.enums.OrderStatus.class);

    public QOrderEntity(String variable) {
        super(OrderEntity.class, forVariable(variable));
    }

    public QOrderEntity(Path<? extends OrderEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderEntity(PathMetadata metadata) {
        super(OrderEntity.class, metadata);
    }

}

