package com.ch07.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser2 is a Querydsl query type for User2
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser2 extends EntityPathBase<User2> {

    private static final long serialVersionUID = 760103473L;

    public static final QUser2 user2 = new QUser2("user2");

    public final StringPath addr = createString("addr");

    public final StringPath birth = createString("birth");

    public final StringPath name = createString("name");

    public final StringPath uid = createString("uid");

    public QUser2(String variable) {
        super(User2.class, forVariable(variable));
    }

    public QUser2(Path<? extends User2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser2(PathMetadata metadata) {
        super(User2.class, metadata);
    }

}

