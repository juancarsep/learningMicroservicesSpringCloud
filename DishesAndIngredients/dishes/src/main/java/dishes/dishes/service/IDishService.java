package dishes.dishes.service;

import dishes.dishes.dto.DishDTO;
import dishes.dishes.model.Dish;

import java.util.List;

public interface IDishService {

    public void saveDish(DishDTO dish);
    public List<Dish> getDishes();
    public Dish getDishById(Long id);
    public Dish getDishByName(String name);
    public void editDish(Long id, Dish dish);
    public void deleteDish(Long id);

}
