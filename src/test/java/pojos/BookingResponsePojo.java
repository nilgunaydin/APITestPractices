package pojos;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookingResponsePojo {
    private int bookingid;
    private BookingPojo booking;


    public BookingResponsePojo() {
    }

    public BookingResponsePojo(int bookingId, BookingPojo bookingPojo) {
        this.bookingid = bookingId;
        this.booking = bookingPojo;
    }
}
