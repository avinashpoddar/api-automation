package rest.template;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Reporter;
import static io.restassured.RestAssured.given;

public class RequestHandler {

    public Response processRequest(IServiceEndPoint iServiceEndPoint) {
        RestAssured.registerParser("text/html", Parser.JSON);
        RestAssured.registerParser("application/grpc", Parser.JSON);
        RestAssured.registerParser("text/plain", Parser.JSON);

        String endPointName = iServiceEndPoint.getClass().getSimpleName().replaceAll("EndPoint", "");
        String url = iServiceEndPoint.url();
        HttpMethod httpMethod = iServiceEndPoint.httpMethod();
        RequestBody requestBody = iServiceEndPoint.requestBody();

        logRequestDetails(iServiceEndPoint, endPointName, url, httpMethod, requestBody);

        RequestSpecification requestSpecification = formRequestSpecification(iServiceEndPoint);

        Response response = getAPIResponseBasedOnHttpMethod(url, httpMethod, requestSpecification);

        logResponseDetails(endPointName, response);

        return response;
    }

    private RequestSpecification formRequestSpecification(IServiceEndPoint iServiceEndPoint) {
        RestAssuredConfig config = RestAssured.config()
                .encoderConfig(new EncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));

        RequestSpecification request = given().config(config);

        if(iServiceEndPoint.headers()!=null){
            iServiceEndPoint.headers().forEach(header->request.header(header.getKey(),header.getValue()));
        }

        if(iServiceEndPoint.pathParameters()!=null) {
            iServiceEndPoint.pathParameters().forEach(p -> request.pathParam(p.getKey(), p.getValue()));
        }

        if(iServiceEndPoint.queryParameters()!=null){
            iServiceEndPoint.queryParameters().forEach(q->request.queryParam(q.getKey(),q.getValue()));
        }

        return  request;
    }

    private Response getAPIResponseBasedOnHttpMethod(String url, HttpMethod httpMethod, RequestSpecification requestSpecification) {
        Response response = null;
        switch (httpMethod) {
            case GET:
                response = requestSpecification.get(url);
                break;

            case POST:
                response = requestSpecification.post(url);
                break;

            case PUT:
                response = requestSpecification.put(url);
                break;
            case PATCH:
                response = requestSpecification.patch(url);
                break;

            case DELETE:
                response = requestSpecification.delete(url);
                break;
        }
        return response;
    }

    private void logRequestDetails(IServiceEndPoint iServiceEndPoint, String endPointName, String url, HttpMethod httpMethod, RequestBody body) {
        Reporter.log(String.format("\n" + endPointName + " URL --- %s %s", httpMethod.toString(), url), true);

        if (iServiceEndPoint.headers() != null) {
            for (Param p : iServiceEndPoint.headers()) {
                Reporter.log(String.format(endPointName + " Header --- [%s : %s]", p.getKey(), p.getValue()), true);
            }
        }

        if (body != null) {
            Reporter.log(String.format(endPointName + " Request --- %s", body.getBodyString()), true);
        }
        //log curl
    }

    private  void logResponseDetails(String endPointName, Response response){
        Reporter.log(String.format(endPointName+" Response --- %s",response.asString()),true);
    }
}
