package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@Component // When we use this annotation, Spring creates a new instance of this class. This Beans that we are instantiation have scope, the default scope is Singleton. So if we inject this instance into another constructor we are getting the same instance instead of creating multiple instances. Behind the scenes it's doing the new keyboard way of creating an instance, but everything is managed through Dependency Injection so we don't have to worry about the lifespan of this object because Spring manages it for us. Another scopes are Prototype, Request and Session but the most used one is Singleton, which is the default. Basically it creates a new instance that we can inject.
@Service // This annotation is more specific than @Component, they are the same thing but @Service gives more context by saying that this class is meant to be used as a service.
@AllArgsConstructor
@Slf4j // This annotation comes with Lombok, it creates the LOGGER and allows us to use it without explicitly declaring it with Dependency Injection..
public class CustomerService {
    //private final CustomerRepo customerRepo; Now we will use the CustomerRepository interface that extends JpaRepository

    //private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class); Removed because we have the logger thanks to @Slf4j

    private final CustomerRepository customerRepository;
// Deleted for using @AllArgsConstructor of Lombok
//    @Autowired() // Using Dependency Injection we make sure that this CustomerRepo class is going to be a Singleton, by default it takes the implementation annotated with @Primary.
//    public CustomerService(
//            //@Qualifier("fake") With this annotation we indicate Spring which implementation of CustomerRepo to use if we don't want the primary.
//            CustomerRepository customerRepository
//    ) {
//        this.customerRepository = customerRepository;
//    }

    List<Customer> getCustomers(){
        log.info("getCustomers was called");
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id) {

        return customerRepository
                .findById(id)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException("customer with id " + id + " not found");
                    log.error("error in getting customer {}", id, notFoundException);
                    return notFoundException;
                });
    }
}
