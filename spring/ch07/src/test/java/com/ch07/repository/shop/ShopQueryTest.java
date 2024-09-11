package com.ch07.repository.shop;

import com.ch07.dto.CustomerDTO;
import com.ch07.dto.ProductAggDTO;
import com.ch07.entity.shop.*;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class ShopQueryTest {

    /*
    *   QueryDSL 설정
    *   - build.gradle 의존성 추가
    *   implementation 'com.querydsl:querydsl-jpa:5.1.0:jakarta'
    *   annotationProcessor "com.querydsl:querydsl-apt:5.1.0:jakarta"
    *   annotationProcessor "jakarta.annotation:jakarta.annotation-api"
    *   annotationProcessor "jakarta.persistence:jakarta.persistence-api"
    *
    *   - build.gradle 파일 QueryDSL 경로 및 환경설정
    *   // QueryDSL 경로설정
    *      def queryDslDir = "src/main/generated"
    *       sourceSets {
    *           main.java.srcDirs queryDslDir
    *       }
    *
    *       tasks.withType(JavaCompile) {
    *           options.generatedSourceOutputDirectory = file(queryDslDir)
    *       }
    *
    *       clean {
    *           delete file(queryDslDir)
    *       }
    *
    *   - q도메인 클래스 생성 확인 (애플리케이션이 실행 상태 확인)
    *
    *   QueryDsl 구현
    *   - 개별 Repository 확장 Custom 인터페이스 생성
    *   - Custom 인터페이스 구현하는 Impl 클래스 생성
    *   - Impl 클래스에서 QueryDsl 쿼리메서드 정의
    *   - 개별 Repository에 Custom 인터페이스 상속 추가
    * */

    @Autowired
    private JPAQueryFactory jpaqueryFactory;

    private QCustomer qCustomer = QCustomer.customer;
    private QProduct qProduct = QProduct.product;
    private QOrder qOrder = QOrder.order;

    @Test
    void test01(){
        List<Product> products = jpaqueryFactory
                                                .selectFrom(qProduct)
                                                .fetch();
        System.out.println(products);
    }

    @Test
    void test02(){
        List<Product> products = jpaqueryFactory
                                                .select(
                                                        Projections.fields(
                                                                Product.class,
                                                                qProduct.prod_id,
                                                                qProduct.prod_name,
                                                                qProduct.prod_price
                                                        )
                                                )
                                                .from(qProduct)
                                                .fetch(); //fetch 결과는 List
        System.out.println(products);
    }

    @Test
    void test03(){
        List<Customer> customer1s = jpaqueryFactory
                                                    .selectFrom(qCustomer)
                                                    .where(qCustomer.name.eq("김순수"))
                                                    .fetch();
        List<Customer> customer2s = jpaqueryFactory
                                                    .selectFrom(qCustomer)
                                                    .where(qCustomer.name.ne("김순수"))
                                                    .fetch();
        System.out.println(customer1s);
        System.out.println(customer2s);
    }

    @Test
    void test04(){
        List<Customer> customer1s = jpaqueryFactory.selectFrom(qCustomer).where(qCustomer.age.gt(30)).fetch();
        List<Customer> customer2s = jpaqueryFactory.selectFrom(qCustomer).where(qCustomer.age.goe(30)).fetch();
        List<Customer> customer3s = jpaqueryFactory.selectFrom(qCustomer).where(qCustomer.age.lt(30)).fetch();
        List<Customer> customer4s = jpaqueryFactory.selectFrom(qCustomer).where(qCustomer.age.loe(30)).fetch();

        System.out.println(customer1s);
        System.out.println(customer2s);
        System.out.println(customer3s);
        System.out.println(customer4s);
    }

    @Test
    void test05(){
        List<Customer> customers = jpaqueryFactory.selectFrom(qCustomer)
                                                  .where(qCustomer.addr.in("서울","김해"))
                                                  .fetch();
        System.out.println(customers);
    }

    @Test
    void test06(){
        List<Customer> customers = jpaqueryFactory.selectFrom(qCustomer)
                                                  .where(qCustomer.name.like("%수"))
                                                  .fetch();
        System.out.println(customers);
    }

    @Test
    void test07(){
        List<Product> products = jpaqueryFactory.selectFrom(qProduct)
                                                .where(qProduct.stock.gt(0))
                                                .orderBy(qProduct.prod_price.desc())
                                                .fetch();
        System.out.println(products);
    }

    @Test
    void test08(){
        List<Product> products  = jpaqueryFactory
                                                .selectFrom(qProduct)
                                                .where(qProduct.stock.gt(0))
                                                .orderBy(qProduct.prod_price.asc())
                                                .offset(0)
                                                .limit(3)
                                                .fetch();
        System.out.println(products);
    }

    @Test
    void test09(){
         ProductAggDTO productAggDTO = jpaqueryFactory
                                                     .select(
                                                             Projections.fields(
                                                                ProductAggDTO.class,
                                                                     qProduct.prod_price.sum().as("priceSum"),
                                                                     qProduct.prod_price.avg().as("priceAvg"),
                                                                     qProduct.prod_price.max().as("priceMax"),
                                                                     qProduct.prod_price.min().as("priceMin")
                                                     ))
                                                     .from(qProduct)
                                                     .fetchOne();
        System.out.println(productAggDTO);
    }

    @Test
    void test10(){
        List<CustomerDTO> customerDTOS = jpaqueryFactory
                                            .select(
                                                    Projections.fields(
                                                            CustomerDTO.class,
                                                            qOrder.customer.cid,
                                                            qOrder.customer.name,
                                                            qOrder.customer.cid.count().as("orderCount")
                                                    )
                                            )
                                            .from(qOrder)
                                            .where(qOrder.orderStatus.eq(1))
                                            .groupBy(qOrder.customer.cid)
                                            .having(qOrder.customer.cid.count().goe(2))
                                            .fetch();
        System.out.println(customerDTOS);
    }

    @Transactional
    @Test
    void test11(){
        List<Tuple> result  = jpaqueryFactory
                                             .select(qOrder, qCustomer)
                                             .from(qOrder)
                                             .join(qCustomer)
                                             .on(qOrder.customer.eq(qCustomer))
                                             .fetch();
        System.out.println(result);
    }
}
