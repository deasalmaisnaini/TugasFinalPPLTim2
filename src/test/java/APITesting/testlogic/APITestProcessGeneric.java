package APITesting.testlogic;

import APITesting.model.Location;
import APITesting.model.UserPreview;
import APITesting.model.UserProfile;
import APITesting.helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.File;

public class APITestProcessGeneric {
    /* check response data in application JSONShcema */
    public static void validationResponseData(Response currentRes, String data) {
        System.out.println("check response data : " + data);
        File fileUsersJson = getJSONSchemaFile(data);
        currentRes.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(fileUsersJson));
    }

    private static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/resources/JSONSchemaData/" + JSONFile);
    }

    /* check status code response same with status code expected */
    public static void validationStatusCode(Response currentRes, int expectedStatusCode) {
        System.out.println("check status code : " + expectedStatusCode);
        Assert.assertEquals(currentRes.getStatusCode(), expectedStatusCode);
    }

    public static UserPreview prepareDataUserTestPost() {
        UserPreview dataUser = new UserPreview();
       
        // prepare data test user
        // information user
        String title = "miss";
        String firstName = "Hong Joshua";
        String lastName = "Joshushi";
        String gender = "male";
        String email = Utility.generateRandomEmail(); // generate email
       

        dataUser.setTitle(title);
        dataUser.setFirstName(firstName);
        dataUser.setLastName(lastName);
        dataUser.setGender(gender);
        dataUser.setEmail(email);

        return dataUser;
    }
  


    public static UserPreview prepareDataUserTestUpdate(String fieldToUpdate, String newValue) {
        UserPreview dataUser = new UserPreview();
        

        // prepare data test user
        // information user
        String title = "miss";
        String firstName = "Hong Joshua";
        String lastName = "Joshushi";
        String gender = "male";
       
        // Set initial values
        dataUser.setTitle(title);
        dataUser.setFirstName(firstName);
        dataUser.setLastName(lastName);
        dataUser.setGender(gender);


     // Update specific field
        switch (fieldToUpdate) {
            case "title":
                dataUser.setTitle(newValue);
                break;
            case "firstName":
                dataUser.setFirstName(newValue);
                break;
            case "lastName":
                dataUser.setLastName(newValue);
                break;
            case "registerDate":
               dataUser.setRegisterDate(newValue);
                break;
            default:
               dataUser.setRegisterDate(newValue);
                throw new IllegalArgumentException("Field " + fieldToUpdate + " is not supported.");
        }

        return dataUser;
    }

}
