/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectwerkserialport;

import mqttbiometricdataservice.IMqttDataHandler;
import mqttbiometricdataservice.MqttBiometricDataService;






/**
 *
 * @author jensv
 */
public class ProjectwerkSerialDataPusher implements IMqttDataHandler {

    private MqttBiometricDataService biometricDataService;

    public ProjectwerkSerialDataPusher() {
    biometricDataService = new MqttBiometricDataService();
    biometricDataService.setDataHandler(this);
    send();
    }
 
    private void send(){
        biometricDataService.sendData("Hello World");
    }

    @Override
    public void dataArrived(String channel, String message) {
    System.out.println("Received data (on channel = " + channel + "): " + message);
    }    
}
