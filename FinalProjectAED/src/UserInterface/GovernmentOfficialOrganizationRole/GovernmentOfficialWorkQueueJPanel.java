/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.GovernmentOfficialOrganizationRole;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CitizenOrganization;
import Business.Organization.EnvironmentSensorOrganization;
import Business.Organization.GovernmentOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Sensors.AirPollutionSensor;
import Business.Sensors.Sensor;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CitizenWorkRequest;
import Business.WorkQueue.GovernmentWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akshay
 */
public class GovernmentOfficialWorkQueueJPanel extends javax.swing.JPanel {

    private OrganizationDirectory directory;
    private UserAccount userAccount;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    /**
     * Creates new form GovernmentOfficialWorkQueueJPanel
     */
    public GovernmentOfficialWorkQueueJPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, OrganizationDirectory directory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.directory = directory;
        this.enterprise = enterprise;
        
        populateTable();
    }

    public void populateTable(){
        GovernmentWorkRequest gov_wrs = null;
        DefaultTableModel model = (DefaultTableModel) AirPollutionWorkQueuejTable.getModel();
        model.setRowCount(0);
        
        for(Organization organization : directory.getOrganizationList())
        {
        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
            if (wr instanceof GovernmentWorkRequest)
            {                
                gov_wrs = (GovernmentWorkRequest)wr;
            
                if(gov_wrs.getAirPollutionSensor() != null)
                {
                Object[] row = new Object[3];
                row[0] = gov_wrs;
                row[1] = gov_wrs.getSender();
                row[2] = gov_wrs.getAirPollutionMessage();
                model.addRow(row);
                }
            }
        }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AirPollutionWorkQueuejTable = new javax.swing.JTable();
        backjButton1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        MessagejLabel = new javax.swing.JLabel();
        CitizenNotificationjButton = new javax.swing.JButton();
        CitizenNotificationjButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Government Official Work Queue");

        AirPollutionWorkQueuejTable.setBackground(new java.awt.Color(234, 234, 249));
        AirPollutionWorkQueuejTable.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        AirPollutionWorkQueuejTable.setForeground(new java.awt.Color(0, 0, 51));
        AirPollutionWorkQueuejTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Work Request Id", "Sender", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(AirPollutionWorkQueuejTable);

        backjButton1.setBackground(new java.awt.Color(0, 0, 204));
        backjButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backjButton1.setForeground(new java.awt.Color(255, 255, 255));
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("View Complete Message");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        MessagejLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        MessagejLabel.setForeground(new java.awt.Color(255, 0, 51));

        CitizenNotificationjButton.setBackground(new java.awt.Color(255, 0, 51));
        CitizenNotificationjButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CitizenNotificationjButton.setForeground(new java.awt.Color(255, 255, 255));
        CitizenNotificationjButton.setText("Send Alert Notificatication to Citizens");
        CitizenNotificationjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CitizenNotificationjButtonActionPerformed(evt);
            }
        });

        CitizenNotificationjButton1.setBackground(new java.awt.Color(0, 204, 0));
        CitizenNotificationjButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CitizenNotificationjButton1.setForeground(new java.awt.Color(255, 255, 255));
        CitizenNotificationjButton1.setText("Send Resolve Notificatication to Citizens");
        CitizenNotificationjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CitizenNotificationjButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CitizenNotificationjButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(MessagejLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(181, 181, 181)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CitizenNotificationjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(153, 153, 153)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1048, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(backjButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CitizenNotificationjButton))
                .addGap(28, 28, 28)
                .addComponent(CitizenNotificationjButton1)
                .addGap(15, 15, 15)
                .addComponent(MessagejLabel)
                .addContainerGap(173, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         int row = AirPollutionWorkQueuejTable.getSelectedRow();
        try
        {
         GovernmentWorkRequest request = (GovernmentWorkRequest)AirPollutionWorkQueuejTable.getValueAt(row, 0);
         MessagejLabel.setText(request.getAirPollutionMessage());
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CitizenNotificationjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CitizenNotificationjButtonActionPerformed
        // TODO add your handling code here:
        int row = AirPollutionWorkQueuejTable.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        
        GovernmentWorkRequest request = (GovernmentWorkRequest)AirPollutionWorkQueuejTable.getValueAt(row, 0);
        
        CitizenWorkRequest citizenWorkRequest = new CitizenWorkRequest();
        
        citizenWorkRequest.setAirPollutionSensor(request.getAirPollutionSensor());
        citizenWorkRequest.setAirPollutionMessage("The Area bearing pincode "+request.getAirPollutionSensor().getZipcode()+" has bad air quality please avoid this area until further notice");
        citizenWorkRequest.setSender(userAccount);
        citizenWorkRequest.setStatus("Message Sent to Citizens");
        
        Organization orgn = null;
        Organization orgn1 = null;
                for(Organization org : directory.getOrganizationList())
                {
            //System.out.println(org.getName());
            if (org instanceof GovernmentOrganization){
                orgn = org;
                break;
            }
           
            } 
                for(Organization org1 : directory.getOrganizationList())
                {
                if(org1 instanceof CitizenOrganization){
                orgn1 = org1;
                break;
            
            } }
        if (orgn!=null){
            orgn.getWorkQueue().getWorkRequestList().add(citizenWorkRequest);
            userAccount.getWorkQueue().getWorkRequestList().add(citizenWorkRequest);
        }
        
        if (orgn1!=null){            
            orgn1.getWorkQueue().getWorkRequestList().add(citizenWorkRequest);
            userAccount.getWorkQueue().getWorkRequestList().add(citizenWorkRequest);
        }
         JOptionPane.showMessageDialog(null, "Request Sent to Citizen");
        }
    }//GEN-LAST:event_CitizenNotificationjButtonActionPerformed

    private void CitizenNotificationjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CitizenNotificationjButton1ActionPerformed
        // TODO add your handling code here:
        int row = AirPollutionWorkQueuejTable.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        
        GovernmentWorkRequest request = (GovernmentWorkRequest)AirPollutionWorkQueuejTable.getValueAt(row, 0);
        
        CitizenWorkRequest citizenWorkRequest = new CitizenWorkRequest();
        
        citizenWorkRequest.setAirPollutionSensor(request.getAirPollutionSensor());
        citizenWorkRequest.setAirPollutionMessage("The Area bearing pincode "+request.getAirPollutionSensor().getZipcode()+"'s air quality has now improved.");
        citizenWorkRequest.setSender(userAccount);
        citizenWorkRequest.setStatus("Message Sent to Citizens");
        
        Organization orgn = null;
        Organization orgn1 = null;
                for(Organization org : directory.getOrganizationList())
                {
            //System.out.println(org.getName());
            if (org instanceof GovernmentOrganization){
                orgn = org;
                break;
            }
           
            } 
                for(Organization org1 : directory.getOrganizationList())
                {
                if(org1 instanceof CitizenOrganization){
                orgn1 = org1;
                break;
            
            } }
        if (orgn!=null){
            orgn.getWorkQueue().getWorkRequestList().add(citizenWorkRequest);
            userAccount.getWorkQueue().getWorkRequestList().add(citizenWorkRequest);
        }
        
        if (orgn1!=null){            
            orgn1.getWorkQueue().getWorkRequestList().add(citizenWorkRequest);
            userAccount.getWorkQueue().getWorkRequestList().add(citizenWorkRequest);
        }
         JOptionPane.showMessageDialog(null, "Request Sent to Citizen");
        }
    }//GEN-LAST:event_CitizenNotificationjButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AirPollutionWorkQueuejTable;
    private javax.swing.JButton CitizenNotificationjButton;
    private javax.swing.JButton CitizenNotificationjButton1;
    private javax.swing.JLabel MessagejLabel;
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
