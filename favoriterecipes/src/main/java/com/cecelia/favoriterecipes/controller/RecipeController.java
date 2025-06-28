package com.cecelia.favoriterecipes.controller;

import com.cecelia.favoriterecipes.model.Recipe;
import com.cecelia.favoriterecipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("recipes", recipeRepository.findAll());
        return "home";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "add";
    }

    @PostMapping("/add")
    public String addRecipe(@ModelAttribute Recipe recipe) {
        recipeRepository.save(recipe);
        return "redirect:/";
    }

    @GetMapping("/recipe/{id}")
    public String viewRecipe(@PathVariable Long id, Model model) {
        Recipe recipe = recipeRepository.findById(id).orElse(null);
        model.addAttribute("recipe", recipe);
        return "view";
    }
}
