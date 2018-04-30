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

public class ProjectwerkSerialData {
    
    private byte[] data = new byte[0];
    
    public ProjectwerkSerialData(byte[] data) {
        this.data = data.clone();
    }
    
    public String getDataAsString() {
        return new String(data);
    }
    
    public byte[] getDataAsBytes() {
        return data.clone();
    }
    
}
