package com.plenilune.tacos;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages = "com.plenilune.*")
@EntityScan(basePackages = "com.plenilune.*")
public class TacoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TacoApplication.class, args);
    }
}
