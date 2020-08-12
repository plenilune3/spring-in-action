package com.plenilune.practice.controller;

import com.plenilune.practice.dao.IngredientRepository;
import com.plenilune.practice.dao.TacoRepository;
import com.plenilune.practice.domain.Ingredient;
import com.plenilune.practice.domain.Order;
import com.plenilune.practice.domain.Taco;
import com.plenilune.practice.domain.Ingredient.Type;

import com.plenilune.practice.service.IngredientService;
import com.plenilune.practice.service.TacoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientService ingredientService;
    private final TacoService tacoService;

    @Autowired
    public DesignTacoController(IngredientService ingredientService,
                                TacoService tacoService) {
        this.ingredientService = ingredientService;
        this.tacoService = tacoService;
    }


    @GetMapping
    public String showDesignForm(Model model) {

        sortByType(model);

        model.addAttribute("taco", new Taco());

        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco design,
                                Errors errors,
                                Model model,
                                @ModelAttribute Order order) {

        sortByType(model);

        if (errors.hasErrors()) {
            return "design";
        }

        Taco saved = tacoService.saveTaco(design);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }

    private void sortByType(Model model) {
        List<Ingredient> ingredients = ingredientService.findAllIngredient();

        Type[] types = Type.values();

        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }
}
