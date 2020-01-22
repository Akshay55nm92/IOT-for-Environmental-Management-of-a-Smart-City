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
public class MasterSensorDirectory {
    private ArrayList<Sensor>  Sensors;
    
    public MasterSensorDirectory()
    {
        Sensors = new ArrayList<Sensor>();
    }

    public ArrayList<Sensor> getSensors() {
        return Sensors;
    }

    public void setSensors(ArrayList<Sensor> Sensors) {
        this.Sensors = Sensors;
    }
    
}
