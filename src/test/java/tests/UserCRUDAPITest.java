package tests;

import com.automation.endpoints.UserEndpoints;
import com.automation.hook.BaseAPIEngine;
import com.automation.listeners.TestListener;
import com.automation.payloads.UserPayload;
import com.automation.utilities.ConfigReader;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Listeners(TestListener.class)
public class UserCRUDAPITest extends BaseAPIEngine {

    static int userId = 1;
    private static final String xAPIKey = ConfigReader.getProperty("xAPIKey");

    @Test(priority = 0)
    public void getUser() {

        Response response = given()
                .header("x-api-key", xAPIKey)
                .pathParam("id", userId)
                .when()
                .get(UserEndpoints.GET_USER);

        finalResponse = response.asPrettyString();
        response.then().log().all();

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertEquals(jsonPath.getInt("data.id"), userId);
        Assert.assertEquals(jsonPath.getString("data.email"), "george.bluth@reqres.in");
        Assert.assertEquals(jsonPath.getString("data.first_name"), "George");
        Assert.assertEquals(jsonPath.getString("data.last_name"), "Bluth");
        Assert.assertEquals(jsonPath.getString("data.avatar"), "https://reqres.in/img/faces/1-image.jpg");
    }

    @Test(priority = 1)
    public void createUser() {

        UserPayload payload =
                new UserPayload("alex.ferguson@reqres.in", "alex");
        Map map = new HashMap<>();
        Response response = given()
                .header("x-api-key", xAPIKey)
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(UserEndpoints.CREATE_USER);

        finalResponse = response.asPrettyString();
        response.then().log().all();
        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(jsonPath.getString("email"), payload.getEmail());
        Assert.assertEquals(jsonPath.getString("password"), payload.getPassword());

        userId = jsonPath.getInt("id");
        System.out.println("Created User with Id : " + userId + " at time : " + jsonPath.getString("createdAt"));
    }


    @Test(priority = 2)
    public void loginUser() {
        UserPayload payload =
                new UserPayload("eve.holt@reqres.in", "cityslicka");
        Response response = given()
                .header("x-api-key", xAPIKey)
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post(UserEndpoints.LOGIN_USER);

        finalResponse = response.asPrettyString();
        response.then().log().all();

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println("Token :" + jsonPath.getString("token"));
    }

    @Test(priority = 3)
    public void updateUser() {

        UserPayload payload =
                new UserPayload("lindsay.ferguson@reqres.in", "Lindsay");

        Response response = given()
                .header("x-api-key", xAPIKey)
                .header("Content-Type", "application/json")
                .pathParam("id", userId)
                .body(payload)
                .when()
                .put(UserEndpoints.UPDATE_USER);

        finalResponse = response.asPrettyString();
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.getString("email"), payload.getEmail());
        Assert.assertEquals(jsonPath.getString("password"), payload.getPassword());
        System.out.println("Update user at :" + jsonPath.getString("updatedAt"));
    }

    @Test(priority = 4)
    public void deleteUser() {

        Response response = given()
                .header("x-api-key", xAPIKey)
                .pathParam("id", userId)
                .when()
                .delete(UserEndpoints.DELETE_USER);

        finalResponse = response.asPrettyString();
        response.then().log().all();

        Assert.assertEquals(response.statusCode(), 204);
    }
}