package services;

import daos.UserDao;
import entities.User;
import enums.AUTHS;
import enums.METHODS;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserDao ud;
    private static byte[] salty = "enVariable".getBytes();

    public UserServiceImpl(UserDao ud) {
        super();
        this.ud = ud;
    }

    @Override
    public User readUser(int userId) {
        return ud.readUser(userId);
    }

    @Override
    public List<User> readAllUsers() {
        return ud.readAllUsers();
    }

    @Override
    public User createUser( User user) {
        return ud.createUser(user);
    }

    @Override
    public User updateUser(User change) {
        return ud.updateUser(change);
    }

    @Override
    public User deleteUser(int userId) {
        return ud.deleteUser(userId);
    }
    @Override
    public User loginUser(String username, String password){
        return ud.loginUser(username, password);
    }
}
