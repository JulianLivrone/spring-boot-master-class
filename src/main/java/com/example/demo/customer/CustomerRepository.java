package com.example.demo.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component // Makes this class a Bean, this means that the Spring environment will know this class and will be able to inject it into other classes (Dependency Injection)
@Primary // Makes this class the primary implementation of an interface, so @Autowired will automatically know which implementation to inject into the CustomerService attribute "customerRepo"
public class CustomerRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
//      ToDo connect to real db
        return Collections.singletonList(
                new Customer(1L, "TODO. Implement real db")
        );
    }
}
