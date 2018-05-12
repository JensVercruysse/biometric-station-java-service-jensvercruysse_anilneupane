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
    private MqttBiometricDataService biometricDataServiceAccelero_X;
    private MqttBiometricDataService biometricDataServiceAccelero_Y;
    private MqttBiometricDataService biometricDataServiceAccelero_Z;

    public BiometricDataPusher() {
        biometricDataServiceHeartbeat = new MqttBiometricDataService();
        biometricDataServiceHeartbeat.setDataHandler(this);
        biometricDataServiceTemperature = new MqttBiometricDataService();
        biometricDataServiceTemperature.setDataHandler(this);
        biometricDataServiceAccelero_X = new MqttBiometricDataService();
        biometricDataServiceAccelero_X.setDataHandler(this);
        biometricDataServiceAccelero_Y = new MqttBiometricDataService();
        biometricDataServiceAccelero_Y.setDataHandler(this);
        biometricDataServiceAccelero_Z = new MqttBiometricDataService();
        biometricDataServiceAccelero_Z.setDataHandler(this);
    }
 
    public void sendHeartbeat(String data){
        biometricDataServiceHeartbeat.sendData(data);
    }
    
    public void sendTemperature(String data){
        biometricDataServiceTemperature.sendData(data);
    }
    
    public void sendAcc_X_Value(String data){
        biometricDataServiceAccelero_X.sendData(data);
    }
        
    public void sendAcc_Y_Value(String data){
        biometricDataServiceAccelero_Y.sendData(data);
    }
        
    public void sendAcc_Z_Value(String data){
        biometricDataServiceAccelero_Z.sendData(data);
    }

    @Override
    public void dataArrived(String channel, String data) {
    }    
}