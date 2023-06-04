package com.example.demo.customer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

//@Component(value = "fake")
//@Repository(value = "fake")
// We removed the @Repository(value = "fake") because now we are instantiating this class and selecting the implementation of CustomerRepo in the configuration.
public class CustomerFakeRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "James Bond"),
                new Customer(2L, "Aladin")
        );
    }
}
