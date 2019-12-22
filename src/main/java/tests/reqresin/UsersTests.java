package tests.reqresin;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.endpoints.reqres.CreateUser.CreateUserBody;
import rest.endpoints.reqres.CreateUser.CreateUserBodyBuilder;
import rest.endpoints.reqres.CreateUser.CreateUserEndPoint;
import rest.endpoints.reqres.CreateUser.CreateUserResponse;
import rest.endpoints.reqres.GetUser.GetUserEndPoint;
import rest.endpoints.reqres.GetUser.GetUserResponse;
import rest.template.RequestHandler;


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

    @Test
    public void shouldCreateANewUser() {

        String name = "Avinash11";
        String job = "SDET11";

        CreateUserBody createUserBody = new CreateUserBodyBuilder()
                .withName(name)
                .withJob(job)
                .build();

        CreateUserEndPoint endPoint = new CreateUserEndPoint(createUserBody);

        Response response = new RequestHandler().processRequest(endPoint);

        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setHttpStatusCode(response.statusCode());

        Assert.assertEquals(createUserResponse.httpStatusCode,201);
    }
}