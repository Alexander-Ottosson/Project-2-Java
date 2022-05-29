package App;


import Controller.MechController;
import io.javalin.Javalin;
import Repo.MechRepo;
import Repo.MechRepoImpl;
import Service.MechService;
import Service.MechServiceImpl;
import io.javalin.core.JavalinConfig;

import static io.javalin.apibuilder.ApiBuilder.*;

public class App {

    public static void main(String[] args) {

        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);

        //Establish our Routes
        establishRoutes(app);

        //Javalin does, by default, run on Port 7000
        app.start();

    }

    private static void establishRoutes(Javalin app) {

        MechRepo mr = new MechRepoImpl();
        MechService ms = new MechServiceImpl(mr);
        MechController mc = new MechController(ms);

        app.get("/mech", mc.getAllMechs);

    }
}
