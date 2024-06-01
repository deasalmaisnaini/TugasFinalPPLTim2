package APITesting.testlogic.requestAPItesting;

import APITesting.model.UserPreview;
import APITesting.model.UserProfile;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import org.json.JSONObject;

public class RequestAPIUserManagement {
    private static RequestSpecification request;

    private static void setUpHeader() {
        request = RestAssured.given()
                .header("Content-Type", "application/json") // set the header tp accept json
                .header("Accept", "application/json")
                .header("app-id", "662c1846fc6498241d22b20b");
    }

    public static Response getListUsers(String endpoint) {
        setUpHeader(); // set up header
        return request.when().get(endpoint); // call API to get list user
    }

    public static Response getProfileUser(String url, String idUser) {
        setUpHeader(); // set up header
        String endpoint = url + idUser; // assign end point for get current user id
        System.out.println("Final Endpoint : " + endpoint);
        return request.when().get(endpoint); // call API to get profile user
    }

    public static Response postCreateUser(String endpoint, UserPreview dataTestCreateUser) {
        // create data with json format
        Gson payload = new Gson();
        System.out.println(endpoint);
        System.out.println("Gson :" + payload.toJson(dataTestCreateUser));
        setUpHeader(); // set up header
        return request.body(payload.toJson(dataTestCreateUser)).when().post(endpoint); // call API create user
    }

    public static Response putUser(String url, Map<String, String> dataUserUpdate, String idUser) {
        String endpoint = url + "/" + idUser;
        Gson payload = new Gson();
        String jsonPayload = payload.toJson(dataUserUpdate);
        System.out.println("Payload: " + jsonPayload);
        System.out.println("Endpoint: " + endpoint);
        setUpHeader(); // set up header
        return request.body(jsonPayload).when().put(endpoint); // call API edit user
    }

    public static Response deleteUserById(String url, String idUser) {
        String endpoint = url + idUser;
        setUpHeader(); // set up header
        return request.when().delete(endpoint); // call API to get delete user by id
    }
}
