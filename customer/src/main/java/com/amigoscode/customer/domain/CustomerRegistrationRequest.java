package com.amigoscode.customer.domain;
//Aqui poderia ser utilizado record, mas estou utilizando Java 11, futuramente voltarei aqui e refatorarei
public class CustomerRegistrationRequest {

    private String firstName;
    private String lastname;
    private String email;
    
    public CustomerRegistrationRequest(String firstName, String lastname, String email) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
    }

    public CustomerRegistrationRequest() {
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
