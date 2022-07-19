package com.amigoscode.customer.repository;

import org.junit.jupiter.api.Test;

import com.amigoscode.customer.domain.Customer;
import com.amigoscode.customer.utils.CustomerCreator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("Tests for Movie Repository")
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("SaveAndFlush persists Customer when Sucessful")
    void save_PersistCustomer_WhenSucessful(){
        Customer customerToBeSaved = CustomerCreator.customerCreator();

        Customer customerSaved = this.customerRepository.saveAndFlush(customerToBeSaved);

        Assertions.assertNotNull(customerSaved);

        Assertions.assertNotNull(customerSaved.getId());

        Assertions.assertEquals(customerSaved.getFirstName(), customerToBeSaved.getFirstName());
    }
}
