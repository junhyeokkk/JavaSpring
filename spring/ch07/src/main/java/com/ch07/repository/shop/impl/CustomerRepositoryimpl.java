package com.ch07.repository.shop.impl;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.QCustomer;
import com.ch07.repository.shop.CustomerRepository;
import com.ch07.repository.shop.custom.CustomerRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

// CustomerRepository 확장 인터페이스 구현 클래스
@RequiredArgsConstructor
@Repository
public class CustomerRepositoryimpl implements CustomerRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    // Q도메인 클래스 선언
    private QCustomer qCustomer = QCustomer.customer;

    @Override
    public List<Customer> selectCustomers() {

        // select * from customer
        return queryFactory
                .select(qCustomer)
                .from(qCustomer)
                .fetch();
    }

    @Override
    public Customer selectCustomer(String cid) {
        return queryFactory
                .selectFrom(qCustomer)
                .where(qCustomer.cid.eq(cid))
                .fetchOne();
    }

    @Override
    public List<Customer> selectProjectionCustomer() {
        return queryFactory
                .select(
                        Projections.fields(
                                Customer.class,
                                qCustomer.cid,
                                qCustomer.name,
                                qCustomer.addr
                        )
                )
                .from(qCustomer)
                .fetch();
    }

    @Override
    public List<Customer> searchCustomers(String nameCondition, int ageCondition) {
        // QueryDSL 동적 쿼리 Builder 생성
        BooleanBuilder builder = new BooleanBuilder();

        if(nameCondition != null) {
            builder.and(qCustomer.name.eq(nameCondition));
        }
        /*
        if(ageCondition > 0) {
            builder.and(qCustomer.age.goe(ageCondition)); //goe : Greater Than or Equal
        }
         */
        return queryFactory
                .selectFrom(qCustomer)
                .where(builder)
                .fetch();
    }

    @Override
    public List<Customer> searchKeyword(String keyword) {

        BooleanExpression express = qCustomer
                                    .name.containsIgnoreCase(keyword)
                                    .or(qCustomer.addr.containsIgnoreCase(keyword));
        return queryFactory
                            .selectFrom(qCustomer)
                            .where(express)
                            .fetch();
    }
}
