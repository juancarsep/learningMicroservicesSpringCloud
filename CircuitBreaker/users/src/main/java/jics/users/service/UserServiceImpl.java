package jics.users.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import jics.users.dto.PostDTO;
import jics.users.dto.UserDTO;
import jics.users.model.User;
import jics.users.repository.IPostsApi;
import jics.users.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    IUsersRepository repo;
    @Autowired
    IPostsApi postApi;

    @Override
    public void saveUser(User user) {
        repo.save(user);
    }

    @Override
    public User getUser(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @Override
    @CircuitBreaker(name="posts", fallbackMethod = "fallbackGetPostsByUserId")
    @Retry(name = "posts")
    public UserDTO getPostsByUserId(Long userId) {
        User user = this.getUser(userId);
        UserDTO userDto = new UserDTO();
        if(user!=null){
            List<PostDTO> posts = postApi.getPostsByUser(userId);
            userDto.setName(user.getName());
            userDto.setLastname(user.getLastname());
            userDto.setMobilePhone(user.getMobilePhone());
            userDto.setPosts(posts);
        }

        this.createException();

        return userDto;
    }

    public UserDTO fallbackGetPostsByUserId(Throwable throwable){
        return new UserDTO(99999999L, "Fallido", "Fallido", "Fallido", null);
    }

    @Override
    public void editUser(Long id, User editedUser) {
        User user = this.getUser(id);
        if(user!=null){
            user.setName(editedUser.getName());
            user.setLastname(editedUser.getLastname());
            user.setMobilePhone(editedUser.getMobilePhone());
            repo.save(user);
        }else{
            System.out.println("El usuario es null");
        }
    }

    @Override
    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

    public void createException(){
        throw new IllegalArgumentException("Prueba con Resilience y Circuit Breaker");
    }
}
