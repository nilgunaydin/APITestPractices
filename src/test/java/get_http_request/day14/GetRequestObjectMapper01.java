package get_http_request.day14;

import base_url.JsonPlaceHolderBaseUrl;
import org.junit.Test;
import utilities.JsonUtil;

public class GetRequestObjectMapper01 extends JsonPlaceHolderBaseUrl {
//https://jsonplaceholder.typicode.com/todos/198 url’ine bir get request gönderildiğinde,
//Dönen response ’un status kodunun 200 ve body kısmının
// {
// “userId”: 10,
// “id”: 198,
// “title”: “quis eius est sint explicabo”,
// “completed”: true
// }
//Olduğunu Object Mapper kullanarak test edin


@Test
    public void test1(){
    //URL olustur.
    specJson.pathParams("param1", "todos", "param2", 198);

    //expected olustur

    String expected = " {\n" +
            " “userId”: 10,\n" +
            " “id”: 198,\n" +
            " “title”: “quis eius est sint explicabo”,\n" +
            " “completed”: true\n" +
            " }";
    JsonUtil.convertJsonToJava(expected);







}
}
