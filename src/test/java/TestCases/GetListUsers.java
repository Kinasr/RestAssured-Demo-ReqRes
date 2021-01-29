package TestCases;

import base.BaseTestCases;
import dataProviders.UserDataProvider;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class GetListUsers extends BaseTestCases {

    private final String url = "/users?page=2";

    @Test
    public void validateResponseCode()  {
        given()
                .header("Content-type", "application/json")
                .when()
                .get(url)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void validateResponseCode2() {
        Response response = RestAssured.get(url);
        assertEquals(response.statusCode(), 200);
    }

    @Test(dataProvider = "getUsersDataFromPage2", dataProviderClass = UserDataProvider.class)
    public void validateCustomersDataInSecondPage(String userRank, String userEmail, String userFirstName,
                                                      String userLastName, String userAvatar) {
        given()
                .when()
                .get(url)
                .then()
                .assertThat()
                .body("data[" + userRank + "].'email'", equalTo(userEmail))
                .and()
                .assertThat()
                .body("data[" + userRank + "].'first_name'", equalTo(userFirstName))
                .and()
                .assertThat()
                .body("data[" + userRank + "].'last_name'", equalTo(userLastName))
                .and()
                .assertThat()
                .body("data[" + userRank + "].'avatar'", equalTo(userAvatar));
    }
}
