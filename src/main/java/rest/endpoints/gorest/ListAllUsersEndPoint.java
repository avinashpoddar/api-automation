package rest.endpoints.gorest;

import properties.GorestProperties;
import rest.template.HttpMethod;
import rest.template.IServiceEndPoint;
import rest.template.Param;
import rest.template.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class ListAllUsersEndPoint implements IServiceEndPoint {

    private String accessToken;
    private String format;

    public ListAllUsersEndPoint(String accessToken) {
        this.accessToken = accessToken;
        this.format = "json";
    }

    @Override
    public String url() {
        return GorestProperties.gorestHost + "/public-api/users";
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public List<Param> queryParameters() {
        return  null;
    }

    @Override
    public List<Param> pathParameters() {
        return null;
    }

    @Override
    public List<Param> headers() {
        ArrayList<Param> headers = new ArrayList<>();
        headers.add(new Param("Authorization",String.format("Bearer %s", accessToken)));
        return headers;
    }

    @Override
    public RequestBody requestBody() {
        return null;
    }
}
