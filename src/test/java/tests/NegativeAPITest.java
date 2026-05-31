package tests;

import com.automation.endpoints.UserEndpoints;
import com.automation.hook.BaseAPIEngine;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class NegativeAPITest extends BaseAPIEngine {

    private static final String xAPIKey = "free_user_3EP3yNsBVK9L6ejDWfwwcxkO12Y";

    @Test
    public void invalidEndpoint() {

        Response response = given()
                .header("x-api-key", xAPIKey)
                .when()
                .get("/unknownendpoint");

        finalResponse = response.asPrettyString();
        Assert.assertEquals(response.statusCode(), 404);
    }

    @Test
    public void invalidPayload() {

        String invalidJson = "{ invalid json }";

        Response response = given()
                .header("x-api-key", xAPIKey)
                .header("Content-Type", "application/json")
                .body(invalidJson)
                .when()
                .post(UserEndpoints.CREATE_USER);

        finalResponse = response.asPrettyString();
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(response.statusCode(), 400);

        Assert.assertEquals(jsonPath.getString("error"), "invalid_json");
        Assert.assertEquals(jsonPath.getString("message"), "The request body contains invalid JSON.");
        Assert.assertEquals(jsonPath.getString("details"), "Expected property name or '}' in JSON at position 2");
    }

    @Test
    public void getNonExistingUser() {

        Response response = given()
                .header("x-api-key", xAPIKey)
                .pathParam("id", 9999)
                .when()
                .get(UserEndpoints.GET_USER);

        finalResponse = response.asPrettyString();
        Assert.assertEquals(response.statusCode(), 404);
    }

    @Test
    public void unAuthorizedUser() {

        Response response = given()
                .pathParam("id", 9999)
                .when()
                .get(UserEndpoints.GET_USER);

        finalResponse = response.asPrettyString();
        Assert.assertEquals(response.statusCode(), 401);

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.getString("error"), "missing_api_key");
        Assert.assertEquals(jsonPath.getString("message"), "The x-api-key header is required for this endpoint.");
        Assert.assertEquals(jsonPath.getString("hint"), "Create a free key at app.reqres.in and send it as x-api-key.");
    }
}