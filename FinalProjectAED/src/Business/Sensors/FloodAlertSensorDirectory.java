/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensors;

import java.util.ArrayList;

/**
 *
 * @author Akshay
 */
public class FloodAlertSensorDirectory {
    private ArrayList<FloodAlertSensor>  FloodAlertSensors;
    
    public FloodAlertSensorDirectory()
    {
        FloodAlertSensors = new ArrayList<FloodAlertSensor>();
    }

    public ArrayList<FloodAlertSensor> getFloodAlertSensors() {
        return FloodAlertSensors;
    }

    public void setFloodAlertSensors(ArrayList<FloodAlertSensor> FloodAlertSensors) {
        this.FloodAlertSensors = FloodAlertSensors;
    }
    
    public FloodAlertSensor addFloodAlertSensor()
    {
        FloodAlertSensor floodAlertSensor = new FloodAlertSensor();
        FloodAlertSensors.add(floodAlertSensor);
        return floodAlertSensor;
    }
}
