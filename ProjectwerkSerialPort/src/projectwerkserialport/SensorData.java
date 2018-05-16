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
public class SensorData {

    private int heartbeat = 0;
    private double temperature = 0;
    private double accelero_x = 0;
    private double accelero_y = 0;
    private double accelero_z = 0;

    public SensorData(int heartbeat, double temperature, double accelero_x, double accelero_y, double accelero_z) {
        this.heartbeat = heartbeat;
        this.temperature = temperature;
        this.accelero_x = accelero_x;
        this.accelero_y = accelero_y;
        this.accelero_z = accelero_z;
    }

    public int getHeartbeat() {
        return heartbeat;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getAccelero_x() {
        return accelero_x;
    }

    public double getAccelero_y() {
        return accelero_y;
    }

    public double getAccelero_z() {
        return accelero_z;
    }

    @Override
    public String toString() {
        return "[Heartbeat: " + heartbeat + " | Temperature: " + temperature + " | Accelerator: " + accelero_x + " | " + accelero_y + " | " + accelero_z + " ]";
    }
}
