package pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DummyDataPojo {
    //   "id": 1,
    //   "employee_name": "Tiger Nixon",
    //   "employee_salary": 320800,
    //   "employee_age": 61,
    //   "profile_image": ""

    private int id;
    private String employee_name;
    private int employee_salary;
    private String employee_age;
    private String profile_image;

    public DummyDataPojo() {
    }

    public DummyDataPojo(int id, String employee_name, int employee_salary, String employee_age, String profile_image) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }
}
