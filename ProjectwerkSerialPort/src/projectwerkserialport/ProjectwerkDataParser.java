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
public class ProjectwerkDataParser {
    
    private final static String OPENING_FLAG = "[";
    private final static String SEPARATOR = "|";
    private final static String CLOSING_VLAG = "]";


    public SensorData parse(String dataString){
        if (!isValidString(dataString)){
            return null;
        }
        int heartbeat = 0;
        double temperature = 0;
        int accelero_x = 0;
        int accelero_y = 0;
        int accelero_z = 0;
              
        return new SensorData(heartbeat, temperature, accelero_x, accelero_y, accelero_z);
    }
    
    private boolean isValidString(String dataString) {

        return (dataString.contains(OPENING_FLAG) && dataString.contains(SEPARATOR) && dataString.contains(CLOSING_VLAG));
    }
}

