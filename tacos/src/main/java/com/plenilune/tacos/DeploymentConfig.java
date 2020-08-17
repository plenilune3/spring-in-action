package com.plenilune.tacos;

import com.plenilune.tacodata.IngredientRepository;
import com.plenilune.tacodomain.Ingredient;
import com.plenilune.tacodomain.Ingredient.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("!prod")
@Configuration
public class DeploymentConfig {

}
