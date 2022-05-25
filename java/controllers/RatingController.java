package controllers;

import com.google.gson.Gson;
import java.util.List;
import java.util.Objects;

import entities.Rating;
import enums.STARS;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import services.RatingService;

public class RatingController {

    private RatingService rs;
    private STARS stars;
    private Gson gson = new Gson();


    public RatingController(RatingService rs, STARS stars) {
        super();
        this.rs = rs;
        this.stars = stars;
    }
    public Handler readAllRatings = (context) -> {

        List<Rating> ratings = rs.readAllRatings();
        String ratingsJSON = gson.toJson(ratings);

        context.result(ratingsJSON);

    };

    public Handler readRatingById = (context)  ->{
        int ratingId = Integer.parseInt(context.pathParam("rating_id"));
        Rating r = rs.readRating(ratingId);
        context.result(gson.toJson(r));
    };

    public Handler createRating = (context) -> {
        int userId = Integer.parseInt(Objects.requireNonNull(context.formParam("user_id")));
        int mechId = Integer.parseInt(Objects.requireNonNull(context.formParam("rating_id")));
        STARS stars = STARS.valueOf(context.formParam("stars"));
        String review = context.formParam("review");

        Rating r = gson.fromJson(context.body(), Rating.class);
        r = rs.createRating(r);

        context.result(gson.toJson(r));
        context.status(200);
        context.result("Successfully inserted rating, id returned: " + r);

    };

    public Handler deleteRating = (context) -> {

        int ratingId = Integer.parseInt(context.pathParam("rating_id"));
        Rating r = rs.deleteRating(ratingId);
        context.result(gson.toJson(r));
    };

    public Handler updateRating = (context) -> {
        int ratingId = Integer.parseInt(Objects.requireNonNull(context.formParam("rating_id")));
        int userId = Integer.parseInt(Objects.requireNonNull(context.formParam("user_id")));
        int mechId = Integer.parseInt(Objects.requireNonNull(context.formParam("rating_id")));
        STARS stars = STARS.valueOf(context.formParam("stars"));
        String review = context.formParam("review");

        Rating r = gson.fromJson(context.body(), Rating.class);
        r = rs.updateRating(r);

        context.result(gson.toJson(r));
        context.status(200);
        context.result("Successfully updated id returned: " + r);

    };
}
