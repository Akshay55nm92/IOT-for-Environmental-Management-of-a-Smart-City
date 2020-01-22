/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.GarbageManagementRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Akshay
 */
public class GarbageManagementOrganization extends Organization{
    
    public GarbageManagementOrganization() {
        super(EnvironmentManagementType.GarbageManagement.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new GarbageManagementRole());
        return roles;
    }
    
}
