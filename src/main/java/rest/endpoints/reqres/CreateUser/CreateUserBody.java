package rest.endpoints.reqres.CreateUser;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUserBody {
    private String name;
    private String job;
}
