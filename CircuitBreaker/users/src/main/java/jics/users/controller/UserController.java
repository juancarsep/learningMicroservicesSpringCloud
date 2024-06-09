package jics.users.controller;

import jics.users.dto.UserDTO;
import jics.users.model.User;
import jics.users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService service;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id){
        return service.getUser(id);
    }

    @GetMapping("/users/posts/{id}")
    public UserDTO getUserAndPosts(@PathVariable Long id){
        return service.getPostsByUserId(id);
    }

    @PostMapping("/users")
    public void saveUser(@RequestBody User user){
        service.saveUser(user);
    }

    @PutMapping("/users/{id}")
    public void editUser(@PathVariable Long id,
                         @RequestBody User editedUser){
        service.editUser(id, editedUser);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }
}

