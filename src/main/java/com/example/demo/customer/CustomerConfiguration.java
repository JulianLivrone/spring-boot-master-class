package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;

    @Bean // Allows us to instantiate a class where we can have extra configuration and setup steps before the class is initialized.
    CommandLineRunner commandLineRunner() {
        // We use this class when we want to do some setup when the application starts, and we can inject services or classes that we have and maybe add something to the database.
        return args -> {
            System.out.println("Command line runner hooray");
        };
    }

    @Bean // Useful when we want to initialize a class and have some setup or configure before initialization.
    CustomerRepo customerRepo() {
        // This method selects which implementation of CustomerRepo to use at the start of the application depending on the configuration, with this setup we can not use @Qualifier.
        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        return useFakeCustomerRepo ? new CustomerFakeRepository() : new CustomerRepository();
    }
}
