package apiPractice.Niluferhoca.pojos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class DataPojo {
    private int id;
    private String employee_name;
    private int employee_salary;
    private int employee_age;
    private String profile_image;
}