/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensors;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Akshay
 */
public class NoisePollutionSensor extends Sensor{
    Random rn = new Random();
    int minimum = 70;
    int maximummum = 145;
    private float noiseLevelInDecibel = rn.nextInt(maximummum - minimum) + minimum;
    
     private Map<Date, Float> sensorValues = new HashMap<>();
     
     public NoisePollutionSensor()
   {
       Date date = new Date();
       sensorValues.put(date, noiseLevelInDecibel);
   }
    
    public float getNoiseLevelInDecibel() {
        //setNoiseLevelInDecibel(rn.nextInt(maximummum - minimum) + minimum);
        return noiseLevelInDecibel;
    }

    public void setNoiseLevelInDecibel(float noiseLevelInDecibel) {
        Date date = new Date();
        sensorValues.put(date, noiseLevelInDecibel);
        this.noiseLevelInDecibel = noiseLevelInDecibel;
    }    

    public Map<Date, Float> getSensorValues() {
        return sensorValues;
    }

    public void setSensorValues(Map<Date, Float> sensorValues) {
        this.sensorValues = sensorValues;
    }
        
}
