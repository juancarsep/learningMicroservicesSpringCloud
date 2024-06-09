package jics.users.service;

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
        return userDto;
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
}
