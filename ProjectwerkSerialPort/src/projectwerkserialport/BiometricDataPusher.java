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
<<<<<<< HEAD
    
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
=======

    // Ga je alle data op 1 channel versturen?
    // Zoja, ok ook goed maar dan moet je aan de javafx kant parsen
    // Zonee, dan heb je meerdere services nodig
    private MqttBiometricDataService biometricDataService;

    public BiometricDataPusher() {
        biometricDataService = new MqttBiometricDataService();
        biometricDataService.setDataHandler(this);

        // Versturen ga je niet hier doen, maar enkel wanneer je data ontvangt op
        // de seriele poort
        //send();
    }
 
    // Je hebt hier data van buiten de class nodig, met andere woorden je moet een
    // object van de class SensorData als argument aan de methode toevoegen.
    // Dan moet je de methode ook public maken want anders kan je ze niet buiten deze
    // class gebruiken
    // Wel mooi dat je aparte class voor dit maakt !!!!
    public void send(SensorData data){
        biometricDataService.sendData(data.getHeartbeat() + "");
>>>>>>> 31bfbd8c47561e18dd8c7c62b5023cdb01640509
    }s

    @Override

        // Deze mag je in principe leeg laten want je moet geen data ontvangen via mqtt
        // met deze app
        //System.out.println("Received data (on channel = " + channel + "): " + data);
    }    
}
>>>>>>> 31bfbd8c47561e18dd8c7c62b5023cdb01640509
