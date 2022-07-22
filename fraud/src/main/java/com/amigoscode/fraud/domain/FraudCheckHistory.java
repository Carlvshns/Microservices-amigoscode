package com.amigoscode.fraud.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class FraudCheckHistory {
    
    @Id
    @SequenceGenerator(name = "fraud_id_sequence", sequenceName = "fraud_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_id_sequence")
    private Integer id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;
    
    public FraudCheckHistory(Integer id, Integer customerId, Boolean isFraudster, LocalDateTime createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.isFraudster = isFraudster;
        this.createdAt = createdAt;
    }

    public FraudCheckHistory() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Boolean getIsFraudster() {
        return isFraudster;
    }
    public void setIsFraudster(Boolean isFraudster) {
        this.isFraudster = isFraudster;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static final class Builder{
        
        private Integer id;
        private Integer customerId;
        private Boolean isFraudster;
        private LocalDateTime createdAt;

        private Builder (){
        }

        public static Builder newBuilder(){
            return new Builder();
        }

        public Builder id(Integer id){
            this.id = id;
            return this;
        }

        public Builder customerId(Integer customerId){
            this.customerId = customerId;
            return this;
        }

        public Builder isFraudster(Boolean isFraudster){
            this.isFraudster = isFraudster;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt){
            this.createdAt = createdAt;
            return this;
        }

        public FraudCheckHistory build(){
            FraudCheckHistory fraudCheckHistory = new FraudCheckHistory();
            fraudCheckHistory.setId(id);
            fraudCheckHistory.setCustomerId(customerId);
            fraudCheckHistory.setIsFraudster(isFraudster);
            fraudCheckHistory.setCreatedAt(createdAt);
            return fraudCheckHistory;
        }
    } 
}
