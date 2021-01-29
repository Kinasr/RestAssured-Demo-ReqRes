package TestCases;

import base.BaseTestCases;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.Calendar;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class PostCreate extends BaseTestCases {

    @Test
    public void createUser() {
        var timestamp = Calendar.getInstance().getTimeInMillis();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "morpheus" + timestamp); // Cast
        requestParams.put("job", "leader");


        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestParams.toJSONString())
                .when()
                .post("/users")
                .then()
                .extract().response();
        assertEquals(response.statusCode(), 201);
        assertEquals(response.jsonPath().getString("name"), "morpheus" + timestamp);
    }

    @Test
    public void createUser2() {
        var timestamp = Calendar.getInstance().getTimeInMillis();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "morpheus" + timestamp); // Cast
        requestParams.put("job", "leader");

        given()
                .header("Content-type", "application/json")
                .and()
                .body(requestParams.toJSONString())
                .when()
                .post("/users")
                .then()
                .assertThat()
                .body("name", equalTo("morpheus" + timestamp))
                .and()
                .assertThat()
                .body("job", equalTo("leader"));
    }
}
