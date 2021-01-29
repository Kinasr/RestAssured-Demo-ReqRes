package TestCases;

import base.BaseTestCases;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetSingleUser extends BaseTestCases {

    private final String usrId = "2";
    private final String url = "/users/" + usrId;

    @Test
    public void ValidateSingleUserStatusCode() {
        given()
                .header("Content-type", "application/json")
                .when()
                .get(url)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test(dependsOnMethods = "ValidateSingleUserStatusCode")
    public void ValidateSingleUserData() {
        given()
                .header("Content-type", "application/json")
                .when()
                .get(url)
                .then()
                .assertThat()
                .body("data.'email'", equalTo("janet.weaver@reqres.in"));
    }
}
