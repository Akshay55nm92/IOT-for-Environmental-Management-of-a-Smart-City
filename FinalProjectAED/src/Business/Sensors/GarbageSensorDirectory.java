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
public class GarbageSensorDirectory {
    private ArrayList<GarbageSensor>  GarbageSensors;
    
    public GarbageSensorDirectory()
    {
        GarbageSensors = new ArrayList<GarbageSensor>();
    }

    public ArrayList<GarbageSensor> getGarbageSensors() {
        return GarbageSensors;
    }

    public void setGarbageSensors(ArrayList<GarbageSensor> GarbageSensors) {
        this.GarbageSensors = GarbageSensors;
    }
    
    public GarbageSensor addGarbageSensor()
    {
        GarbageSensor garbageSensor = new GarbageSensor();
        GarbageSensors.add(garbageSensor);
        return garbageSensor;
    }
    
}
