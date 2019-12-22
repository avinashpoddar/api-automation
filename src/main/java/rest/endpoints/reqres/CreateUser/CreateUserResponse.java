package rest.endpoints.reqres.CreateUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import rest.template.BaseResponse;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserResponse extends BaseResponse {
    private String name;
    private String job;
    private int id;
    private String createdAt;
}