package rest.endpoints.gorest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import rest.template.BaseResponse;
import java.util.ArrayList;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListAllUsersResponse extends BaseResponse {
    Meta _meta;
    ArrayList<Result> result = new ArrayList();

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Meta {
        private boolean success;
        private int code;
        private String message;
        private int totalCount;
        private int pageCount;
        private int currentPage;
        private int perPage;
        RateLimit rateLimit;

        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class RateLimit {
            private int limit;
            private int remaining;
            private int reset;
        }
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result {
        private String id;
        private String first_name;
        private String last_name;
        private String gender;
        private String dob;
        private String email;
        private String phone;
        private String website;
        private String address;
        private String status;
        Links _links;

        @Getter
        @Setter
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Links {
            Self self;
            Edit edit;
            Avatar avatar;

            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Self {
                private String href;
            }

            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Edit {
                private String href;
            }

            @Getter
            @Setter
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class Avatar {
                private String href;
            }
        }
    }
}