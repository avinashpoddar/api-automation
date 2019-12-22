package rest.template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IServiceEndPoint {
    String url();

    HttpMethod httpMethod();

    List<Param> queryParameters();

    List<Param> pathParameters();

    List<Param> headers();

    RequestBody requestBody();
}
