package JunitExercise;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

public class PutExercise {

    @Test
    public void putExcerise(){

        //baseURI ="https://gorest.co.in/public/v2/users/4051";
        String apiCall = "https://gorest.co.in/public/v2/users/4051";
        //Create Payload

        JSONObject jsonObject= new JSONObject();
        jsonObject.put("name","MANJASS MALIC");
        jsonObject.put("email","manmjay_VD@gotte.biz");
        jsonObject.put("gender","female");
        jsonObject.put("status","inactive");



        String payLoad = jsonObject.toJSONString();

        String token = "39c035f1ee6dc38e97e3ec1816cceb4c4a204dfb29466dc53c305db1aaf02f25";
        String authToken = "Bearer " + token;


        //Call API

        RequestSpecification requestSpecification = RestAssured.given()
                .header("Authorization",authToken).contentType("application/json")
                .body(payLoad);

        Response response = requestSpecification.patch(apiCall);
        int statusCode = response.getStatusCode();

        System.out.println(statusCode);

        String payLoadData = response.body().prettyPrint();
        System.out.println(payLoadData);
    }
}
