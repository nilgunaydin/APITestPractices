package get_http_request.day15;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private int id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String activated;
    private String langKey;
    private String imageUrl;
    private String resetDate;
}
