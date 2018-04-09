package helper;

import java.io.FileInputStream;
import java.util.Properties;

public class Property {
    private static String propertyFile= "hitek.properties";
    Properties properties = new Properties();

    public Property(){
    }

    public void initProperties() throws Exception{
        properties.load(new FileInputStream(propertyFile));
    }

    public String getProperty(String propertyName){
        return properties.getProperty(propertyName);
    }

    public void setProperty(String propertyName, String propertyValue) {
        properties.setProperty(propertyName, propertyValue);
    }
}
