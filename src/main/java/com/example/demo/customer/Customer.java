package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    private final Long id;
    private final String name;
    private final String password;

    public Customer(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
