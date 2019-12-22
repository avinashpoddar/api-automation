package rest.endpoints.reqres.CreateUser;

import properties.ReqresInProperties;
import rest.template.HttpMethod;
import rest.template.IServiceEndPoint;
import rest.template.Param;
import rest.template.RequestBody;

import java.util.List;

public class CreateUserEndPoint implements IServiceEndPoint {

    CreateUserBody createUserBody;

    public CreateUserEndPoint(CreateUserBody createUserBody) {
        this.createUserBody = createUserBody;
    }

    @Override
    public String url() {
        return ReqresInProperties.createUser;
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.POST;
    }

    @Override
    public List<Param> queryParameters() {
        return null;
    }

    @Override
    public List<Param> pathParameters() {
        return null;
    }

    @Override
    public List<Param> headers() {
        return null;
    }

    @Override
    public RequestBody requestBody() {
        return new RequestBody(CreateUserBody.class, createUserBody);
    }
}
