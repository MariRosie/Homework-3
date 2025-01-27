import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.LombokPoJo;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LombokTestHomework {
    //  1. დაწერეთ ტესტი მოცემული Get მეთოდისთვის, given when then
//    კონცეფციის მიხედვით, გამოიყენეთ DataProvider შემდეგი მონაცემებით
//    1. ISBN = 9781449331818
//    2. ISBN = 9781449337711
//    3. ISBN = 9781449365035
//    4. ISBN = 9781491904244
//    გადაამოწმეთ სტატუს კოდი იყოს 200;
//    გადაამოწმეთ რესფონსში დაბრუნებული ISBN შეესაბამებოდეს თქვენს მიერ გადაცემულს

    @DataProvider(name = "UserISBNs")
    public Object[][] createISBNData() {
        return new Object[][]{
                {"9781449331818"},
                {"9781449337711"},
                {"9781449365035"},
                {"9781491904244"}
        };
    }

    @Test(dataProvider = "UserISBNs")
    public void testGetISBN(String userISBN) {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";

        Response response = RestAssured
                .given()
                .queryParam("ISBN", userISBN)
                .header("accept", "application/json")
                .when()
                .get("/BookStore/v1/Book")
                .then()
                .extract()
                .response();


        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode, 200, "Status code should be 200");

        System.out.println(response.statusLine());
        String isbn = response.jsonPath().getString("isbn");
        Assert.assertEquals(isbn, userISBN, "ISBN in response should match the input");
    }

//შემდეგი ორი ტესტი გადაწერეთ ისე რომ გამოიყენოთ LOMBOK ის @Data ან
//@Builder ორივე ტესტისთვის უნდა დაგჭირდეთ ერთი დამატებითი კლასის გაკეთება.
//2. დაწერეთ ტესტი მოცემული POST მეთოდისთვის, given when then კონცეფციის მიხედვით
//მეთოდს გადაეცით საჭირო ჰედერები
//გადაეცით საჭირო body(გამოიყენეთ რაღაც ნებისმიერი username
//პაროლს აქვს შეზღუდვა რომ გამოიყენოთ ერთი uppercase ერთი lowercase სიმბოლო და ციფრი)
// გადაამოწმეთ რომ მეთოდმა დააბრუნოს 201 სტატუს კოდი
// გადაამოწმეთ რომ რესფონსში დაგიბრუნდათ userID

    @Test
    public void postRequest() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        LombokPoJo userDataBody = new LombokPoJo();
        userDataBody.setUserName("mrlk");
        userDataBody.setPassword("nM12ka@jf");

        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(userDataBody)
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
        LombokPoJo userDataBody = new LombokPoJo();
        userDataBody.setUserName("MR123");
        userDataBody.setPassword("aaaa");

        Response response = RestAssured
                .given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(userDataBody)
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





