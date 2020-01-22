/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Sensors.AirPollutionSensor;

/**
 *
 * @author Akshay
 */
public class AirPollutionSolutionWorkRequest extends WorkRequest {
    
    private AirPollutionSensor airPollutionSensor;

    public AirPollutionSensor getAirPollutionSensor() {
        return airPollutionSensor;
    }

    public void setAirPollutionSensor(AirPollutionSensor airPollutionSensor) {
        this.airPollutionSensor = airPollutionSensor;
    }
    
}
