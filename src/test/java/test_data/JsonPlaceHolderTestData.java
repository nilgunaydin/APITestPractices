package test_data;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public static Map<String, Object> setUpTestData(){

     Map<String, Object>expected = new HashMap<>();
        expected.put("completed",false);
        expected.put("statusCode",200);
        expected.put( "title","quis ut nam facilis et officia qui");
        expected.put( "userId",1 );
        expected.put( "via", "1.1 vegur");
        expected.put("Server", "cloudflare");

return expected ;
    }


    //    {
    //    "userId": 55,
    //    "title": "Tidy your room",
    //    "completed": false
    //  }

public JSONObject data() {
        JSONObject data = new JSONObject();
        data.put("userId", 55);
        data.put("title", "Tidy your room");
        data.put("completed", false);
        data.put("statusCode", 201);
        data.put("id", 201);
        return data;

}

public JSONObject setUpPutData(){

        JSONObject expectedRequest = new JSONObject();
        expectedRequest.put("userId", 21);
        expectedRequest.put("title","Wash the dishes");
        expectedRequest.put("completed",false);
        expectedRequest.put("id",198);
return expectedRequest;}


    public JSONObject setUpPatchData(){
        JSONObject expectedRequest = new JSONObject();
        expectedRequest.put("title", "Batch44");
        return expectedRequest;}


    public JSONObject setUpPatchExpectedData(){
        JSONObject expectedRequest = new JSONObject();
        expectedRequest.put("userId", 10);
        expectedRequest.put("title", "Batch44");
        expectedRequest.put("completed", true);
        expectedRequest.put("id", 198);
        return expectedRequest;}

//"userId": 10,
//"title": "Batch44"
//"completed": true,
//"id": 198

}
