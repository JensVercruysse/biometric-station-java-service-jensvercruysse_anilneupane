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
    private int accelero_x = 0;
    private int accelero_y = 0;
    private int accelero_z = 0;
    
    public SensorData(int heartbeat, double temperature, int accelero_x, int accelero_y, int accelero_z) {
        this.heartbeat = heartbeat;
        this.temperature = temperature;
        this.accelero_x = accelero_x;
        this.accelero_y = accelero_y;
        this.accelero_z = accelero_z;
    }
    public int heartbeat(){
        return heartbeat;
    }
        public double temperature(){
        return temperature;
    }
        public int accelero_x(){
        return accelero_x;
    }
         public int accelero_y(){
        return accelero_y;
    }
        public int accelero_z(){
        return accelero_z;
    }
}