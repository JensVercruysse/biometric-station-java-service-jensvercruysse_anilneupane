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
public class ProjectwerkSerialDataPusher implements IMqttMessageHandler {

    private MqttChatService chatService;

    public ProjectwerkSerialDataPusher() {
    chatService = new MqttChatService();
    chatService.setMessageHandler(this);
    send();
    }
 
    private void send(){
        chatService.sendMessage("Hello World");
    }

    @Override
    public void messageArrived(String channel, String message) {
    System.out.println("Received chat messages (on channel = " + channel + "): " + message);
    }    
}
