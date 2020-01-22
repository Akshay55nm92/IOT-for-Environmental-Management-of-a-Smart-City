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
public class AirPollutionSensorDirectory {
    private ArrayList<AirPollutionSensor>  AirPollutionSensors;
    
    public AirPollutionSensorDirectory()
    {
        AirPollutionSensors = new ArrayList<AirPollutionSensor>();
    }

    public ArrayList<AirPollutionSensor> getAirPollutionSensors() {
        return AirPollutionSensors;
    }

    public void setAirPollutionSensors(ArrayList<AirPollutionSensor> AirPollutionSensors) {
        this.AirPollutionSensors = AirPollutionSensors;
    }
    
    public AirPollutionSensor addAirPollutionSensor()
    {
        AirPollutionSensor airPollutionSensor = new AirPollutionSensor();
        AirPollutionSensors.add(airPollutionSensor);
        return airPollutionSensor;
    }
    
    
}
