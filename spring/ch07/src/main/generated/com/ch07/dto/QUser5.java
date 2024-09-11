package com.ch07.dto;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser5 is a Querydsl query type for User5
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser5 extends EntityPathBase<User5> {

    private static final long serialVersionUID = 3639974L;

    public static final QUser5 user5 = new QUser5("user5");

    public final StringPath addr = createString("addr");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath gender = createString("gender");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> seq = createNumber("seq", Integer.class);

    public QUser5(String variable) {
        super(User5.class, forVariable(variable));
    }

    public QUser5(Path<? extends User5> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser5(PathMetadata metadata) {
        super(User5.class, metadata);
    }

}

