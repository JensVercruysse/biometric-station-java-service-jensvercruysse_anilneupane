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
public class BiometricDataPusher implements IMqttDataHandler {
    
    private MqttBiometricDataService biometricDataServiceHeartbeat;
    private MqttBiometricDataService biometricDataServiceTemperature;
    private MqttBiometricDataService biometricDataServiceAcceleroX;
    private MqttBiometricDataService biometricDataServiceAcceleroY;
    private MqttBiometricDataService biometricDataServiceAcceleroZ;

    public BiometricDataPusher() {
        biometricDataServiceHeartbeat = new MqttBiometricDataService();
        biometricDataServiceHeartbeat.setDataHandler(this);
        biometricDataServiceTemperature = new MqttBiometricDataService();
        biometricDataServiceTemperature.setDataHandler(this);
        biometricDataServiceAcceleroX = new MqttBiometricDataService();
        biometricDataServiceAcceleroX.setDataHandler(this);
        biometricDataServiceAcceleroY = new MqttBiometricDataService();
        biometricDataServiceAcceleroY.setDataHandler(this);
        biometricDataServiceAcceleroZ = new MqttBiometricDataService();
        biometricDataServiceAcceleroZ.setDataHandler(this);
    }
 
    public void send(String data){
        biometricDataServiceHeartbeat.sendData(data);
    }

    @Override
    public void dataArrived(String channel, String data) {
    }    
}