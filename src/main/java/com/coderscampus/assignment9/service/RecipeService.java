package com.coderscampus.assignment9.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.repository.RecipeRepository;

@Service
public class RecipeService  {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	public List<Recipe> getAll() {
		RecipeRepository recipeRepository = applicationContext.getBean(RecipeRepository.class);
		return recipeRepository.getRepository();
	}
	
	public List<Recipe> getVegetarian() { 
		RecipeRepository recipeRepository = applicationContext.getBean(RecipeRepository.class);
		return recipeRepository.getRepository().stream()
										   .filter(s -> s.getVegetarian())
										   .collect(Collectors.toList());										
	}
	
	public List<Recipe> getVegan() {
		RecipeRepository recipeRepository = applicationContext.getBean(RecipeRepository.class);
		return recipeRepository.getRepository().stream()
											   .filter(s -> s.getVegan())
											   .collect(Collectors.toList());
	}

	public List<Recipe> getGlutenFree() {
		RecipeRepository recipeRepository = applicationContext.getBean(RecipeRepository.class);
		return recipeRepository.getRepository().stream()
											   .filter(s -> s.getGlutenFree())
											   .collect(Collectors.toList());	
	}
}
