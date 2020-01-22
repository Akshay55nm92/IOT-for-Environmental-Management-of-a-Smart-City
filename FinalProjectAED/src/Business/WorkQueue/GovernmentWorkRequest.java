/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Sensors.AirPollutionSensor;
import Business.Sensors.FloodAlertSensor;
import java.util.ArrayList;

/**
 *
 * @author Akshay
 */
public class GovernmentWorkRequest extends WorkRequest {
    private AirPollutionSensor airPollutionSensor;
    private ArrayList<FloodAlertSensor> floodAlertSensorList;
    private String AirPollutionMessage;
    private String FloodAlertMessage;

    public String getAirPollutionMessage() {
        return AirPollutionMessage;
    }

    public void setAirPollutionMessage(String AirPollutionMessage) {
        this.AirPollutionMessage = AirPollutionMessage;
    }

    public String getFloodAlertMessage() {
        return FloodAlertMessage;
    }

    public void setFloodAlertMessage(String FloodAlertMessage) {
        this.FloodAlertMessage = FloodAlertMessage;
    }

    public AirPollutionSensor getAirPollutionSensor() {
        return airPollutionSensor;
    }

    public void setAirPollutionSensor(AirPollutionSensor airPollutionSensor) {
        this.airPollutionSensor = airPollutionSensor;
    }

//    public FloodAlertSensor getFloodAlertSensor() {
//        return floodAlertSensor;
//    }
//
//    public void setFloodAlertSensor(FloodAlertSensor floodAlertSensor) {
//        this.floodAlertSensor = floodAlertSensor;
//    }
    
    public ArrayList<FloodAlertSensor> getFloodAlertSensorList() {
        return floodAlertSensorList;
    }

    public void setFloodAlertSensorList(ArrayList<FloodAlertSensor> floodAlertSensorList) {
        this.floodAlertSensorList = floodAlertSensorList;
    }
    
}
