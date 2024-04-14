package com.suren.universitymanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class UniversityManagementApplication {

    private static final Logger logger = LoggerFactory.getLogger(UniversityManagementApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(UniversityManagementApplication.class, args);
        logger.info("University Enrollment Application started successfully.");
    }

}
