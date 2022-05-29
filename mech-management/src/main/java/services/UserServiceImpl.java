package services;

import daos.UserDao;
import entities.User;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserDao ud;

    public UserServiceImpl(UserDao ud) {
        this.ud = ud;
    }
    @Override
    public User createUser(User u) {
        return ud.createUser(u);
    }

    @Override
    public User readUser(int id) {
        return ud.readUser(id);
    }

    @Override
    public List<User> readAllUsers() {
        return ud.readAllUsers();
    }

    @Override
    public User updateUser(User change) {
        return ud.updateUser(change);
    }

    @Override
    public User deleteUser(int id) {
        return ud.deleteUser(id);
    }

    @Override
    public User loginUser(String username, String password) {
        return ud.loginUser(username, password);
    }
}
