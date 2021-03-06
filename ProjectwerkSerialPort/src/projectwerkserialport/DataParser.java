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
public class DataParser {

    private final static String OPENING_FLAG = "[";
    private final static String SEPARATOR_1 = "|";
    private final static String SEPARATOR_2 = "#";
    private final static String SEPARATOR_3 = "$";
    private final static String SEPARATOR_4 = "€";
    private final static String CLOSING_FLAG = "]";

    public SensorData parse(String dataString) {
        if (!isValidString(dataString)) {
            return null;
        }
        
        try {
            int heartbeat = Integer.parseInt(dataString.substring(dataString.indexOf(OPENING_FLAG) + 1, dataString.indexOf(SEPARATOR_1)));
            double temperature = Double.parseDouble(dataString.substring(dataString.indexOf(SEPARATOR_1) + 1, dataString.indexOf(SEPARATOR_2)));
            double accelero_x = Double.parseDouble(dataString.substring(dataString.indexOf(SEPARATOR_2) + 1, dataString.indexOf(SEPARATOR_3)));
            double accelero_y = Double.parseDouble(dataString.substring(dataString.indexOf(SEPARATOR_3) + 1, dataString.indexOf(SEPARATOR_4)));
            double accelero_z = Double.parseDouble(dataString.substring(dataString.indexOf(SEPARATOR_4) + 1, dataString.indexOf(CLOSING_FLAG)));

            return new SensorData(heartbeat, temperature, accelero_x, accelero_y, accelero_z);
        } catch (NumberFormatException e) {
            System.out.println("Invalid data received");
        }
        return null;

    }
    

    private boolean isValidString(String dataString) {

        return (dataString.contains(OPENING_FLAG) && dataString.contains(SEPARATOR_1) && dataString.contains(SEPARATOR_2) && dataString.contains(SEPARATOR_3) && dataString.contains(SEPARATOR_4) && dataString.contains(CLOSING_FLAG));
    }
}
