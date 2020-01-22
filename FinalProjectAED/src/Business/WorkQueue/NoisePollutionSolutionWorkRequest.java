/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Sensors.NoisePollutionSensor;

/**
 *
 * @author Akshay
 */
public class NoisePollutionSolutionWorkRequest extends WorkRequest {
    
    private NoisePollutionSensor noisePollutionSensor;
    private String message;

    public NoisePollutionSensor getNoisePollutionSensor() {
        return noisePollutionSensor;
    }

    public void setNoisePollutionSensor(NoisePollutionSensor noisePollutionSensor) {
        this.noisePollutionSensor = noisePollutionSensor;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
}
