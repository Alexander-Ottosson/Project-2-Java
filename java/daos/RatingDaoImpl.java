package daos;

import entities.Rating;
import enums.STARS;
import util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RatingDaoImpl implements RatingDao {

    public static Connection conn = JDBCConnection.getConnection();

    @Override
    public Rating createRating(Rating rating) {
        String sql = "INSERT INTO rating VALUES (DEFAULT, ?, ?, ?::STARTS, ?) RETURNING *";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, rating.getUserId());
            ps.setInt(2, rating.getMechId());
            ps.setString(3, rating.getStars().toString());
            ps.setString(4, rating.getReview());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return buildRating(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Rating readRating(int ratingId) {
        String sql = "SELECT * FROM rating WHERE rating_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ratingId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return buildRating(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Rating> readAllRatings() {
        String sql = "SELECT * FROM rating";

        try{
           PreparedStatement ps = conn.prepareStatement(sql);

           ResultSet rs = ps.executeQuery();
           List<Rating> ratings = new ArrayList<>();

           while(rs.next()) {
               ratings.add(buildRating(rs));
           }
           return ratings;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Rating updateRating(Rating change) {
        try {
            String sql = "UPDATE rating SET user_id = ?, mech_id = ?, stars = ?::STARS, review = ? WHERE rating_id = ?" +
                    "RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, change.getUserId());
            ps.setInt(2, change.getMechId());
            ps.setString(3, change.getStars().toString());
            ps.setString(4, change.getReview());
            ps.setInt(5, change.getRatingId());

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return buildRating(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Rating deleteRating(int ratingId) {
        try {
            String sql = "DELETE FROM rating WHERE rating_id = ? RETURNING *";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, ratingId);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                return buildRating(rs);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Rating buildRating(ResultSet rs) throws SQLException {
        Rating rating = new Rating();
        rating.setRatingId(rs.getInt("rating_id"));
        rating.setUserId(rs.getInt("user_id"));
        rating.setMechId(rs.getInt("mech_id"));
        rating.setStars(STARS.valueOf(rs.getString("stars")));
        rating.setReview(rs.getString("review"));

        return rating;
    }
}
