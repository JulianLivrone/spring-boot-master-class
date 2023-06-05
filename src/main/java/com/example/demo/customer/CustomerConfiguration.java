package com.example.demo.customer;

import com.example.demo.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:false}") // This value comes from the program arguments in configurations when we run DemoApplication
    private Boolean useFakeCustomerRepo;

    @Value("${info.app.name}") // This value comes from application.properties
    private String appName;

    @Autowired
    private Environment environment; // This is not the recommended way to do it, the recommended way is to inject it in the constructor as we have already seen

    @Bean // Allows us to instantiate a class where we can have extra configuration and setup steps before the class is initialized. Useful when we want to initialize a class and have some setup or configure before initialization.
    CommandLineRunner commandLineRunner(InfoApp infoApp) { // We inject the configuration app in the commandLineRunner to execute some code using these environment variables.
        // We use this class when we want to do some setup when the application starts, and we can inject services or classes that we have and maybe add something to the database.
        return args -> {
            System.out.println("Command line runner hooray");
            System.out.println(appName);
            System.out.println(environment.getProperty("info.app.description"));
            System.out.println(infoApp);
        };
    }

    @Bean
    CustomerRepo customerRepo() {
        // This method selects which implementation of CustomerRepo to use at the start of the application depending on the value of the useFakeCustomerRepo variable in the configurations, with this setup we don't have to use @Qualifier for choosing which implementation. Ando also we don't have to use the @Repository and @Primary in CustomerFakeRepository and CustomerRepository because with this method alone, based on the app configuration, we already instantiate the corresponding class that we need, if we leave these annotations we would have two instances of each class, which may conduct to errors.
        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        //return useFakeCustomerRepo ? new CustomerFakeRepository() : new CustomerRepository();
        return new CustomerFakeRepository();
    }
}
