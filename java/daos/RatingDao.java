package daos;

import entities.Rating;
import java.util.List;

public interface RatingDao {

    public Rating createRating(Rating rating);

    public Rating readRating(int ratingId);

    public List<Rating> readAllRatings();

    public Rating updateRating(Rating change);

    public Rating deleteRating(int ratingId);

}
