package pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JsonPlaceHolderPojo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public JsonPlaceHolderPojo() {}

    public JsonPlaceHolderPojo(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }
}
