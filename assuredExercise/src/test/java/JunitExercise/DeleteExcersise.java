package JunitExercise;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;

public class DeleteExcersise {

    @Test
    public void DeleteExample(){

        baseURI="https://gorest.co.in/public/v2/users/4416";

        String token = "39c035f1ee6dc38e97e3ec1816cceb4c4a204dfb29466dc53c305db1aaf02f25";
        String authToken = "Bearer " + token;


        //Call API

        RequestSpecification requestSpecification = RestAssured.given()
                .header("Authorization",authToken).contentType("application/json");

        Response response = requestSpecification.delete();
        int statusCode = response.getStatusCode();

        System.out.println(statusCode);

    }
}
