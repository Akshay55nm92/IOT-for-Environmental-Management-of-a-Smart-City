/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Akshay
 */
public class EcoSystem extends Organization{
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    private EcoSystem(){
        super(null);
        networkList=new ArrayList<Network>();
    }
    
    public ArrayList<Network> getNetworkList() {
        return networkList;
    }
    
    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public boolean checkIfUsernameIsUnique(String username) {

        for (UserAccount ua : this.getUserAccountDirectory().getUserAccountList()) {
            // System.out.println("EcoSystem" + ua.getUsername());
            if (ua.getUsername().equals(username)) {
                return false;
            }
            for (Network n : this.getNetworkList()) {
                for (Enterprise ent : n.getEnterpriseDirectory().getEnterpriseList()) {
                    for (UserAccount ucc : ent.getUserAccountDirectory().getUserAccountList()) {
                        //           System.out.println("Enterprise-->" + ucc.getUsername());
                        if (ucc.getUsername().equals(username)) {
                            return false;
                        }
                        for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {
                            for (UserAccount accOrg : org.getUserAccountDirectory().getUserAccountList()) {
                                //                 System.out.println("Organization-->" + accOrg.getUsername());
                                if (accOrg.getUsername().equals(username)) {
                                    return false;
                                }
                            }

                        }
                    }

                }
            }

        }
        return true;
    }
    
    public boolean checkIfCityNameisUnique(String cityName) {

        for (Network n : this.networkList) {
            if (n.getName().equals(cityName)) {
                return true;
            }
        }
        return false;
    }
    
    public void DeleteCity(Network n) {
        networkList.remove(n);
    }
     
}
