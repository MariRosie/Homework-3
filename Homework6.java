import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework6 {

    @Test
    public void getRequest() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        Response response = RestAssured
                .given()
                .when()
                .get("BookStore/v1/Books")
                .then()
                .extract().response();
        int statusCode = response.getStatusCode();
        System.out.println("statuscode is:" + statusCode);
        System.out.println(response.getBody().asString());
        String firstAuthorName = response.jsonPath().getString("books[0].author");
        String firstPublisherName = response.jsonPath().getString("books[0].publisher");

        Assert.assertEquals(statusCode, 200, "Statuscode must be 200");
        Assert.assertEquals(firstAuthorName, "Richard E. Silverman", "First Authors is Richard E. Silverman");
        Assert.assertEquals(firstPublisherName, "O'Reilly Media", "First publisher is O'Reilly Media");

    }


    @Test
    public void postRequest() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        JSONObject requestbody = new JSONObject();
        requestbody.put("userName", "mrlk");
        requestbody.put("password", "nM12ka@jf");

        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(requestbody.toString())
                .when()
                .post("Account/v1/User")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        String responceBody = response.getBody().asString();
        Assert.assertEquals(statusCode, 201, "statuscode is incorrect");
        Assert.assertTrue(responceBody.contains("userID"), "userID isn't in Responcebody");


    }

    @Test
    public void postRequest1() {

        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        JSONObject requestbody = new JSONObject();
        requestbody.put("userName", "MR123");
        requestbody.put("password", "aaaa");

        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(requestbody.toString())
                .when()
                .post("Account/v1/User")
                .then()
                .extract().response();
        int statusCode = response.getStatusCode();
        String responsMessage = response.jsonPath().getString("message");
        String responceBody = response.getBody().asString();
        System.out.println(responceBody);
        Assert.assertEquals(statusCode, 400, "statuscode should be 400");
        Assert.assertEquals(responsMessage, "Passwords must have at least one non alphanumeric character, one digit ('0'-'9'), one uppercase ('A'-'Z'), one lowercase ('a'-'z'), one special character and Password must be eight characters or longer.", "message should be this");


    }


}
