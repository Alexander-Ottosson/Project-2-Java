package controllers;

import com.google.gson.Gson;
import entities.User;
import io.javalin.http.Handler;
import services.UserService;
import java.util.List;

public class UserController {

    private UserService us;
    private final Gson gson = new Gson();

    public UserController(UserService us) {
        this.us = us;
    }

    public Handler readAllUsers = (context) -> {

        List<User> users = us.readAllUsers();
        String usersJSON = gson.toJson(users);
        context.result(usersJSON);
    };

    public Handler readUserById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        User u = us.readUser(id);
        context.result(gson.toJson(u));
    };

    public Handler createUser = (context) -> {

        User u = gson.fromJson(context.body(), User.class);
        u = us.createUser(u);
        context.result(gson.toJson(u));
    };
    public Handler deleteUser = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        User u = us.deleteUser(id);
        context.result(gson.toJson(u));
    };
    public Handler updateUser = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));
        User change = us.deleteUser(id);
        context.result(gson.toJson(change));
    };
}
