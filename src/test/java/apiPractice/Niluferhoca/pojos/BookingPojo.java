package apiPractice.Niluferhoca.pojos;

import pojos.BookingDatesPojo;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class BookingPojo {
   private String firstname;
   private String lastname;
   private int totalprice;
   private boolean depositpaid;
    private BookingDatesPojo bookingdates;
}
