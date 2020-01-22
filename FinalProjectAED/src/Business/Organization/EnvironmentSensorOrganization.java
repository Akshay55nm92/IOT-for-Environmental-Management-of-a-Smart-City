/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.FloodAlertManagementRole;
import Business.Role.Role;
import Business.Role.SensorManagementRole;
import Business.Sensors.AirPollutionSensorDirectory;
import Business.Sensors.FloodAlertSensorDirectory;
import Business.Sensors.GarbageSensorDirectory;
import Business.Sensors.NoisePollutionSensorDirectory;
import Business.Sensors.SensorDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Akshay
 */
public class EnvironmentSensorOrganization extends Organization{
    
    private SensorDirectory sensorDirectory;
    
    private WorkQueue GovernmentworkQueue;
    
    public EnvironmentSensorOrganization() {
        super(EnvironmentSensorManagementType.SensorManagement.getValue());
        
        sensorDirectory = new SensorDirectory();
    }

    public SensorDirectory getSensorDirectory() {
        return sensorDirectory;
    }

    public void setSensorDirectory(SensorDirectory sensorDirectory) {
        this.sensorDirectory = sensorDirectory;
    }

    public WorkQueue getGovernmentworkQueue() {
        return GovernmentworkQueue;
    }

    public void setGovernmentworkQueue(WorkQueue GovernmentworkQueue) {
        this.GovernmentworkQueue = GovernmentworkQueue;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SensorManagementRole());
        return roles;
    }
    
}
