package pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DummyPojo {
    //"status": "success",
    // "data": { }
    // "message": "Successfully! Record has been fetched."

    private String status;
    private String message;
    private DummyDataPojo data;

    public DummyPojo() {
    }

    public DummyPojo(String status, String message, DummyDataPojo data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
