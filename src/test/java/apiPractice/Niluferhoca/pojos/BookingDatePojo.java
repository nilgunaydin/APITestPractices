package apiPractice.Niluferhoca.pojos;

public class BookingDatePojo {

    private String checkin;
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public BookingDatePojo() {
    }

    public BookingDatePojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "BookingDatePojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }



}
