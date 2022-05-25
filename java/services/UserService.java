package services;

import entities.User;
import enums.AUTHS;
import enums.METHODS;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public User readUser(int userId);
    public List<User> readAllUsers();
    public User createUser(User user);
    public User updateUser(User change);
    public User deleteUser(int userId);
    public User loginUser(String username, String password);
}
