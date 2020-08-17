package com.plenilune.tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.plenilune.tacodomain")
public class TacoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoApplication.class, args);
    }
}
