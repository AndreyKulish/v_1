package main;

import arduino.config.Arduino;
import helper.Property;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;
@ComponentScan(basePackages = {})
@SpringBootApplication
public class V1Application {

    public static void main(String[] args) throws Exception {
        Property property = new Property();
        property.initProperties();
        SpringApplication.run(V1Application.class, args);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("AppConfig.xml");
        Arduino arduino = (Arduino) applicationContext.getBean("arduino");
        arduino.startArduino(Property.getProperty("port"));
        Scanner scn = new Scanner(System.in);
        while (true) {
            String dataToArduino = scn.nextLine();
            arduino.writeDataArduino(dataToArduino);
            //Thread.sleep(1000);
            /*String data = arduino.readDataArduino();
            System.out.println(data);*/
        }
    }
}
