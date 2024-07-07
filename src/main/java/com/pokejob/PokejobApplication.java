package com.pokejob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PokejobApplication {
    public static void main(String[] args) {
        SpringApplication.run(PokejobApplication.class, args);
    }
}
