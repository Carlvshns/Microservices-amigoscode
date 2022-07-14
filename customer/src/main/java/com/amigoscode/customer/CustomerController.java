package com.amigoscode.customer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
//Aqui poderia ser utilizado record, mas estou utilizando Java 11, futuramente voltarei aqui e refatorarei
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        System.out.println("new customer registration: "+customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }
}
