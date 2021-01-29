package TestCases;

import base.BaseTestCases;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Delete extends BaseTestCases {

    private final String url = "/api/users/2";

    @Test
    public void deleteUser() {
        given()
                .header("Content-type", "application/json")
                .when()
                .delete(url)
                .then()
                .assertThat()
                .statusCode(204);

//        assertEquals(response.statusCode(), 204);
    }
}
