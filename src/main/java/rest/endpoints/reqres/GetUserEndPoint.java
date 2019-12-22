package rest.endpoints.reqres;

import io.restassured.http.ContentType;
import properties.ReqresInProperties;
import rest.template.HttpMethod;
import rest.template.IServiceEndPoint;
import rest.template.Param;
import rest.template.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class GetUserEndPoint implements IServiceEndPoint {
private  String userId;

    public GetUserEndPoint(String userId) {
        this.userId = userId;
    }

    @Override
    public String url() {
        return ReqresInProperties.getSingleUserDetails + "/{userId}";
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public List<Param> queryParameters() {
        return null;
    }

    @Override
    public List<Param> pathParameters() {
        ArrayList<Param> pathParams = new ArrayList<>();
        pathParams.add(new Param("userId", userId ));
        return pathParams;
    }

    @Override
    public List<Param> headers() {
        ArrayList<Param> headers = new ArrayList<>();
        headers.add(new Param("Content-Type", ContentType.JSON.toString()));
        return headers;
    }

    @Override
    public RequestBody requestBody() {
        return null;
    }
}
