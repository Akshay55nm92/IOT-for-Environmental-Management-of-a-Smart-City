/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.EnvironmentManagementType;
import static Business.Organization.Organization.EnvironmentManagementType.AirPollutionSolution;
import Business.Organization.Organization.EnvironmentSensorManagementType;
import Business.Organization.Organization.GovernmentType;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Akshay
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
     public Organization createEnvironmentManagement(EnvironmentManagementType type){
        Organization organization = null; 
//        if(type.getValue().equals(EnvironmentManagementType.EnvironmentManagementAdmin.getValue())){
//            organization = new AirPollutionSolutionOrganization();
//            organizationList.add(organization);            
//        }
//        else 

        boolean isOrganizationOfAirPollutionSolutionExist = false;
        boolean isOrganizationOfNoisePollutionSolutionExist = false;
        boolean isOrganizationOfWaterPollutionSolutionExist = false;
        boolean isOrganizatonOfGarbageManagementExist = false;
        boolean isOrganizatonOfFloodAlertManagementExist = false;
        
        for (Organization o : organizationList) {
            if (o instanceof AirPollutionSolutionOrganization) {
                isOrganizationOfAirPollutionSolutionExist = true;
                break;
            } else {
                isOrganizationOfAirPollutionSolutionExist = false;
            }
        }
        
        for (Organization o : organizationList) {
            if (o instanceof NoisePollutionSolutionOrganization) {
                isOrganizationOfNoisePollutionSolutionExist = true;
                break;
            } else {
                isOrganizationOfNoisePollutionSolutionExist = false;
            }
        }
        
        for (Organization o : organizationList) {
            if (o instanceof GarbageManagementOrganization) {
                isOrganizatonOfGarbageManagementExist = true;
                break;
            } else {
                isOrganizatonOfGarbageManagementExist = false;
            }
        }
        
        for (Organization o : organizationList) {
            if (o instanceof FloodAlertManagementOrganization) {
                isOrganizatonOfFloodAlertManagementExist = true;
                break;
            } else {
                isOrganizatonOfFloodAlertManagementExist = false;
            }
        }
        
        if (type.getValue().equals(EnvironmentManagementType.AirPollutionSolution.getValue())){
            if (!isOrganizationOfAirPollutionSolutionExist) {
            organization = new AirPollutionSolutionOrganization();
            organizationList.add(organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Air Pollution Solution Organization for one Enterprise");
            }
        }
        else if (type.getValue().equals(EnvironmentManagementType.NoisePollutionSolution.getValue())){
            if(!isOrganizationOfNoisePollutionSolutionExist) {
            organization = new NoisePollutionSolutionOrganization();
            organizationList.add(organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Noise Pollution Solution Organization for one Enterprise");
            }
        }
        else if (type.getValue().equals(EnvironmentManagementType.GarbageManagement.getValue())){
            if(!isOrganizatonOfGarbageManagementExist) {
            organization = new GarbageManagementOrganization();
            organizationList.add(organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Garbage Management Organization for one Enterprise");
            }
        }
        else if (type.getValue().equals(EnvironmentManagementType.FloodAlertManagement.getValue())){
            if(!isOrganizatonOfFloodAlertManagementExist) {
            organization = new FloodAlertManagementOrganization();
            organizationList.add(organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Flood Alert Management Organization for one Enterprise");
            }
        }
        return organization;
    }
    
     public Organization createGovernmentOfficial(GovernmentType type){
         Organization organization = null;
         
         boolean isOrganizationOfGovernmentExist = false;
         boolean isOrganizationOfCitizenExist = false;
         
         for (Organization o : organizationList) {
            if (o instanceof GovernmentOrganization) {
                isOrganizationOfGovernmentExist = true;
                break;
            } else {
                isOrganizationOfGovernmentExist = false;
            }
        }
         
         for (Organization o : organizationList) {
            if (o instanceof CitizenOrganization) {
                isOrganizationOfCitizenExist = true;
                break;
            } else {
                isOrganizationOfCitizenExist = false;
            }
        }
         
        if (type.getValue().equals(GovernmentType.GovernmentOfficial.getValue())){
            if(!isOrganizationOfGovernmentExist) {
            organization = new GovernmentOrganization();
            organizationList.add(organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Government Organization for one Enterprise");
            }
        }
        
        else if (type.getValue().equals(GovernmentType.Cizizen.getValue())){
            if(!isOrganizationOfCitizenExist) {
            organization = new CitizenOrganization();
            organizationList.add(organization);
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Citizen Organization for one Enterprise");
            }
        }
        
        return organization;
     }
     
     public Organization createEnvironmentSensorManagement(EnvironmentSensorManagementType type){
         Organization organization = null;
         
         boolean isOrganizationOfEnvironmentSensorExist = false;
         
         for (Organization o : organizationList) {
            if (o instanceof EnvironmentSensorOrganization) {
                isOrganizationOfEnvironmentSensorExist = true;
                break;
            } else {
                isOrganizationOfEnvironmentSensorExist = false;
            }
        }
         
        if (type.getValue().equals(EnvironmentSensorManagementType.SensorManagement.getValue())){
            if(!isOrganizationOfEnvironmentSensorExist) {
            organization = new EnvironmentSensorOrganization();
            organizationList.add(organization);
            //JOptionPane.showMessageDialog(null, "Organization added Succesfully");
            } else {
                JOptionPane.showMessageDialog(null, "You can add only one Environment Sensor Management Organization for one Enterprise");
            }
        }
        
        return organization;
     }
     
     public void DeleteOrganization(Organization org) {
        organizationList.remove(org);
    }
     
}
