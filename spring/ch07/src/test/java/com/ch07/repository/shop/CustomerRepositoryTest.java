package com.ch07.repository.shop;

import com.ch07.entity.shop.Customer;
import com.ch07.entity.shop.QCustomer;
import com.ch07.repository.shop.custom.CustomerRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CustomerRepositoryTest {


    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void selectCustomers() {
        List<Customer> customers = customerRepository.selectCustomers();
        System.out.println(customers);
    }

    @Test
    public void selectCustomer(String cid) {
        Customer customer= customerRepository.selectCustomer("a101");
        System.out.println(customer);
    }

    @Test
    public void searchCustomers(String nameCondition, int ageCondition) {
        List<Customer> customers1 = customerRepository.searchCustomers("김순수", 23);
        List<Customer> customers2 = customerRepository.searchCustomers("김순수", 0);
        List<Customer> customers3 = customerRepository.searchCustomers(null, 23);
        List<Customer> customers4 = customerRepository.searchCustomers(null, 0);

        System.out.println(customers1);
        System.out.println(customers2);
        System.out.println(customers3);
        System.out.println(customers4);
    }

    @Test
    public void searchKeyword(String keyword) {
        List<Customer> customers1 = customerRepository.searchKeyword("순수");
        List<Customer> customers2 = customerRepository.searchKeyword("구수");

        System.out.println(customers1);
        System.out.println(customers2);
    }

    @Test
    public void selectProjectionCustomer() {
        List<Customer> customers = customerRepository.selectProjectionCustomer();
        System.out.println(customers);
    }
}
