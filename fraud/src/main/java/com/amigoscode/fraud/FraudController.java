package com.amigoscode.fraud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {
    
    private final FraudCheckService fraudCheckService;

    public FraudController(FraudCheckService fraudCheckService) {
        this.fraudCheckService = fraudCheckService;
    }

    @GetMapping(path = "/{customerId}")
    public FraudCheckResponse isFraud(@PathVariable("customerId") Integer customerId){
        boolean isFraudlentCustomer = fraudCheckService.isFraudlentCustomer(customerId);
        System.out.println("Fraud check request for customer "+customerId );
        return new FraudCheckResponse(isFraudlentCustomer);
    }
}
