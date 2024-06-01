package stepDefinitions.apitesting;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import APITesting.helper.SetUpEndPoint;
import APITesting.model.UserPreview;
import io.restassured.response.Response;
import APITesting.testlogic.APITestProcessGeneric;
import APITesting.testlogic.APIUserTest;
import APITesting.testlogic.requestAPItesting.RequestAPIUserManagement;

public class UpdateUserStep {
    APIUserTest apiUser;
    UserPreview dataTestCreateUser;
	UserPreview updatedUserData;
    String currentUserID;
    private Response response;
    
    public UpdateUserStep(){
        apiUser = new APIUserTest();
    }


    @Given("prepare url for {string}")
    public void prepareUrlFor(String endpoint) {
    	 // prepare end point API
    	System.out.println(endpoint);
        SetUpEndPoint.prepareEndPoint(endpoint); // prepare end point
    }

    @Given("hit api post create new user for create new user")
    public void hitApiPostCreateNewUserForCreateNewUser() {
    	 dataTestCreateUser = APITestProcessGeneric.prepareDataUserTestPost();
         currentUserID = apiUser.hitAPIPostNewUser(APITesting.testlogic.requestAPItesting.EndPoint.CREATE_USER, dataTestCreateUser);
         System.out.println("current id after created : " + currentUserID);
     }

    @When("hit api update profile user with data")
    public void hit_api_update_profile_user_with_data(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> userData = new HashMap<>();
        dataTable.asMaps().forEach(row -> {
            String field = row.get("field");
            String value = row.get("value");
            userData.put(field, value);
        });
        
        apiUser.hitAPIUpdateProfileUser(userData, currentUserID);
        
        // Update dataTestUpdateUser with the new values
        for (Map.Entry<String, String> entry : userData.entrySet()) {
            updatedUserData = APITestProcessGeneric.prepareDataUserTestUpdate(entry.getKey(), entry.getValue());
        }
    }

    @Then("validation status code api user is equals {int}")
    public void validationStatusCodeApiUserIsEquals(int statusCode) throws ParseException {
    	  APITestProcessGeneric.validationStatusCode(apiUser.getRes(), statusCode);
    }
    

    @Then("validation response body update user")
    public void validationResponseBodyUpdateUser() throws ParseException {
    	apiUser.checkResponseBodyUpdateProfileUser(updatedUserData, currentUserID);
    	 
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String dataType) throws IOException {
    	 APITesting.testlogic.APITestProcessGeneric.validationResponseData(apiUser.getRes(), dataType);
    }
}
