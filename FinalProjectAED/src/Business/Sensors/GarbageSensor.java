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
public class GarbageSensor extends Sensor{
    private float GarbageContainerTrasholdValue = 200;
    Random rn = new Random();
    private float currentlevel = 50+rn.nextInt(300);
    
    private Map<Date, Float> sensorValues = new HashMap<>();
    
    public GarbageSensor()
   {
       Date date = new Date();
       sensorValues.put(date, currentlevel);
   }

    public float getCurrentlevel() {
        return currentlevel;
    }

    public void setCurrentlevel(float currentlevel) {
        Date date = new Date();
        sensorValues.put(date, currentlevel);
        this.currentlevel = currentlevel;
    }    

    public float getGarbageContainerTrasHoldValue() {
        return GarbageContainerTrasholdValue;
    }

    public void setGarbageContainerTrasHoldValue(float GarbageContainerTrasHoldValue) {
        this.GarbageContainerTrasholdValue = GarbageContainerTrasHoldValue;
    }

    public Map<Date, Float> getSensorValues() {
        return sensorValues;
    }

    public void setSensorValues(Map<Date, Float> sensorValues) {
        this.sensorValues = sensorValues;
    }
 
}
