/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectwerkserialport;


import be.vives.oop.mqtt.chatservice.IMqttMessageHandler;
import be.vives.oop.mqtt.chatservice.MqttChatService;

/**
 *
 * @author jensv
 */
public class ProjectwerkSerialDataPusher implements IMqttMessageHandler{

    private MqttChatService chatService;
    
    private final int BAUD_RATE = 115200;
    private final int COM_PORT_INDEX = 0;
    
    ProjectwerkSerialLineReceiver receiver = new ProjectwerkSerialLineReceiver(COM_PORT_INDEX, BAUD_RATE, false);
            
    private void receive(){
            receiver.setLineListener(new ProjectwerkSerialPortLineListener() {
            @Override
            public void serialLineEvent(ProjectwerkSerialData data) {
            System.out.println("Received data from the serial port: " + data.getDataAsString());  
            }
        });
    }

    public ProjectwerkSerialDataPusher() {
    chatService = new MqttChatService();
    chatService.setMessageHandler(this);
    }
 
    private void send(){
        chatService.sendMessage("Hello World");
    }

    @Override
    public void messageArrived(String channel, String message) {
    System.out.println("Received chat messages (on channel = " + channel + "): " + message);
    }    
}
