package steam.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
public class GameInfo {
    private String name;
    private String reviewStatus;
    private String price;
    private List<String> tags;

    public GameInfo (String name, String reviewStatus, String price, List<String> tags) {
        this.name = name;
        this.reviewStatus = reviewStatus;
        this.price = price;
        this.tags = tags;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameInfo that = (GameInfo) o;
        return Objects.equals(name, that.name) && Objects.equals(reviewStatus, that.reviewStatus) && Objects.equals(price, that.price) && Objects.equals(tags.subList(0, 3), that.tags.subList(0, 3));
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, reviewStatus, price, tags);
    }

}
