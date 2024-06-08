package ingredients.ingredients.service;

import ingredients.ingredients.model.Ingredient;
import ingredients.ingredients.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientsService{

    @Autowired
    IngredientsRepository repo;

    @Override
    public void saveIngredient(Ingredient ing) {
        repo.save(ing);
    }

    @Override
    public Ingredient getIngredient(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Ingredient> getIngredients() {
        return repo.findAll();
    }

    @Override
    public void editIngredient(Long id, Ingredient ingredient) {
        Ingredient ingre = this.getIngredient(id);
        if(ingre != null){
            ingre.setName(ingredient.getName());
            ingre.setDishes(ingredient.getDishes());
            repo.save(ingre);
        }
    }

    @Override
    public void deleteIngredient(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<String> getIngredientsForDish(String dishName) {
        List<Ingredient> allIngredients = this.getIngredients();
        List<String> ingred = new ArrayList<>();
        for(Ingredient ingre : allIngredients){
            List<String> dishes = ingre.getDishes();
            for(String dish : dishes){
                if(dish.equalsIgnoreCase(dishName)){
                    ingred.add(ingre.getName());
                }
            }
        }
        return ingred;
    }
}
