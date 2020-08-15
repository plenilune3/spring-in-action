package com.plenilune.practice;

import com.plenilune.practice.dao.IngredientRepository;
import com.plenilune.practice.domain.Ingredient;
import com.plenilune.practice.domain.Ingredient.Type;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeApplication.class, args);
    }
}
