package com.amigoscode.fraud.services;

import java.time.LocalDateTime;
import java.time.ZoneId;

import com.amigoscode.fraud.domain.FraudCheckHistory;
import com.amigoscode.fraud.repository.FraudCheckHistoryRepository;

import org.springframework.stereotype.Service;

@Service
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
    }

    public boolean isFraudlentCustomer(Integer customerId){
        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.Builder
                                            .newBuilder()
                                            .customerId(customerId)
                                            .isFraudster(false)
                                            .createdAt(LocalDateTime.now(ZoneId.systemDefault()))
                                            .build();

        fraudCheckHistoryRepository.save( fraudCheckHistory);
        return false;
    }
}
