package com.amigoscode.customer;

import org.springframework.stereotype.Service;

@Service
//Aqui poderia ser utilizado record, mas estou utilizando Java 11, futuramente voltarei aqui e refatorarei
public class CustomerService {
    
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = new Customer(); //Aqui o builder seria usado, se tivesse
        customer.setFirstName(request.getFirstName());
        customer.setLastname(request.getLastname());
        customer.setEmail(request.getEmail());

        customerRepository.save(customer);
    }
}
