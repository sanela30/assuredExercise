package JunitExercise;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.Matchers.*;



public class ExerciseAssert {

    @Test

    public void test_1(){

        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));

        int statusCode=response.getStatusCode();
        assertEquals(statusCode,200);
    }

    @Test
    public void test_2(){

        baseURI ="https://reqres.in/api";
        given().
                get("/users?page=2").
        then().
                statusCode(200).
                body("data.first_name",hasItems("George","Lindsay"));

    }
}
