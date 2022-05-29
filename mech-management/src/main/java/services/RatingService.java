package services;

import entities.Rating;

import java.util.List;

public interface RatingService {

    public Rating createRating(Rating r);

    public Rating readRating(int ratingId);

    public List<Rating> readAllRatings();

    public Rating updateRating(Rating change);

    public Rating deleteRating(int ratingId);
}
