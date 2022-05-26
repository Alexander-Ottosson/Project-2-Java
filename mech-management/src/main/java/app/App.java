package app;

import controllers.UserController;
import daos.UserDao;
import daos.UserDaoImpl;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;
import services.UserService;
import services.UserServiceImpl;

public class App {

    public static void main(String[] args) {

        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);

        establishRoutes(app);

        app.start();
}
    private static void establishRoutes(Javalin app) {

        UserDao ud = new UserDaoImpl();
        UserService us = new UserServiceImpl(ud);
        UserController uc = new UserController(us);

        app.get("/welcome", (context) -> context.result("Welcome Landing Page!"));
        app.get("/welcome2", new WelcomePageHandler());

        app.get("/users", uc.readAllUsers);
        app.get("/user/id", uc.readUserById);
        app.post("/user", uc.createUser);
        app.put("user/id", uc.updateUser);
        app.delete("/user/<user_id>", uc.deleteUser);

//        app.routes(() -> {
//            path("users", () -> {
//                get(uc.readAllUsers);
//                post(uc.createUser);
//                path(":user_id", () -> {
//                    get(uc.readUserById);
//                    put(uc.updateUser);
//                    delete(uc.deleteUser);
//                });
//            });
//        });
    }
}

