package ingredients.ingredients.controller;

import ingredients.ingredients.model.Ingredient;
import ingredients.ingredients.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {
    @Autowired
    IngredientsService service;

    @GetMapping("/ingredients")
    public List<Ingredient> getAllIngredients(){
        return service.getIngredients();
    }

    @GetMapping("/ingredients/{id}")
    public Ingredient getIngredientById(@PathVariable Long id){
        return service.getIngredient(id);
    }

    @GetMapping("/ingredients/{dish}")
    public List<String> getIngredientsForDish(@PathVariable String dish){
        return service.getIngredientsForDish(dish);
    }

    @PostMapping("/ingredients")
    public void saveIngredient(@RequestBody Ingredient ingredient){
        service.saveIngredient(ingredient);
    }

    @PutMapping("/ingredients/{id}")
    public void editIngredient(@PathVariable Long id,
                               @RequestBody Ingredient ing){
        service.editIngredient(id, ing);
    }

    @DeleteMapping("/ingredients/{id}")
    public void deleteIngredient(@PathVariable Long id){
        service.deleteIngredient(id);
    }

}
