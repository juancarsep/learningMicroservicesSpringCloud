package ingredients.ingredients.service;

import ingredients.ingredients.model.Ingredient;

import java.util.List;

public interface IngredientsService {
    public void saveIngredient(Ingredient ing);
    public Ingredient getIngredient(Long id);
    public List<Ingredient> getIngredients();
    public void editIngredient(Long id, Ingredient ingredient);
    public void deleteIngredient(Long id);
    public List<String> getIngredientsForDish(String dishName);
}
