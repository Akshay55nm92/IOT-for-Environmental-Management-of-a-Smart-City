/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensors;


import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Akshay
 */
public class AirPollutionSensor extends Sensor {
    Random rn = new Random();
    int minimum = 140;
    int maximummum = 200;
    private float airQualityIndex = rn.nextInt(maximummum - minimum) + minimum;// = rn.nextInt(maximummum - minimum) + minimum;
    
    private Map<Date, Float> sensorValues = new HashMap<>();
    
    public AirPollutionSensor()
   {
       Date date = new Date();
       sensorValues.put(date, airQualityIndex);
   }
    
    public float getAirQualityIndex() {
        return airQualityIndex;
    }

    public void setAirQualityIndex(float airQualityIndex) {
        Date date = new Date();
        sensorValues.put(date, airQualityIndex);
        this.airQualityIndex = airQualityIndex;
    }
    
    public void setAQIOnRequest(float p){
        airQualityIndex = p;
    }

    public Map<Date, Float> getSensorValues() {
        return sensorValues;
    }

    public void setSensorValues(Map<Date, Float> sensorValues) {
        this.sensorValues = sensorValues;
    }
    
}
