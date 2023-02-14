package steam.entity;

import steam.models.GameInfo;

import java.util.List;

public class GameEntity {
    private String name;
    private String reviewStatus;
    private String price;
    private List<String> tags;
    public GameEntity(String name, String reviewStatus, String price, List<String> tags) {
        this.name = name;
        this.reviewStatus = reviewStatus;
        this.price = price;
        this.tags = tags;
    }
    public GameInfo getGameInfo() {
        String name = this.name;
        String reviewStatus = this.reviewStatus;
        String price = this.price;
        List<String> tags = this.tags;

        return new GameInfo(name, reviewStatus, price, tags);
    }
    public String getName() {
        return name;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public String getPrice() {
        return price;
    }
    public List<String> getTags() {
        return tags;
    }
}
