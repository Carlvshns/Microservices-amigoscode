package com.amigoscode.fraud.responses;

//Aqui poderia ser utilizado record, mas estou utilizando Java 11, futuramente voltarei aqui e refatorarei
public class FraudCheckResponse {
    
    private Boolean isFraudster;

    public FraudCheckResponse(Boolean isFraudster) {
        this.isFraudster = isFraudster;
    }

    public FraudCheckResponse() {
    }

    public Boolean getIsFraudster() {
        return isFraudster;
    }

    public void setIsFraudster(Boolean isFraudster) {
        this.isFraudster = isFraudster;
    }
}
