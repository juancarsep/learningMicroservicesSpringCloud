package jics.users.service;

import jics.users.dto.PostDTO;
import jics.users.dto.UserDTO;
import jics.users.model.User;

import java.util.List;

public interface IUserService {
    public void saveUser(User user);
    public User getUser(Long id);
    public List<User> getAllUsers();
    public UserDTO getPostsByUserId(Long userId);
    public void editUser(Long id, User editedUser);
    public void deleteUser(Long id);
}
