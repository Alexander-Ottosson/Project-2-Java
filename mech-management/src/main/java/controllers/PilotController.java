package controllers;

import com.google.gson.Gson;
import entities.Pilot;
import io.javalin.http.Handler;
import services.PilotService;

import java.util.List;

public class PilotController {

    private PilotService ps;

    private final Gson gson = new Gson();

    public PilotController(PilotService ps) {
        this.ps = ps;
    }

    public Handler readAllPilots = (context) -> {
        List<Pilot> pilots = ps.readAllPilots();
        String pilotsJSON = gson.toJson(pilots);
        context.result(pilotsJSON);
    };
    public Handler getPilot1ById = (context) -> {

        int pilotId = Integer.parseInt(context.pathParam("pilot_id"));
        Pilot p = ps.readPilot(pilotId);
        context.result(gson.toJson(p));
    };
    public Handler getPilot2ById = (context) -> {

        int pilot2Id = Integer.parseInt(context.pathParam("pilot2_id"));
        Pilot p = ps.readPilot2(pilot2Id);
        context.result(gson.toJson(p));
    };

}
