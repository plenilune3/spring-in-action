package com.plenilune.tacodata;

import com.plenilune.tacodomain.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@EnableJpaRepositories("com.plenilune.*")
public class IngredientService {

    IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Iterable<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

}
