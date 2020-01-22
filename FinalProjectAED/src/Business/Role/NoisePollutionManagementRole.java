/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.NoisePollutionSolutionOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.EnvironmentManagementRoles.NoisePollutionManagementWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Akshay
 */
public class NoisePollutionManagementRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new NoisePollutionManagementWorkAreaJPanel(userProcessContainer, account, (NoisePollutionSolutionOrganization)organization, enterprise, business);
    }
    
}
