package get_http_request.day15;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private int id;
    private String name;
    private String states;
    //    “country”: {
    //        “id”: 3,
    //        “name”: “USA”,
    //        “states”: null
    //    },

}
