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

        ProjectwerkSerialLineReceiver receiver = new ProjectwerkSerialLineReceiver(COM_PORT_INDEX, BAUD_RATE, false);
        
        receiver.setLineListener(new ProjectwerkSerialPortLineListener() {
            @Override
            public void serialLineEvent(ProjectwerkSerialData data) {
                System.out.println("Received data from the serial port: " + data.getDataAsString());
            }
        });
    }
}
