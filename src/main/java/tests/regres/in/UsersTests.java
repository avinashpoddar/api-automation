package regres.in;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import reqres.in.UserResponse;

import static io.restassured.RestAssured.given;

public class UsersTests {

    @Test
    public void shouldGetUserWithId() {

        String host = "https://reqres.in";
        String uri = "/api/users/2";

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(host + uri);

        UserResponse userResponse = response.as(UserResponse.class);
        userResponse.setHttpStatusCode(response.getStatusCode());

        Assert.assertEquals(userResponse.getHttpStatusCode(), 200, "Status code does not match");
        Assert.assertEquals(userResponse.getData().getEmail(), "janet.weaver@reqres.in", "EmailId does not match");
        Assert.assertEquals(userResponse.getData().getFirst_name(), "Janet", "FirstName does not match");
        Assert.assertEquals(userResponse.getData().getLast_name(), "Weaver", "LastName does not match");
    }
}
