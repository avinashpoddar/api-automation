package properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private Properties properties;

    public PropertiesReader() {
        properties = new Properties();
        try{
            String propertiesFilePath = "hosts.properties";
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFilePath);
            properties.load(inputStream);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public Properties getProperties(){
        return properties;
    }

    public String getReqresInHost(){
        return properties.getProperty("reqres_in_host_url");
    }


}