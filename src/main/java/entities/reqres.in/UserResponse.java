package entities.reqres.in;
import entities.base.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class UserResponse extends BaseResponse {

    Data data;

    public  UserResponse(){}

    // Getter Methods
    public Data getData() {
        return data;
    }

    public static class Data {
        private float id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;

        // Getter Methods

        public float getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        public String getFirst_name() {
            return first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public String getAvatar() {
            return avatar;
        }
    }

}

