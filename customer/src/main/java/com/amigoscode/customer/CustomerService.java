package com.amigoscode.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
//Aqui poderia ser utilizado record, mas estou utilizando Java 11, futuramente voltarei aqui e refatorarei
public class CustomerService {
    
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
    }

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = new Customer(); //Aqui o builder seria usado, se tivesse
        customer.setFirstName(request.getFirstName()); //Aqui poderia ser pego diretamente sem o uso do getter atraves do record
        customer.setLastname(request.getLastname());
        customer.setEmail(request.getEmail());

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject
        ("http://localhost:8081/api/v1/fraud-check/{customerId}", 
        FraudCheckResponse.class, customer.getId());

        if(fraudCheckResponse.getIsFraudster()){ //Aqui poderia ser pego diretamente sem o uso do getter atraves do record
            throw new IllegalStateException("fraudster");
        }
    }
}
