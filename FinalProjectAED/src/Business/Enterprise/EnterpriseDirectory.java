/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author Akshay
 */
public class EnterpriseDirectory {
    
    
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.EnvironmentManagement) {
            enterprise = new EnvironmentManagementEnterprise(name, type);
            enterpriseList.add(enterprise);
        }
        
        else if (type == Enterprise.EnterpriseType.Government) {
            enterprise = new GovernmentEnterprise(name, type);
            enterpriseList.add(enterprise);
        }
        
        else if (type == Enterprise.EnterpriseType.SensorManagement) {
            enterprise = new SensorManagementEnterprise(name, type);
            enterpriseList.add(enterprise);
        }
        
        return enterprise;
    }

    public void DeleteEnterprise(Enterprise enterprise) {
       
        enterpriseList.remove(enterprise);
    }

    
}
