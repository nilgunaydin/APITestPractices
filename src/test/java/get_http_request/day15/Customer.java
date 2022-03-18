package get_http_request.day15;

import java.util.List;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String email;
private String mobilePhoneNumber;
    private String phoneNumber;
    private String zipCode;
    private String address;
    private String city;
private String ssn;
private String createDate;
private String zelleEnrolled;
private Country country;
    private String state;
    private User user;
  private List accounts;
}
