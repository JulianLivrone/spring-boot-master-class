package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Customer {
    private final Long id;

    @NotBlank // This annotation comes with spring-boot-starter-validation and forces that this property can't be blank. It only works with @Valid annotation on the service.
    private final String name;

    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Allows us to send passwords but not read a password from the client
    private final String password;

    @NotBlank
    @Email // This annotation comes with spring-boot-starter-validation and ensures that the email is valid. We can pass as a parameter the regular expression that we want if we want a custom validation. It only works with @Valid annotation on the service.
    private final String email;

    public Customer(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    @JsonProperty("customer_id") // It allows us to change the name of the property when we return it to the client (before was id and now customer_id)
    public Long getId() {
        return id;
    }

    public String getName() { // Jackson uses the getters in order to know what to return back to the client and with which name and value
        return name;
    }

    @JsonIgnore // So the application doesn't return the password in the JSON object back to the client.
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
