package com.amigoscode.customer.utils;

import com.amigoscode.customer.domain.Customer;

public class CustomerCreator {

    public static Customer customerCreator(){
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Carlos");
        customer.setLastName("Eduardo");
        customer.setEmail("carlos@gmail.com");
        return customer;
    }
}
