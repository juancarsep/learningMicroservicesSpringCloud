package dishes.dishes.service;

import dishes.dishes.dto.DishDTO;
import dishes.dishes.model.Dish;
import dishes.dishes.repository.IDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class DishServiceImpl implements IDishService{

    @Autowired
    IDishRepository repo;
    @Autowired
    RestTemplate consumeApi;

    @Override
    public void saveDish(DishDTO dishDto) {
        Dish dish = new Dish();
        List<String> ingredients = Arrays.asList(consumeApi.getForObject("http://localhost:9002/ingredients/" + dishDto.getName(), String.class));

        dish.setName(dishDto.getName());
        dish.setPrice(dishDto.getPrice());
        dish.setDescription(dishDto.getDescription());
        dish.setIngredients(ingredients);

        repo.save(dish);
    }

    @Override
    public List<Dish> getDishes() {
        return repo.findAll();
    }

    @Override
    public Dish getDishById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Dish getDishByName(String name) {
        return repo.getDishByName(name);
    }

    @Override
    public void editDish(Long id, Dish dish) {
        Dish d = this.getDishById(id);
        if(d != null){
            d.setName(dish.getName());
            d.setPrice(dish.getPrice());
            d.setDescription(dish.getDescription());
            d.setIngredients(dish.getIngredients());
            repo.save(d);
        }
    }

    @Override
    public void deleteDish(Long id) {
        repo.deleteById(id);
    }
}
