package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTestCases {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in/api";
    }
}
