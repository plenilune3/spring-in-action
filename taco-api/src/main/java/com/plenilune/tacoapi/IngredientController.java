package com.plenilune.tacoapi;

import com.plenilune.tacodata.IngredientService;
import com.plenilune.tacodomain.Ingredient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/ingredientsx", produces = "application/json")
@CrossOrigin(origins = "*")
public class IngredientController {

    final private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public Iterable<Ingredient> allIngredients() {
        return ingredientService.findAll();
    }

}
