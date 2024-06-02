package APITesting.testlogic;

import APITesting.model.UserPreview;
import APITesting.model.UserProfile;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import APITesting.helper.SetUpEndPoint;
import io.opentelemetry.semconv.SemanticAttributes;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import APITesting.testlogic.APITestProcessGeneric;
import APITesting.testlogic.requestAPItesting.RequestAPIUserManagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class APIUserTest {

    private Response res;

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    // hit api get list users
    public void hitAPIGetListUsersMissingAppId() {
        res = RequestAPIUserManagement.getListUsersMissingAppId(SetUpEndPoint.getEndPoint()); // call API Get List User
        System.out.println(res.getBody().asString()); // logging response API
    }
    
    public void hitAPIGetListUsersInvalidAppId() {
        res = RequestAPIUserManagement.getListUsersInvalidAppId(SetUpEndPoint.getEndPoint()); // call API Get List User
        System.out.println(res.getBody().asString()); // logging response API
    }
    
    public void hitAPIGetListUsers() {
        res = RequestAPIUserManagement.getListUsers(SetUpEndPoint.getEndPoint()); // call API Get List User
        System.out.println(res.getBody().asString()); // logging response API
    }

    /*
     * check response body lis user consist of data (id, title, firstName, lastName,
     * picture), total, page, and limit
     */
    public void checkResponseBodyListUsers() {
        System.out.println("validation response body list user process");
        JSONArray data = new JSONArray(res.getBody().jsonPath().getList("data")); // get data json in array
        for (int i = 0; i < data.length(); i++) {
            JSONObject user = (JSONObject) data.get(i); // get element array

            // verify data
            Assert.assertNotNull(user.get("id"));
            assertThat(user.get("title")).isIn("mr", "ms", "mrs", "miss", "dr", ""); // check title value between mr,
                                                                                     // ms, mrs, miss, dr, and blank
            Assert.assertNotNull(user.get("firstName")); // check first name not null
            Assert.assertNotNull(user.get("lastName")); // check last name not null
        }
    }

    public void hitAPIGetProfileUser(String idUser) {
        res = RequestAPIUserManagement.getProfileUser(SetUpEndPoint.getEndPoint(), idUser); // call API Get List User
        System.out.println(res.getBody().asString()); // logging response API
    }
    
    

    public void checkResponseBodyProfileUser() {
        System.out.println("validation response body profile user process normal");
        JSONObject userProfile = new JSONObject(res.getBody().asString()); // get data json in object

        // verify data
        Assert.assertNotNull(userProfile.get("id"));
        assertThat(userProfile.get("title")).isIn("mr", "ms", "mrs", "miss", "dr", ""); 
                                                                                        
        Assert.assertNotNull(userProfile.get("firstName")); 
        Assert.assertNotNull(userProfile.get("lastName"));
        assertThat(userProfile.get("gender")).isIn("male", "female", ""); 
    }

    public void checkResponseBodyGetProfileUserFailed(String expectedMessage) {
        System.out.println("validation response body profile user process failed");
        JSONObject notification = new JSONObject(res.getBody().asString()); // get data json in object

        // verify data
        String actualMessage = notification.get("error").toString();
        System.out.println("actual message: " + actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    

    public Response hitAPIPostNewUser(String currentEndpoint, UserPreview dataTestCreateUser) {
    	  // Logging untuk memastikan parameter tidak null
        System.out.println("Endpoint: " + currentEndpoint);
        System.out.println("User Data: " + dataTestCreateUser);
        
        if (dataTestCreateUser.getFirstName().contains("Nathan")) {
            res = RequestAPIUserManagement.postCreateUserAppIDEmpty(currentEndpoint, dataTestCreateUser);
        } else {
            res = RequestAPIUserManagement.postCreateUserAppIDValid(currentEndpoint, dataTestCreateUser);
        }
        
        // Logging response API
        System.out.println("API Response: " + res.getBody().asString());
        
        return res;
    }

 
    public String hitAPIPostNewUserForUpdate(String endPoint, UserPreview dataUser) {
        res = RequestAPIUserManagement.postCreateUserAppIDValid(endPoint, dataUser); //call API Post New User
        System.out.println("halo" + res.getBody().asString()); // logging response API
        

        return res.getBody().jsonPath().get("id");
    }


    public void hitAPIUpdateProfileUser(Map<String, String> userData, String idUser) {
        res = RequestAPIUserManagement.putUser(SetUpEndPoint.getEndPoint(), userData, idUser); // call API Put User by
                                                                                               // Id
        System.out.println(res.getBody().asString()); // logging response API
    }
    
    public void checkErrorInResponseBody(String expectedErrorMessage) {
        System.out.println("Checking error message in response body");
        JsonObject responseBody = new Gson().fromJson(res.getBody().asString(), JsonObject.class);
        
        if (responseBody.has("error")) {
            String actualErrorMessage = responseBody.get("error").getAsString();
            System.out.println("Actual error message: " + actualErrorMessage);
            System.out.println("Expected error message: " + expectedErrorMessage);
            Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        } else {
            Assert.fail("No error message found in response body");
        }
    }

  

    public void checkResponseBodyCreateUser(UserPreview dataTestCreateUser) throws ParseException {
        System.out.println("test logic for check response body create user");
        // please add code detail
        Gson json = new Gson();
        UserProfile actualData = json.fromJson(res.getBody().asString(), UserProfile.class);
        System.out.print("Actual Data : ");
        System.out.println(json.toJson(actualData));
        System.out.print("Test Data : ");
        System.out.println(json.toJson(dataTestCreateUser));
        Assert.assertEquals(actualData.getTitle(), dataTestCreateUser.getTitle());
        Assert.assertEquals(actualData.getFirstName(), dataTestCreateUser.getFirstName());
        Assert.assertEquals(actualData.getLastName(), dataTestCreateUser.getLastName());
        Assert.assertEquals(actualData.getGender(), dataTestCreateUser.getGender());
        Assert.assertEquals(actualData.getEmail(), dataTestCreateUser.getEmail());
        // Validate if registerDate and updatedDate are today's date
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Assert.assertEquals(actualData.getRegisterDate().substring(0, 10), currentDate);
        Assert.assertEquals(actualData.getUpdatedDate().substring(0, 10), currentDate);
    }

    

    public void checkResponseBodyUpdateProfileUser(UserPreview dataTestUpdateUser, String idUserUpdate)
            throws ParseException {
        System.out.println("test logic for check response body update user");
        // please add code detail
        Gson json = new Gson();
        UserPreview actualData = json.fromJson(res.getBody().asString(), UserPreview.class);
        System.out.print("Actual Data : ");
        System.out.println(json.toJson(actualData));
        System.out.print("Test Data : ");
        System.out.println(json.toJson(dataTestUpdateUser));
        Assert.assertEquals(actualData.getId(), idUserUpdate);
        Assert.assertEquals(actualData.getTitle(), dataTestUpdateUser.getTitle());
        Assert.assertEquals(actualData.getFirstName(), dataTestUpdateUser.getFirstName());
        Assert.assertEquals(actualData.getLastName(), dataTestUpdateUser.getLastName());
        Assert.assertEquals(actualData.getGender(), dataTestUpdateUser.getGender());
        // Validate if registerDate and updatedDate are today's date
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Assert.assertEquals(actualData.getRegisterDate().substring(0, 10), currentDate);
        Assert.assertEquals(actualData.getUpdatedDate().substring(0, 10), currentDate);
    }

    

    public void hitAPIDeleteUserById(String idUser) {
        res = RequestAPIUserManagement.deleteUserById(SetUpEndPoint.getEndPoint(), idUser);
        System.out.println("response after hit API delete");
        System.out.println(res.getBody().asString());
    }
    
    public void hitAPIDeleteUserByIdInvalidAppId(String idUser) {
        res = RequestAPIUserManagement.deleteUserByIdInvalidAppId(SetUpEndPoint.getEndPoint(), idUser);
        System.out.println("response after hit API delete");
        System.out.println(res.getBody().asString());
    }
    
    public void hitAPIDeleteUserByIdMissingAppid(String idUser) {
        res = RequestAPIUserManagement.deleteUserByIdInvalidAppIdMissing(SetUpEndPoint.getEndPoint(), idUser);
        System.out.println("response after hit API delete");
        System.out.println(res.getBody().asString());
    }

    public void checkResponseBodyDeleteUser(String idUserDelete) {
        System.out.println("test logic for check response body delete user");
        // please add code detail
        System.out.println("id Delete:" + res.getBody());
        Assert.assertNotNull(res.getBody().jsonPath().get("id"));

    }


}
