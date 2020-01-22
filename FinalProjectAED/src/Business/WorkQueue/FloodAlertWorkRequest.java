/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Sensors.FloodAlertSensor;
import java.util.ArrayList;

/**
 *
 * @author arjit
 */
public class FloodAlertWorkRequest extends WorkRequest{
    private ArrayList<FloodAlertSensor> floodalertsensors;
    private String message;

//    public FloodAlertSensor getFloodAlertSensor() {
//        return floodalertsensors;
//    }
//
//    public void setFloodalertsensors(FloodAlertSensor floodalertsensors) {
//        this.floodalertsensors = floodalertsensors;
//    }

    public ArrayList<FloodAlertSensor> getFloodalertsensors() {
        return floodalertsensors;
    }

    public void setFloodalertsensors(ArrayList<FloodAlertSensor> floodalertsensors) {
        this.floodalertsensors = floodalertsensors;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
