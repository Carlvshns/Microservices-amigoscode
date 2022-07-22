package com.amigoscode.customer.services;

import com.amigoscode.customer.domain.Customer;
import com.amigoscode.customer.domain.CustomerRegistrationRequest;
import com.amigoscode.customer.repository.CustomerRepository;
import com.amigoscode.fraud.responses.FraudCheckResponse;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {
    
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
    }

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.Builder.newBuilder()
                                            .firstName(request.getFirstName())
                                            .lastName(request.getLastName())
                                            .email(request.getEmail()).build();

        Customer customerSaved = customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject
        ("http://localhost:8081/api/v1/fraud-check/{customerId}", 
        FraudCheckResponse.class, customerSaved.getId());

        if(fraudCheckResponse.getIsFraudster()){ //Aqui poderia ser pego diretamente sem o uso do getter atraves do record
            throw new IllegalStateException("fraudster");
        }

        notifyCustomer();
    }

    public void notifyCustomer(){
        restTemplate.exchange("http://localhost:8082/api/v1/notification", HttpMethod.POST, null, Void.class);
    }
}
