package com.concurrentdesignsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.concurrentdesignsystem")
public class ConcurrentDesignSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConcurrentDesignSystemApplication.class, args);
    }
}
