package arduino.config;

public class Arduino {
    private String dataFromArduino;
    private String portName;
    private ArduinoPortReader arduinoPortReader;
    private ArduinoStart arduinoStart;

    public Arduino(){
    }

    public Arduino(String portName) throws Exception {
        this.portName = portName;
        arduinoStart = new ArduinoStart(portName);
        arduinoStart.initArduino();
        arduinoPortReader = new ArduinoPortReader(arduinoStart.getSerialPort());
    }

    public void writeDataArduino(String str) throws Exception {
        arduinoStart.getSerialPort().writeBytes(str.getBytes());
    }

    public void readDataArduino() throws Exception {
        dataFromArduino = arduinoPortReader.getData();
        System.out.println(dataFromArduino);
        arduinoPortReader.setData("");
    }

    public void closeArduino() throws Exception {
        arduinoStart.getSerialPort().closePort();
    }
}
