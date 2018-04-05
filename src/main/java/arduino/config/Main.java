package arduino.config;

import java.util.Scanner;


public class Main {
    static String serialPort = "/dev/ttyUSB0";

    public static void main(String[] args) throws Exception {
        Arduino arduino = new Arduino(serialPort);
        Scanner scn = new Scanner(System.in);
        while (true) {
            String str = scn.nextLine();
            arduino.writeDataArduino(str);
            arduino.readDataArduino();
            if (str.equals("exit")) {
                arduino.closeArduino();
                break;
            }
        }
    }


}