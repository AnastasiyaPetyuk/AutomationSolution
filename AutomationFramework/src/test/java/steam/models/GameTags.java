package steam.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class GameTags {
    private List<String> tags;
    public GameTags (ArrayList<String> tags) {
        this.tags = tags;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameTags that = (GameTags) o;

        return Objects.equals(tags, that.tags);
    }
    @Override
    public int hashCode() {
        return Objects.hash(tags);
    }
}
