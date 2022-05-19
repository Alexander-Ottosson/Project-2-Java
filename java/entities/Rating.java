package entities;

public class Rating {
    private int id;
    private int userId;
    private int mechId;
    private int stars;
    private String review;

    public Rating() {
        super();
    }
        public Rating(int id, int userId, int mechId, int stars, String review) {
        super();
            this.id = id;
            this.userId = userId;
            this.mechId = mechId;
            this.stars = stars;
            this.review = review;
        }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public int getStars() {
        return stars;
    }
    public void setStars(int stars) {
        this.stars = stars;
    }
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
}
