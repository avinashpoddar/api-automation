package rest.template;

import org.testng.Assert;

public class BaseResponse {

    public int httpStatusCode;

    public BaseResponse() {
    }

    public void assertHttpStatusToBe(int httpStatusCode) {
        Assert.assertEquals(this.getHttpStatusCode(), httpStatusCode, "HTTP Status code is not matching");
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }
}
