package com.coderscampus.assignment9.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.service.RecipeService;

@RestController
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	/*

	@GetMapping("/vegan-and-gluten-free")

	
	*/
	
	@GetMapping("/all-recipes")
	public List<Recipe> getAllRecipes() {
		return recipeService.getAll();
	}
	
	@GetMapping("/vegetarian")
	public List<Recipe> getVegetarian() {
		return recipeService.getVegetarian();
	}
	
	@GetMapping("/vegan")
	public List<Recipe> getVegan() {
		return recipeService.getVegan();
	}
	
	@GetMapping("/gluten-free")
	public List<Recipe> getGlutenFree() {
		return recipeService.getGlutenFree();
	}
	
	
}
