package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table // This last two annotations allows us to map this class to a table in our database.
@ToString // This annotation comes with Lombok, it creates the method toString() and updates it if we change the attributes of our class.
@AllArgsConstructor // This annotation comes with Lombok, it creates the constructor of the class with all the arguments and updates it if we change the attributes of our class.
@NoArgsConstructor // This annotation comes with Lombok, it creates the constructor of the class with no arguments and updates it if we change the attributes of our class.
// Lombok only allows for NoArgsConstructor() or AllArgsConstructor(), so if we need a constructor with some arguments I have to create it manually.
@EqualsAndHashCode // This annotation comes with Lombok, it creates the equals() and hashCode() methods of the class and updates it if we change the attributes of our class.
public class Customer {

    @Id
    private Long id;

    @NotBlank(message = "name must be not empty") // This annotation comes with spring-boot-starter-validation and forces that this property can't be blank. It only works with @Valid annotation on the service.
    private String name;

    @NotBlank(message = "email must be not empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Allows us to send passwords but not read a password from the client
    private String password;

    @NotBlank(message = "password must be not empty")
    @Email // This annotation comes with spring-boot-starter-validation and ensures that the email is valid. We can pass as a parameter the regular expression that we want if we want a custom validation. It only works with @Valid annotation on the service.
    private String email;


//    public Customer(Long id, String name, String password, String email) {
//        this.id = id
//        this.name = name;
//        this.password = password;
//        this.email = email;
//    }
//
//    public Customer() {
//    }

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

//    @Override
//    public String toString() {
//        return "Customer{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", password='" + password + '\'' +
//                ", email='" + email + '\'' +
//                '}';
//    }

}
