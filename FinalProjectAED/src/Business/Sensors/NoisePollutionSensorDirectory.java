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
public class NoisePollutionSensorDirectory {
    private ArrayList<NoisePollutionSensor>  NoisePollutionSensors;
    
    public NoisePollutionSensorDirectory(){
        NoisePollutionSensors = new ArrayList<NoisePollutionSensor>();
    }

    public ArrayList<NoisePollutionSensor> getNoisePollutionSensors() {
        return NoisePollutionSensors;
    }

    public void setNoisePollutionSensors(ArrayList<NoisePollutionSensor> NoisePollutionSensors) {
        this.NoisePollutionSensors = NoisePollutionSensors;
    }
    
    public NoisePollutionSensor addNoisePollutionSensor()
    {
        NoisePollutionSensor noisePollutionSensor = new NoisePollutionSensor();
        NoisePollutionSensors.add(noisePollutionSensor);
        return noisePollutionSensor;
    }
}
