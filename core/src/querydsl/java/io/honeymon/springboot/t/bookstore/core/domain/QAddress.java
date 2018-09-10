package io.honeymon.springboot.t.bookstore.core.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAddress is a Querydsl query type for Address
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QAddress extends BeanPath<Address> {

    private static final long serialVersionUID = -234108049L;

    public static final QAddress address = new QAddress("address");

    public final StringPath additionalAddr = createString("additionalAddr");

    public final StringPath addr = createString("addr");

    public final StringPath area = createString("area");

    public final StringPath postCode = createString("postCode");

    public final StringPath province = createString("province");

    public QAddress(String variable) {
        super(Address.class, forVariable(variable));
    }

    public QAddress(Path<? extends Address> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAddress(PathMetadata metadata) {
        super(Address.class, metadata);
    }

}

