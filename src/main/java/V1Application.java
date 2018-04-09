import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class V1Application {

    public static void main(String[] args) {
        SpringApplication.run(V1Application.class, args);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("AppConfig.xml");
        /*ArduinoListener arduinoListener = (ArduinoListener) applicationContext.getBean("ardList");
        arduinoListener.hello();*/
    }
}
