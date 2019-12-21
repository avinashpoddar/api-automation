package entities.reqres.in;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entities.base.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse extends BaseResponse {
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

