package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/v1/customer")
@RestController // Allows us to handle HTTP requests.
@Deprecated // Tells us that this version of our API is deprecated and that we should use another version
public class CustomerController {

    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "all")
    List<Customer> getCustomer() {
        return customerService.getCustomers();
    }

    @PostMapping
    void createNewCustomer(@RequestBody /* @RequestBody Allows us to get the JSON object on the body that the client send us. */ Customer customer) {
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody /* @RequestBody Allows us to get the JSON object the client send us. */ Customer customer) {
        System.out.println("UPDATE REQUEST...");
        System.out.println(customer);
    }

    @DeleteMapping(path = "/{customerId}")
    void deleteCustomer(@PathVariable("customerId") /* @PathVariable Allows us to get parameters from URL. */ Long id) {
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID " + id);
    }
}
