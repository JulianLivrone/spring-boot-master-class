package com.example.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data // This annotation comes with Lombok, it creates the required constructors, getters, setters (not in this case because our attributes are final), toString() equals() and hashCode() methods of the class and updates it if we change the attributes of our class.
public class ApiException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;

//    public ApiException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {
//        this.message = message;
//        this.throwable = throwable;
//        this.httpStatus = httpStatus;
//        this.zonedDateTime = zonedDateTime;
//    }

//    public String getMessage() {
//        return message;
//    }
//
//    public Throwable getThrowable() {
//        return throwable;
//    }
//
//    public HttpStatus getHttpStatus() {
//        return httpStatus;
//    }
//
//    public ZonedDateTime getZonedDateTime() {
//        return zonedDateTime;
//    }

//    @Override
//    public String toString() {
//        return "ApiException{" +
//                "message='" + message + '\'' +
//                ", throwable=" + throwable +
//                ", httpStatus=" + httpStatus +
//                ", zonedDateTime=" + zonedDateTime +
//                '}';
//    }
}
