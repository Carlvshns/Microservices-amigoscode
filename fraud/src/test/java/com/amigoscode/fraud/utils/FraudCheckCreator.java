package com.amigoscode.fraud.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;

import com.amigoscode.fraud.domain.FraudCheckHistory;

public class FraudCheckCreator {
    
    public static FraudCheckHistory fraudCheckCreator(){
        FraudCheckHistory fraudCheckHistory = new FraudCheckHistory();    
        fraudCheckHistory.setId(1);
        fraudCheckHistory.setCustomerId(1);
        fraudCheckHistory.setIsFraudster(false);
        fraudCheckHistory.setCreatedAt(LocalDateTime.now(ZoneId.systemDefault()));
        return fraudCheckHistory;
    }
}
