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

public class APIUserStep {
	APIUserTest apiUser;
	UserPreview dataTestCreateUser;
	UserPreview updatedUserData;
	String currentUserID;
	private Response currentRes;
	private String currentEndpoint;

	public APIUserStep() {
		apiUser = new APIUserTest();
	}

	/********************* Umum ******************************/

	@Given("prepare url for {string}")
	public void prepareUrlFor(String endpoint) {
		// prepare end point API
		System.out.println(endpoint);
		SetUpEndPoint.prepareEndPoint(endpoint); // prepare end point

	}

	@Then("validation status code api user is equals {int}")
	public void validationStatusCodeApiUserIsEquals(int statusCode) throws ParseException {
		APITestProcessGeneric.validationStatusCode(apiUser.getRes(), statusCode);
	}

	@Then("validation response body error with message {string}")
	public void validation_response_body_error_with_message(String error) {
		apiUser.checkErrorInResponseBody(error);
	}

	/********************* Create ******************************/

	@When("hit api post create new user with Data User {string}")
	public void hit_api_post_create_new_user_with_data_user(String dataUserIndex) {
		switch (dataUserIndex) {
		case "1":
			dataTestCreateUser = APITestProcessGeneric.prepareDataUserTestPost1();
			break;
		case "2":
			dataTestCreateUser = APITestProcessGeneric.prepareDataUserTestPost2();
			break;
		case "3":
			dataTestCreateUser = APITestProcessGeneric.prepareDataUserTestPost3();
			break;
		case "4":
			dataTestCreateUser = APITestProcessGeneric.prepareDataUserTestPost4();
			break;
		case "5":
			dataTestCreateUser = APITestProcessGeneric.prepareDataUserTestPost5();
			break;
		default:
			throw new IllegalArgumentException("Invalid data user index: " + dataUserIndex);
		}
		System.out.println(currentEndpoint);

		currentRes = apiUser.hitAPIPostNewUser(APITesting.testlogic.requestAPItesting.EndPoint.CREATE_USER,
				dataTestCreateUser);
	}

	
	@Then("validation response body post create new user")
	public void validation_response_body_post_create_new_user() throws ParseException {
		apiUser.checkResponseBodyCreateUser(dataTestCreateUser);
		
	}

	/********************* Update ******************************/

	@Given("hit api post create new user for create new user")
	public void hitApiPostCreateNewUserForCreateNewUser() {
		dataTestCreateUser = APITestProcessGeneric.prepareDataUserTestPostForUpdate();
		currentUserID = apiUser.hitAPIPostNewUserForUpdate(APITesting.testlogic.requestAPItesting.EndPoint.CREATE_USER,
				dataTestCreateUser);
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

	@Then("validation response body update user")
	public void validationResponseBodyUpdateUser() throws ParseException {
		apiUser.checkResponseBodyUpdateProfileUser(updatedUserData, currentUserID);

	}

/********************* Get ******************************/

@When("hit api get list users {string}")
public void hit_api_get_list_users(String appid) {

	if (appid.equalsIgnoreCase("Missing")) {
		apiUser.hitAPIGetListUsersMissingAppId();
		;
	} else if (appid.equalsIgnoreCase("Invalid")) {
		apiUser.hitAPIGetListUsersInvalidAppId();
	}
}

@When("hit api get users by user id {string}")
public void hit_api_get_users_by_user_id(String idUser) {
	if (idUser.equalsIgnoreCase("Valid")) {
		apiUser.hitAPIGetProfileUser(currentUserID);
	} else {
		apiUser.hitAPIGetProfileUser(idUser);
	}
}

@Then("validation response body get user by id")
public void validation_response_body_get_user_by_id() {
	apiUser.checkResponseBodyProfileUser();
}

/********************* Delete ******************************/

@When("hit api delete user {string} and {string}")
public void hit_api_delete_user_and(String appid, String userid) {

	if (appid.equalsIgnoreCase("Missing") && userid.equalsIgnoreCase("Valid")) {
		apiUser.hitAPIDeleteUserByIdMissingAppid(currentUserID);
	} else if (appid.equalsIgnoreCase("Invalid") && userid.equalsIgnoreCase("Valid")) {
		apiUser.hitAPIDeleteUserByIdInvalidAppId(currentUserID);
	} else if (appid.equalsIgnoreCase("Valid") && userid.equalsIgnoreCase("NotRegistered")) {
		apiUser.hitAPIDeleteUserById("60d0fe4f5321236168a109cb");
	} else if (appid.equalsIgnoreCase("Valid") && userid.equalsIgnoreCase("Invalid")) {
		apiUser.hitAPIDeleteUserById("1234567abcd");
	} else if (appid.equalsIgnoreCase("Valid") && userid.equalsIgnoreCase("Valid")) {
		apiUser.hitAPIDeleteUserById(currentUserID);
	}
}

@Then("validation response body delete user by id")
public void validation_response_body_delete_user_by_id() {
	apiUser.checkResponseBodyDeleteUser(currentUserID);
}

}
