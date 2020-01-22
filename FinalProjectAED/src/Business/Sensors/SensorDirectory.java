/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensors;

import Business.Sensors.Sensor.SensorType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Akshay
 */
public class SensorDirectory {
    
    private ArrayList<Sensor> sensorList;
    
    private Map<String, Float> airPollutionSensorValues = new HashMap<>();
    private Map<String, Float> noisePollutionSensorValues = new HashMap<>();
    private Map<String, Float> floodAlertSensorValues = new HashMap<>();
    private Map<String, Float> garbageManagementSensorValues = new HashMap<>();    
    
    public SensorDirectory()
    {
        sensorList = new ArrayList<Sensor>();
    }
    
    public Sensor createSensor(SensorType type)
    {
        Sensor sensor = null;
        
        if (type.getValue().equals(SensorType.AirPollutionSensor.getValue())){
            sensor = new AirPollutionSensor();
            sensorList.add(sensor);
        }
        
        else if (type.getValue().equals(SensorType.FloodAlertSensor.getValue())){
            sensor = new FloodAlertSensor();
            sensorList.add(sensor);
        }
        
        else if (type.getValue().equals(SensorType.GarbageSensor.getValue())){
            sensor = new GarbageSensor();
            sensorList.add(sensor);
        }
        
        else if (type.getValue().equals(SensorType.NoisePollutionSensor.getValue())){
            sensor = new NoisePollutionSensor();
            sensorList.add(sensor);
        }        
        return sensor;
    }

    public Map<String, Float> getAirPollutionSensorValues() {
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof AirPollutionSensor)
            {
                AirPollutionSensor aps = (AirPollutionSensor) sensorList.get(i);
                airPollutionSensorValues.put(aps.getZipcode(), aps.getAirQualityIndex());
            }
        }
        return airPollutionSensorValues;
    }
    

    public Map<String, Float> getNoisePollutionSensorValues() {
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof NoisePollutionSensor)
            {
                NoisePollutionSensor nps = (NoisePollutionSensor) sensorList.get(i);
                noisePollutionSensorValues.put(nps.getZipcode(), nps.getNoiseLevelInDecibel());
            }
        }
        return noisePollutionSensorValues;
    }

    public Map<String, Float> getFloodAlertSensorValues() {
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof FloodAlertSensor)
            {
                FloodAlertSensor fas = (FloodAlertSensor) sensorList.get(i);
                floodAlertSensorValues.put(fas.getZipcode(), fas.getCurrentlevel());
            }
        }
        return floodAlertSensorValues;
    }

    public Map<String, Float> getGarbageManagementSensorValues() {
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof GarbageSensor)
            {
                GarbageSensor gs = (GarbageSensor) sensorList.get(i);
                garbageManagementSensorValues.put(gs.getZipcode(), gs.getCurrentlevel());
            }
        }        
        return garbageManagementSensorValues;
    }
    
    
    
    
//    public void removeSensor(Sensor s)
//    {
//        Sensor sensor = null;
//        
//        if (s instanceof AirPollutionSensor){
//            sensorList.remove(s);
//        }
//        
//        else if (s instanceof NoisePollutionSensor){
//            sensorList.remove(s);
//        }
//        
//        else if (s instanceof FloodAlertSensor){
//            sensorList.remove(s);
//        }
//        
//        else if (s instanceof GarbageSensor){
//            sensorList.remove(s);
//        }
//    }
    
    public boolean AirPollutionSensorExists(String zipcode)
    {
        boolean sensorAlreadyPresent = false;
        ArrayList<AirPollutionSensor> airPollutionSensorList = new ArrayList<AirPollutionSensor>();
        
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof AirPollutionSensor)
            {
                AirPollutionSensor aps = (AirPollutionSensor) sensorList.get(i);
                airPollutionSensorList.add(aps);
            }
        }
        
        for(int i=0; i<airPollutionSensorList.size(); i++)
        {
            if(zipcode.equals(airPollutionSensorList.get(i).getZipcode()))
            {
                sensorAlreadyPresent = true;
            }
        }
        return sensorAlreadyPresent;
    }

    public boolean NoisePollutionSensorExists(String zipcode)
    {
        boolean sensorAlreadyPresent = false;
        ArrayList<NoisePollutionSensor> noisePollutionSensorList = new ArrayList<NoisePollutionSensor>();
        
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof NoisePollutionSensor)
            {
                NoisePollutionSensor nps = (NoisePollutionSensor) sensorList.get(i);
                noisePollutionSensorList.add(nps);
            }
        }
        
        for(int i=0; i<noisePollutionSensorList.size(); i++)
        {
            if(zipcode.equals(noisePollutionSensorList.get(i).getZipcode()))
            {
                sensorAlreadyPresent = true;
            }
        }
        return sensorAlreadyPresent;
    }
    
    public boolean FloodAlertSensorSensorExists(String zipcode)
    {
        boolean sensorAlreadyPresent = false;
        ArrayList<FloodAlertSensor> floodAlertSensorList = new ArrayList<FloodAlertSensor>();
        
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof FloodAlertSensor)
            {
                FloodAlertSensor fas = (FloodAlertSensor) sensorList.get(i);
                floodAlertSensorList.add(fas);
            }
        }
        
        for(int i=0; i<floodAlertSensorList.size(); i++)
        {
            if(zipcode.equals(floodAlertSensorList.get(i).getZipcode()))
            {
                sensorAlreadyPresent = true;
            }
        }
        return sensorAlreadyPresent;
    }
    
    public boolean GarbageManagementSensorExists(String zipcode)
    {
        boolean sensorAlreadyPresent = false;
        ArrayList<GarbageSensor> garbageSensorList = new ArrayList<GarbageSensor>();
        
        for(int i=0; i<sensorList.size(); i++)
        {
            if(sensorList.get(i) instanceof GarbageSensor)
            {
                GarbageSensor gs = (GarbageSensor) sensorList.get(i);
                garbageSensorList.add(gs);
            }
        }
        
        for(int i=0; i<garbageSensorList.size(); i++)
        {
            if(zipcode.equals(garbageSensorList.get(i).getZipcode()))
            {
                sensorAlreadyPresent = true;
            }
        }
        return sensorAlreadyPresent;
    }
    
    public ArrayList<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(ArrayList<Sensor> sensorList) {
        this.sensorList = sensorList;
    }
   
}
