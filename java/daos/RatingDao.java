package daos;

import entities.Rating;

import java.sql.SQLException;
import java.util.List;

public interface RatingDao {

    public int createRating(Rating rating) throws SQLException;

    public Rating readRating(int id) throws SQLException;

    public List<Rating> readAllRatings() throws SQLException;

    public boolean updateRating(Rating rating) throws SQLException;

    public boolean deleteRating(int id) throws SQLException;

}
