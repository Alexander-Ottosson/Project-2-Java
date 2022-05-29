package Controller;

import com.google.gson.Gson;
import io.javalin.http.Handler;
import Models.Mech;
import Service.MechService;

import java.util.List;


public class MechController {
    private MechService ms;
    private Gson gson = new Gson();

    public MechController(MechService ms) {
        this.ms = ms;
    }

    public Handler getAllMechs = (context) -> {

        List<Mech> mechs = ms.getAllMechs();
        String mechsJSON = gson.toJson(mechs);
        //You pass information through result() to send information back (response)
        context.result(mechsJSON);
    };
}
