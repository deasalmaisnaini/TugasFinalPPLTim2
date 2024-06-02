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
    
    private static void setUpHeader(String appId) {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", appId);
    }

    public static Response getListUsers(String endpoint) {
        setUpHeader("662c1846fc6498241d22b20b"); // set up header
        return request.when().get(endpoint); // call API to get list user
    }
    
    public static Response getListUsersMissingAppId(String endpoint) {
        setUpHeader(""); // set up header
        return request.when().get(endpoint); // call API to get list user
    }
    
    public static Response getListUsersInvalidAppId(String endpoint) {
        setUpHeader("12345678"); // set up header
        return request.when().get(endpoint); // call API to get list user
    }



    public static Response getProfileUser(String url, String idUser) {
        setUpHeader("662c1846fc6498241d22b20b"); // set up header
        String endpoint = url + idUser; // assign end point for get current user id
        System.out.println("Final Endpoint : " + endpoint);
        return request.when().get(endpoint); // call API to get profile user
    }
    
    public static Response getProfileUserMissingAppId(String url, String idUser) {
        setUpHeader(""); // set up header
        String endpoint = url + idUser; // assign end point for get current user id
        System.out.println("Final Endpoint : " + endpoint);
        return request.when().get(endpoint); // call API to get profile user
    }
    
    public static Response getProfileUserInvalidAppId(String url, String idUser) {
        setUpHeader("1234567abcd"); // set up header
        String endpoint = url + idUser; // assign end point for get current user id
        System.out.println("Final Endpoint : " + endpoint);
        return request.when().get(endpoint); // call API to get profile user
    }


    public static Response postCreateUserAppIDValid(String endpoint, UserPreview dataTestCreateUser) {
        // create data with json format
        Gson payload = new Gson();
        System.out.println(endpoint);
        System.out.println("Gson :" + payload.toJson(dataTestCreateUser));
        setUpHeader("662c1846fc6498241d22b20b"); // set up header
        return request.body(payload.toJson(dataTestCreateUser)).when().post(endpoint); // call API create user
    }
    
    public static Response postCreateUserAppIDEmpty(String endpoint, UserPreview dataTestCreateUser) {
        Gson payload = new Gson();
        String jsonPayload = payload.toJson(dataTestCreateUser);
        System.out.println("Payload: " + jsonPayload);
        System.out.println("Endpoint: " + endpoint);
        
        // Panggil metode setUpHeader() sebelum menggunakan objek request
        setUpHeader("662c1846fc6498241d22b20b"); // Atur app-id kosong
        
        // Cetak pernyataan dengan benar tanpa tanda kurung di dalamnya
        System.out.println("Halooo");
        Response response = request.body(payload.toJson(dataTestCreateUser)).when().post(endpoint);
        System.out.println(response); // Cetak respons
        return response; // kembalikan respons
    }


    public static Response putUser(String url, Map<String, String> dataUserUpdate, String idUser) {
        String endpoint = url + "/" + idUser;
        Gson payload = new Gson();
        String jsonPayload = payload.toJson(dataUserUpdate);
        System.out.println("Payload: " + jsonPayload);
        System.out.println("Endpoint: " + endpoint);
        setUpHeader("662c1846fc6498241d22b20b"); // set up header
        return request.body(jsonPayload).when().put(endpoint); // call API edit user
    }

    public static Response deleteUserById(String url, String idUser) {
        String endpoint = url + idUser;
        setUpHeader("662c1846fc6498241d22b20b"); // set up header
        return request.when().delete(endpoint); // call API to get delete user by id
    }
    
    public static Response deleteUserByIdInvalidAppIdMissing(String url, String idUser) {
        String endpoint = url + idUser;
        setUpHeader(""); // set up header
        return request.when().delete(endpoint); // call API to get delete user by id
    }
    
    public static Response deleteUserByIdInvalidAppId(String url, String idUser) {
        String endpoint = url + idUser;
        setUpHeader("123456"); // set up header
        return request.when().delete(endpoint); // call API to get delete user by id
    }
}
