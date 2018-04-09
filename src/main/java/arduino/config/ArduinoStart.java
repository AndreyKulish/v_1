package arduino.config;

import jssc.SerialPort;

public class ArduinoStart {

    private SerialPort serialPort;
    private String portName;

    public ArduinoStart(){
    }

    public ArduinoStart(String portName) {
        this.portName = portName;
    }

    public SerialPort getSerialPort() {
        return serialPort;
    }

    public void initArduino() throws Exception {
        serialPort = new SerialPort(portName);
        System.out.println("Port opened: " + serialPort.openPort());
        System.out.println("Params setted: " + serialPort.setParams(9600, 8, 1, 0));
        serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN |
                SerialPort.FLOWCONTROL_RTSCTS_OUT);
        serialPort.addEventListener(new ArduinoPortReader(serialPort), SerialPort.MASK_RXCHAR);
    }
}
