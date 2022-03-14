package pojos;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookingResponsePojo {
    private int bookingId;
    private BookingPojo bookingPojo;

    public BookingResponsePojo() {
    }

    public BookingResponsePojo(int bookingId, BookingPojo bookingPojo) {
        this.bookingId = bookingId;
        this.bookingPojo = bookingPojo;
    }
}
