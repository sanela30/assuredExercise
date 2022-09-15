package JunitExercise;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;

public class NewPractice {

    @Test
    public void TestPost(){

        baseURI = "";
        String apiCall= "https://gorest.co.in/public/v2/users";

        //Create Payload

        JSONObject jsonObject= new JSONObject();
        jsonObject.put("name","Milos");
        jsonObject.put("email","milosmiki@hyk.co");
        jsonObject.put("gender","male");
        jsonObject.put("status","active");

        String payLoad = jsonObject.toJSONString();

        String token = "39c035f1ee6dc38e97e3ec1816cceb4c4a204dfb29466dc53c305db1aaf02f25";
        String authToken = "Bearer " + token;



        //Call API

        RequestSpecification requestSpecification = RestAssured.given()
                .header("Authorization",authToken).contentType("application/json")
                .body(payLoad);

        Response response = requestSpecification.post(apiCall);
        int statusCode = response.getStatusCode();

        System.out.println(statusCode);

        String payLoadData = response.body().prettyPrint();
        System.out.println(payLoadData);
    }




}
