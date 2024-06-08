package dishes.dishes.controller;

import dishes.dishes.dto.DishDTO;
import dishes.dishes.model.Dish;
import dishes.dishes.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DishController {
    @Autowired
    IDishService service;

    @GetMapping("/dishes/{id}")
    public Dish getDish(@PathVariable Long id){
        return service.getDishById(id);
    }

    @GetMapping("/dishes")
    public List<Dish> getDishes(){
        return service.getDishes();
    }

    @PostMapping("/dishes")
    public void saveDish(@RequestBody DishDTO dishDto){
        service.saveDish(dishDto);
    }

    @PutMapping("/dishes/{id}")
    public void editDish(@PathVariable Long id,
                         @RequestBody Dish dish){
        service.editDish(id, dish);
    }

    @DeleteMapping("/dishes/{id}")
    public void deleteDish(@PathVariable Long id){
        service.deleteDish(id);
    }


}
