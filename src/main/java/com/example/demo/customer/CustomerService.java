package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@Component // When we use this annotation, Spring creates a new instance of this class. This Beans that we are instantiation have scope, the default scope is Singleton. So if we inject this instance into another constructor we are getting the same instance instead of creating multiple instances. Behind the scenes it's doing the new keyboard way of creating an instance, but everything is managed through Dependency Injection so we don't have to worry about the lifespan of this object because Spring manages it for us. Another scopes are Prototype, Request and Session but the most used one is Singleton, which is the default. Basically it creates a new instance that we can inject.
@Service // This annotation is more specific than @Component, they are the same thing but @Service gives more context by saying that this class is meant to be used as a service.
public class CustomerService {
    private final CustomerRepo customerRepo;

    @Autowired() // Using Dependency Injection we make sure that this CustomerRepo class is going to be a Singleton, by default it takes the implementation annotated with @Primary.
    public CustomerService(
            //@Qualifier("fake") With this annotation we indicate Spring which implementation of CustomerRepo to use if we don't want the primary.
            CustomerRepo customerRepo
    ) {
        this.customerRepo = customerRepo;
    }

    List<Customer> getCustomers(){
        return customerRepo.getCustomers();
    }

    Customer getCustomer(Long id) {
        return getCustomers()
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("customer with id " + id + " not found"));
    }
}
