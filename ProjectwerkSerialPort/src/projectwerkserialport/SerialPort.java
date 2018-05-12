/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectwerkserialport;

/**
 *
 * @author jensv
 */
public class SerialPort {

    private final static int BAUD_RATE = 115200;
    private final static int COM_PORT_INDEX = 0;

    public static void main(String[] args) {

        SerialLineReceiver receiver = new SerialLineReceiver(COM_PORT_INDEX, BAUD_RATE, false);
        DataParser parser = new DataParser();
        BiometricDataPusher pusher = new BiometricDataPusher();

        receiver.setLineListener(new SerialPortLineListener() {
            @Override
            public void serialLineEvent(SerialData data) {
                String dataString = data.getDataAsString();
                SensorData dataFromArduino = parser.parse(dataString);
                System.out.println("Received data from the serial port: " + dataFromArduino);

                pusher.sendHeartbeat(dataFromArduino.getHeartbeat() + "");
                pusher.sendTemperature(dataFromArduino.getTemperature() + "");
                pusher.sendAcc_X_Value(dataFromArduino.getAccelero_x() + "");
                pusher.sendAcc_Y_Value(dataFromArduino.getAccelero_y() + "");
                pusher.sendAcc_Z_Value(dataFromArduino.getAccelero_z() + "");
                // Nu kan je hier de send() methode aanroepen op pusher met de correcte data
            }
        });
    }
}
