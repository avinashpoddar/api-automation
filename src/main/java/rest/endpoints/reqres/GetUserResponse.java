package rest.endpoints.reqres;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import rest.template.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUserResponse extends BaseResponse {
    private Data data;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private float id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;
    }
}