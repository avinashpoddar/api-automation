package tests.reqresin;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.endpoints.reqres.GetUserEndPoint;
import rest.endpoints.reqres.GetUserResponse;
import rest.template.RequestHandler;

import static io.restassured.RestAssured.given;

public class UsersTests {

    @Test
    public void shouldGetUserWithId() {
        GetUserEndPoint userEndPoint = new GetUserEndPoint("2");

        Response response = new RequestHandler().processRequest(userEndPoint);

        GetUserResponse userResponse = response.as(GetUserResponse.class);
        userResponse.setHttpStatusCode(response.getStatusCode());

        Assert.assertEquals(userResponse.getHttpStatusCode(), 200, "Status code does not match");
        Assert.assertEquals(userResponse.getData().getEmail(), "janet.weaver@reqres.in", "EmailId does not match");
        Assert.assertEquals(userResponse.getData().getFirst_name(), "Janet", "FirstName does not match");
        Assert.assertEquals(userResponse.getData().getLast_name(), "Weaver", "LastName does not match");
    }
}
