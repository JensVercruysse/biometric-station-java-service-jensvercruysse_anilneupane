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
                
                pusher.send(dataFromArduino.getHeartbeat() + "");
                pusher.send(dataFromArduino.getTemperature() + "");
                pusher.send(dataFromArduino.getAccelero_x() + "");
                pusher.send(dataFromArduino.getAccelero_y() + "");
                pusher.send(dataFromArduino.getAccelero_z() + "");
                // Nu kan je hier de send() methode aanroepen op pusher met de correcte data
            }           
        });
    }
    }