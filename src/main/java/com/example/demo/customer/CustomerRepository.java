package com.example.demo.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

//@Component
//@Repository
//@Primary // Makes this class the primary implementation of an interface, so @Autowired will automatically know which implementation to inject into the CustomerService attribute "customerRepo".
// We removed the @Repository @Primary because now we are instantiating this class and selecting the implementation of CustomerRepo in the configuration.

/*
public class CustomerRepository implements CustomerRepo { // We don't need this anymore because now we are connecting tou the h2 database.
    @Override
    public List<Customer> getCustomers() {
//      ToDo connect to real db
        return Collections.singletonList(
                new Customer(1L, "TODO. Implement real db", "password", "email@gmail.com")
        );
    }
}
*/
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
