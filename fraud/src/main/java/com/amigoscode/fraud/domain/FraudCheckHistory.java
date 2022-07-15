package com.amigoscode.fraud.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
//Aqui nesta classe havera um builder
public class FraudCheckHistory {
    
    @Id
    @SequenceGenerator(name = "fraud_id_sequence", sequenceName = "fraud_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_id_sequence")
    private Integer id;
    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;
    
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
}
