package tests.gorest;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import rest.endpoints.gorest.ListAllUsersEndPoint;
import rest.endpoints.gorest.ListAllUsersResponse;
import rest.template.RequestHandler;

public class ListAllUsersTests {

    @Test
    public  void shouldBeAbleToRetrieveListOfUsers(){
        ListAllUsersEndPoint endPoint = new ListAllUsersEndPoint("r5U23eN5H3Yh7vfQQ7rfYmXgFx82sQHypegw");
        Response response = new RequestHandler().processRequest(endPoint);
        ListAllUsersResponse usersResponse = response.as(ListAllUsersResponse.class);
        usersResponse.setHttpStatusCode(response.getStatusCode());

        //Verification
        Assert.assertEquals(200, usersResponse.httpStatusCode);
        Assert.assertEquals(false, usersResponse.get_meta().isSuccess());
    }
}
