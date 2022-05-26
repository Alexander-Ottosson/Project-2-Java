package entities;

import enums.STARS;

import java.util.Objects;

public class Rating {
    private int ratingId;
    private int userId;
    private int mechId;
    private STARS stars;
    private String review;

    public Rating() {
        super();
    }
    public Rating(int ratingId, int userId, int mechId, STARS stars, String review) {
        super();
        this.ratingId = ratingId;
        this.userId = userId;
        this.mechId = mechId;
        this.stars = stars;
        this.review = review;
    }
    public int getRatingId() {
        return ratingId;
    }
    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getMechId() {
        return mechId;
    }
    public void setMechId(int mechId) {
        this.mechId = mechId;
    }
    public STARS getStars() {
        return stars;
    }
    public void setStars(STARS stars) {
        this.stars = stars;
    }
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRatingId(), getUserId(), getMechId(), getStars(), getReview());
    }

    @Override
    public String toString() {
        return "Rating{" +
                "ratingId=" + ratingId +
                ", userId='" + userId + '\'' +
                ", mechId=" + mechId +
                ", stars=" + stars +
                ", review=" + review +
                '}';
    }
}
