package APITesting.helper;

import APITesting.testlogic.requestAPItesting.EndPoint;

public class SetUpEndPoint {
    private static SetUpEndPoint helperClass;
    private String endPoint;

    public static void setUpApi() {
        if (helperClass == null) {
            helperClass = new SetUpEndPoint();
        }
    }

    public static String getEndPoint() {
        return helperClass.endPoint;
    }

    public static void prepareEndPoint(String endPoint) {
        System.out.println("Setting up endpoint: " + endPoint);
        endPoint = "";

        switch (endPoint) {
            case "GET_LIST_USERS":
                endPoint = EndPoint.GET_LIST_USERS;
                break;
            case "GET_USER_BY_ID":
                endPoint = EndPoint.GET_USER_BY_ID;
                break;
            case "CREATE_USER":
                endPoint = EndPoint.CREATE_USER;
                break;
            case "UPDATE_USER":
                endPoint = EndPoint.UPDATE_USER;
                break;
            case "DELETE_USER":
                endPoint = EndPoint.DELETE_USER;
                break;
            default:
                System.out.println("Please Input Right URL : ");
        }

        if (!endPoint.isBlank()) {
            System.out.println("End Point is : " + endPoint);
        }
    }

}
