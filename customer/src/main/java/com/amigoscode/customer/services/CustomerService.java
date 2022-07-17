package com.amigoscode.customer.services;

import com.amigoscode.customer.domain.Customer;
import com.amigoscode.customer.domain.CustomerRegistrationRequest;
import com.amigoscode.customer.repository.CustomerRepository;
import com.amigoscode.fraud.responses.FraudCheckResponse;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
//Aqui poderia ser utilizado record, mas estou utilizando Java 11, talvez voltarei aqui e refatorarei
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

        notifyCustomer();
    }

    public void notifyCustomer(){
        restTemplate.exchange("http://localhost:8082/api/v1/notification", HttpMethod.POST, null, Void.class);
    }
}
