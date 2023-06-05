package com.example.demo.infoapp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "info.app") // These annotations allow us to take commands on the application.properties file into a class. It's useful when you have to connect to a DB and use the environment variables store in application.properties
@Data
public class InfoApp {
    private String name;
    private String description;
    private String version;

// Replaced with @Data
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getVersion() {
//        return version;
//    }
//
//    public void setVersion(String version) {
//        this.version = version;
//    }
//
//    @Override
//    public String toString() {
//        return "InfoApp{" +
//                "name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", version='" + version + '\'' +
//                '}';
//    }
}
