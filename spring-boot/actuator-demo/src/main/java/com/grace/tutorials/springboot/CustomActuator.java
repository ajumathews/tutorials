package com.grace.tutorials.springboot;

import lombok.Data;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@Endpoint(id ="system-details")
public class CustomActuator{

    @ReadOperation
    public SystemDetails getSystemDetails() {
        SystemDetails systemDetails = new SystemDetails();
        systemDetails.systemDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        return systemDetails;
    }

    @Data
    public class SystemDetails {
        private String systemDate;
    }
}
