package steam.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
public class GameInfo {
    private List<String> info;
    public GameInfo (ArrayList<String> info) {
        this.info = info;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameInfo that = (GameInfo) o;

        return Objects.equals(info, that.info);
    }
    @Override
    public int hashCode() {
        return Objects.hash(info);
    }

}
