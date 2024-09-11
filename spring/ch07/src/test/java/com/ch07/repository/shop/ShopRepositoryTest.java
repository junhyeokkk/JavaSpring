package com.ch07.repository.shop;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.Order;
import com.ch07.entity.shop.OrderItem;
import com.ch07.entity.shop.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShopRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRespository productRespository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Test
    void insertCustomerTest(){
        Customer customer = Customer.builder()
                .cid("a101")
                .name("김순수")
                .hp("010-1234-1234")
                .addr("부산광역시")
                .build();
        customerRepository.save(customer);
    }

    @Test
    void insertProductTest(){
        Product product = Product.builder()
                .prod_id(1)
                .prod_name("새우깡")
                .prod_price(1000)
                .stock(100)
                .company("농심")
                .build();
        productRespository.save(product);
    }

    @Test
    void insertOrderTest(){
        Customer customer = Customer.builder()
                .cid("a101")
                .build();
        Order order = Order.builder()
                .orderPrice(10000)
                .orderStatus(1)
                .customer(customer)
                .build();

        orderRepository.save(order);
    }

    @Test
     void insertOrderItemTest(){
         Order order = Order.builder()
                 .orderId(1)
                 .build();
         Product product = Product.builder()
                 .prod_id(1)
                 .build();
         OrderItem item = OrderItem.builder()
                 .count(5)
                 .order(order)
                 .product(product)
                 .build();
         orderItemRepository.save(item);
     }
}
