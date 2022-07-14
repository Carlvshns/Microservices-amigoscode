package com.amigoscode.fraud;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
    }

    public boolean isFraudlentCustomer(Integer customerId){
        FraudCheckHistory fraudCheckHistory = new FraudCheckHistory(); //O Builder sera usado no lugar disto
        fraudCheckHistory.setCustomerId(customerId);
        fraudCheckHistory.setIsFraudster(false);
        fraudCheckHistory.setCreatedAt(LocalDateTime.now());
        fraudCheckHistoryRepository.save( 
            fraudCheckHistory // Aqui usara o Builder
        );
        return false;
    }
}
