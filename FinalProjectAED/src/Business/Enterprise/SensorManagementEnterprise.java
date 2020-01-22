/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.EnvironmentSensorAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Akshay
 */
public class SensorManagementEnterprise extends Enterprise{
    
    public SensorManagementEnterprise(String name, Enterprise.EnterpriseType type) {
        super(name, type.SensorManagement);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new EnvironmentSensorAdminRole());
        return roles; //To change body of generated methods, choose Tools | Templates.
    }
    
}
