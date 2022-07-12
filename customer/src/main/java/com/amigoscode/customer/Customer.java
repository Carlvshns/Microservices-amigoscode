package com.amigoscode.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
//Aqui farei o padrao Builder
public class Customer {
    
    @Id
    @SequenceGenerator(name = "customer_id_generator", sequenceName = "customer_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_sequence")
    private Integer id;
    private String firstName;
    private String lastname;
    private String email;

    public Customer(Integer id, String firstName, String lastname, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
    }
    
    public Customer() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }  
}
