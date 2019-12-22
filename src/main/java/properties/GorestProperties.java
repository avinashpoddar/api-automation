package properties;

public class GorestProperties  {
    public  static  final PropertiesReader propertiesReader = new PropertiesReader();
    public static final String gorestHost = propertiesReader.getGorestCoInHost();
}
