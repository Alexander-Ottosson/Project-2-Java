package controllers;

import com.google.gson.Gson;
import entities.User;
import enums.AUTHS;
import enums.METHODS;
import io.javalin.http.Context;
import services.UserService;
import io.javalin.http.Handler;
import java.util.List;
import java.util.Objects;


public class UserController {

    private UserService us;
    private METHODS methods;
    private AUTHS auths;

    private Gson gson = new Gson();

    public UserController(UserService us, METHODS methods, AUTHS auths) {
        super();
        this.us = us;
        this.methods = methods;
        this.auths = auths;
    }

    public Handler readAllUsers = (context) -> {

        List<User> users = us.readAllUsers();
        String usersJSON = gson.toJson(users);

        context.result(usersJSON);

    };

    public Handler readUserById = (context)  ->{
        int userId = Integer.parseInt(context.pathParam("user_id"));
        User user = us.readUser(userId);
        context.result(gson.toJson(user));
    };

    public Handler createUser = (context) -> {
        String username = context.formParam("username");
        String password = context.formParam("password");
        METHODS contact = METHODS.valueOf(context.formParam("contact"));
        String info = context.formParam("info");
        AUTHS role = AUTHS.valueOf(context.formParam("role"));

        User user = gson.fromJson(context.body(), User.class);
        user = us.createUser(user);

        context.result(gson.toJson(user));
        context.status(200);
        context.result("Successfully inserted user, id returned: " + user);

    };

    public Handler deleteUser = (context) -> {

        int userId = Integer.parseInt(context.pathParam("user_id"));
        User user = us.deleteUser(userId);
        context.result(gson.toJson(user));
    };

    public Handler updateUser = (context) -> {
        int userId = Integer.parseInt(Objects.requireNonNull(context.formParam("user_id")));
        String username = context.formParam("username");
        String password = context.formParam("password");
        METHODS contact = METHODS.valueOf(context.formParam("contact"));
        String info = context.formParam("info");
        AUTHS role = AUTHS.valueOf(context.formParam("role"));

        User user = gson.fromJson(context.body(), User.class);
        user = us.updateUser(user);

        context.result(gson.toJson(user));
        context.status(200);
        context.result("Successfully updated id returned: " + user);

    };

    public Handler loginUser = (context) -> {

        String username = context.pathParam("username");
        String password = context.pathParam("password");

        gson.fromJson(context.body(), User.class);
        User user;
        user = us.loginUser(username, password);
        context.result(gson.toJson(user));
    };

    public void forgotPassword(Context ctx){
    }

    public void forgotUsername(Context ctx){
    }
}
