package com.plenilune.tacodata;

import com.plenilune.tacodomain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
