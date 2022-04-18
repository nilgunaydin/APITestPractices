package test_data;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyTestData {
    /*
http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
Status kodun 200 olduğunu,
14. Çalışan isminin "Haley Kennedy" olduğunu,
Çalışan sayısının 24 olduğunu,
Sondan 3. çalışanın maaşının 675000 olduğunu
40,21 ve 19 yaslarında çalışanlar olup olmadığını
10. Çalışan bilgilerinin bilgilerinin aşağıdaki gibi

{
        "id": 10,
        "employee_name": "Sonya Frost",
        "employee_salary": 103600,
        "employee_age": 23,
        "profile_image": ""
 }

  olduğunu test edin.
*/

    //En yüksek maaşın 725000 olduğunu,
    //En küçük yaşın 19 olduğunu,
    //İkinci en yüksek maaşın 675000
    //olduğunu test edin.

    public HashMap<String,Object> setupTestData2(){
        HashMap<String,Object> expected = new HashMap();
        expected.put("enYuksekMaas", 725000 );
        expected.put("statusCode", 200 );
        expected.put("enKucukYas",19);
        expected.put("2.yuksekMaas",675000);

        return expected;
    }



    public HashMap<String,Object> setupTestData(){

        List<Integer> employee_age_list = new ArrayList<>();
        employee_age_list.add(40);
        employee_age_list.add(21);
        employee_age_list.add(19);

        HashMap<String,Object> onBirinci = new HashMap();
        onBirinci.put("id", 11);
        onBirinci.put("employee_name", "Jena Gaines");
        onBirinci.put("employee_salary", 90560);
        onBirinci.put("employee_age", 30);
        onBirinci.put("profile_image", "");

        HashMap<String,Object> expected = new HashMap();
        expected.put("5.calisan","Airi Satou");
        expected.put("statusCode",200);
        expected.put("calisanSayisi",24);
        expected.put("sondan2.CalisaninMaasi", 106450 );
        expected.put("arananYaslar",employee_age_list);
        expected.put("onBirinci",onBirinci);

    return expected;}

public Map<String,Object> PostVeri(){
         Map<String,Object> postVerisi = new HashMap();
        postVerisi.put("name","Ali Can");
        postVerisi.put("age","40");
        postVerisi.put("salary","2000");

return postVerisi;}



public Map<String,Object> expected(){
    Map<String,Object> data = new HashMap();
        data.put("id","");

 Map<String,Object> expectedData = new HashMap();
 expectedData.put("status","success");
 expectedData.put("statusCode",200);
 expectedData.put("message","Successfully! Record has been added.");

    return expectedData; }
    public JSONObject setUpDeleteData(){
        JSONObject expectedData = new JSONObject();
        expectedData.put("status", "success");
        expectedData.put("data", "2");
        expectedData.put("message", "Successfully! Record has been deleted");
        return expectedData;
    }


}