package com.coderscampus.assignment9.repository;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import com.coderscampus.assignment9.domain.Recipe;

@Component
public class RecipeRepository {
	
	  public List<Recipe> repository = new ArrayList<>(100);
	  
	  public RecipeRepository() throws IOException { propogate(); }
	  
	  private void propogate() throws IOException {
	  
		  Reader in = new FileReader("recipes.txt"); 
		  Iterable<CSVRecord> records = CSVFormat.DEFAULT
			  				.withEscape('\\')
			  				.withIgnoreSurroundingSpaces()
			  				.withFirstRecordAsHeader()
			  				.parse(in); 
	  
		  for(CSVRecord record : records) {
			  Recipe recipe = new Recipe();
			  recipe.setCookingMinutes(Integer.parseInt(record.get(0)));
			  recipe.setDairyFree(Boolean.parseBoolean(record.get(1)));
			  recipe.setGlutenFree(Boolean.parseBoolean(record.get(2)));
			  recipe.setInstructions(record.get(3));
			  recipe.setPreparationMinutes(Double.parseDouble(record.get(4)));
			  recipe.setPricePerServing(Double.parseDouble(record.get(5)));
			  recipe.setReadyInMinutes(Integer.parseInt(record.get(6)));
			  recipe.setServings(Integer.parseInt(record.get(7)));
			  recipe.setSpoonacularScore(Double.parseDouble(record.get(8)));
			  recipe.setTitle(record.get(9));
			  recipe.setVegan(Boolean.parseBoolean(record.get(10)));
			  recipe.setVegetarian(Boolean.parseBoolean(record.get(11)));
			  repository.add(recipe);	 
	  		} 
	  }
	  
	  public List<Recipe> getRepository() { // TODO Auto-generated method stub
		  return repository; 
	  }
	 
}
