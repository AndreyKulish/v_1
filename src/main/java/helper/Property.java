package helper;

import org.apache.logging.log4j.util.PropertiesUtil;

import java.io.FileInputStream;
import java.util.Properties;

public class Property {
    private static String propertyFile= "hitek.properties";
    private static Properties properties = new Properties();

    public Property(){
    }

    public void initProperties() throws Exception{
        String basePath = PropertiesUtil.class.getResource("/").getPath();
        properties.load(new FileInputStream(basePath + propertyFile));
    }

    public static String getProperty(String propertyName){
        return properties.getProperty(propertyName);
    }

    public static void setProperty(String propertyName, String propertyValue) {
        properties.setProperty(propertyName, propertyValue);
    }
}
