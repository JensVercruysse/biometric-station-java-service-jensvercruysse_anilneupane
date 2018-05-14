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
                System.out.println("Heartbeat data has been sent to mqttt.");
                pusher.sendTemperature(dataFromArduino.getTemperature() + "");
                System.out.println("Temperature data has been sent to mqttt.");
                pusher.sendAcc_X_Value(dataFromArduino.getAccelero_x() + "");
                System.out.println("Accelero_X data has been sent to mqttt.");
                pusher.sendAcc_Y_Value(dataFromArduino.getAccelero_y() + "");
                System.out.println("Accelero_Y data has been sent to mqttt.");
                pusher.sendAcc_Z_Value(dataFromArduino.getAccelero_z() + "");
                System.out.println("Accelero_Z data has been sent to mqttt.");
            }
        });
    }
}
