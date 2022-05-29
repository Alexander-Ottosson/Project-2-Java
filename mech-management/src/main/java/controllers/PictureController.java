package controllers;

import com.google.gson.Gson;
import entities.Picture;
import entities.Pilot;
import io.javalin.http.Handler;
import services.PictureService;

import java.util.List;


public class PictureController {
    private PictureService ps;

    private final Gson gson = new Gson();

    public PictureController(PictureService ps) {
        this.ps = ps;
    }
    public Handler readAllPictures = (context) -> {
        List<Picture> pictures = ps.readAllPictures();
        String picturesJSON = gson.toJson(pictures);
        context.result(picturesJSON);
    };
    public Handler getPictureById = (context) -> {

        int pictureId = Integer.parseInt(context.pathParam("picture_id"));
        Picture p = ps.readPicture(pictureId);
        context.result(gson.toJson(p));
    };
    public Handler deletePicture = (context) -> {

        int pictureId = Integer.parseInt(context.pathParam("picture_id"));
        Picture p = ps.deletePicture(pictureId);
        context.result(gson.toJson(p));
    };
    public Handler createPicture = (context) -> {

        Picture p = gson.fromJson(context.body(), Picture.class);
        p = ps.createPicture(p);
        context.result(gson.toJson(p));
    };
    public Handler updatePicture = (context) -> {

        int pictureId = Integer.parseInt(context.pathParam("picture_id"));
        Picture change = ps.deletePicture(pictureId);
        context.result(gson.toJson(change));
    };
}
