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

    public String hitAPIPostNewUser(UserPreview dataTestCreateUser) {
        res = RequestAPIUserManagement.postCreateUser(SetUpEndPoint.getEndPoint(), dataTestCreateUser); // call API Post New User
        System.out.println(res.getBody().asString()); // logging response API

        return res.getBody().jsonPath().get("id");
    }


    public String hitAPIPostNewUser(String endPoint, UserPreview dataUser) {
        res = RequestAPIUserManagement.postCreateUser(endPoint, dataUser); //call API Post New User
        System.out.println(res.getBody().asString()); // logging response API

        return res.getBody().jsonPath().get("id");
    }


    public void hitAPIUpdateProfileUser(Map<String, String> userData, String idUser) {
        res = RequestAPIUserManagement.putUser(SetUpEndPoint.getEndPoint(), userData, idUser); // call API Put User by
                                                                                               // Id
        System.out.println(res.getBody().asString()); // logging response API
    }
    
  

    public void checkResponseBodyCreateUser(UserProfile dataTestUser) throws ParseException {
        System.out.println("test logic for check response body create user");
        // please add code detail
        Gson json = new Gson();
        UserProfile actualData = json.fromJson(res.getBody().asString(), UserProfile.class);
        System.out.print("Actual Data : ");
        System.out.println(json.toJson(actualData));
        System.out.print("Test Data : ");
        System.out.println(json.toJson(dataTestUser));
        Assert.assertEquals(actualData.getTitle(), dataTestUser.getTitle());
        Assert.assertEquals(actualData.getFirstName(), dataTestUser.getFirstName());
        Assert.assertEquals(actualData.getLastName(), dataTestUser.getLastName());
        Assert.assertEquals(actualData.getGender(), dataTestUser.getGender());
        Assert.assertEquals(actualData.getEmail(), dataTestUser.getEmail());
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        Assert.assertEquals(sdfDate.format(sdfTime.parse(actualData.getRegisterDate())), sdfDate.format(new Date()));
        Assert.assertEquals(sdfDate.format(sdfTime.parse(actualData.getUpdatedDate())), sdfDate.format(new Date()));

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
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        Assert.assertEquals(sdfDate.format(sdfTime.parse(actualData.getRegisterDate())), sdfDate.format(new Date()));
        Assert.assertEquals(sdfDate.format(sdfTime.parse(actualData.getUpdatedDate())), sdfDate.format(new Date()));

    }

    public void hitAPIDeleteUserById(String idUser) {
        res = RequestAPIUserManagement.deleteUserById(SetUpEndPoint.getEndPoint(), idUser);
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
