package com.gmail.dissa.vadim.superkid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SuperkidApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperkidApplication.class, args);
    }
}
