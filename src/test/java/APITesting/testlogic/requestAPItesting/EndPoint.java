package APITesting.testlogic.requestAPItesting;

public class EndPoint {

    // domain url
    public static final String BASE_URL = "https://dummyapi.io/data/v1/";

    // End Point User Management
    // get list users >> GET: /user
    public static final String GET_LIST_USERS = BASE_URL + "user";

    // get user by id >> GET: /user/:id
    public static final String GET_USER_BY_ID = BASE_URL + "user/";

    // create user >> POST: /user/create
    public static final String CREATE_USER = BASE_URL + "user/create";

    // update user by id >> PUT: /user/:id
    public static final String UPDATE_USER = BASE_URL + "user";

    // delete user by id >> DELETE: /user/:id
    public static final String DELETE_USER = BASE_URL + "user/";
}
