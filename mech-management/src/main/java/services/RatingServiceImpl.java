package services;

import daos.RatingDao;
import entities.Rating;

import java.util.List;

public class RatingServiceImpl implements RatingService{

    private RatingDao rd;

    public RatingServiceImpl(RatingDao rd) {
        this.rd = rd;
    }

    @Override
    public Rating createRating(Rating r) {
        return rd.createRating(r);
    }

    @Override
    public Rating readRating(int ratingId) {
        return rd.readRating(ratingId);
    }

    @Override
    public List<Rating> readAllRatings() {
        return rd.readAllRatings();
    }

    @Override
    public Rating updateRating(Rating change) {
        return rd.updateRating(change);
    }

    @Override
    public Rating deleteRating(int ratingId) {
        return rd.deleteRating(ratingId);
    }
}
