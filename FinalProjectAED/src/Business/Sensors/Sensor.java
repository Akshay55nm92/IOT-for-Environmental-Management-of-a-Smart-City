/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensors;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Akshay
 */
public class Sensor {
    private String sensorIdString;
    private int sensorId;
    private static int count = 1;
    private String zipcode;
    private String location;
    private String latitude;
    private String longitude;
    
    int randomValue = 50;
    private Map<Integer, Integer> testMap= new HashMap<>();
    
    public enum SensorType {

        AirPollutionSensor("Air Pollution Sensor"), 
        NoisePollutionSensor("Noise Pollution Sensor"), 
        GarbageSensor("Garbage Sensor"),
        FloodAlertSensor("Flood Alert Sensor");
        private String value;

        private SensorType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    
    public Sensor(){
        sensorId=count;
        count++;
        randomValue+=20;
        
        sensorIdString = String.valueOf(sensorId);
                
        testMap.put(sensorId, randomValue);
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Map<Integer, Integer> getTestMap() {
        return testMap;
    }

    public void setTestMap(Map<Integer, Integer> testMap) {
        this.testMap = testMap;
    }
   
    @Override
    public String toString() {
        return sensorIdString;
    }
}
