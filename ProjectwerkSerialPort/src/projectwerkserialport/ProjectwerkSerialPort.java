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
public class ProjectwerkSerialPort {
    private final static int BAUD_RATE = 115200;
    private final static int COM_PORT_INDEX = 0;

    public static void main(String[] args) {

        // Best deze classes ook hernoemen !! Beetje onduidelijk zo
        ProjectwerkSerialLineReceiver receiver = new ProjectwerkSerialLineReceiver(COM_PORT_INDEX, BAUD_RATE, false);
        ProjectwerkDataParser parser = new ProjectwerkDataParser();
        BiometricDataPusher pusher = new BiometricDataPusher();
            

        receiver.setLineListener(new ProjectwerkSerialPortLineListener() {
            @Override
            public void serialLineEvent(SerialData data) {
                String dataString = data.getDataAsString();
                SensorData dataFromArduino = parser.parse(dataString);               
                System.out.println("Received data from the serial port: " + dataFromArduino); 
                
                // Nu kan je hier de send() methode aanroepen op pusher met de correcte data
            }           
        });
    }
    }

