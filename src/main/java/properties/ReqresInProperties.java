package properties;

public class ReqresInProperties {
    private static final PropertiesReader propertiesReader = new PropertiesReader();
    private static final String regresInHost = propertiesReader.getReqresInHost();

    public static final String getSingleUserDetails = String.format("%s/api/users", regresInHost);
    public static final String createUser = String.format("%s/api/users", regresInHost);
}
