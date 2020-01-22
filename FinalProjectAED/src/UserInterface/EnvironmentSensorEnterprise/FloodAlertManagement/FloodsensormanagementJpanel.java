/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EnvironmentSensorEnterprise.FloodAlertManagement;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.EnvironmentSensorOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author arjit
 */
public class FloodsensormanagementJpanel extends javax.swing.JPanel {
private JPanel userProcessContainer; 
    private UserAccount account; 
    private EnvironmentSensorOrganization organization; 
    private Enterprise enterprise; 
    private EcoSystem business;
    /**
     * Creates new form FloodsensormanagementJpanel
     */
    public FloodsensormanagementJpanel() {
        initComponents();
    }

    public FloodsensormanagementJpanel(JPanel userProcessContainer, UserAccount account, EnvironmentSensorOrganization organization, Enterprise enterprise, EcoSystem business) {
         initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backJButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        SendRequestjButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        backJButton.setBackground(new java.awt.Color(0, 0, 204));
        backJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("View Sent Requests");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        SendRequestjButton.setBackground(new java.awt.Color(0, 0, 204));
        SendRequestjButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SendRequestjButton.setForeground(new java.awt.Color(255, 255, 255));
        SendRequestjButton.setText("Send Request");
        SendRequestjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendRequestjButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Flood management sensor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SendRequestjButton)
                            .addComponent(jButton2)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(backJButton)))
                .addContainerGap(342, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(79, 79, 79)
                .addComponent(SendRequestjButton)
                .addGap(43, 43, 43)
                .addComponent(jButton2)
                .addGap(59, 59, 59)
                .addComponent(backJButton)
                .addContainerGap(178, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        //SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ViewFloodWorkQueuejPanel viewfloodWorkQueueJPanel = new ViewFloodWorkQueuejPanel(userProcessContainer, account, enterprise.getOrganizationDirectory(), business);
        userProcessContainer.add("viewfloodWorkQueueJPanel", viewfloodWorkQueueJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void SendRequestjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendRequestjButtonActionPerformed
        // TODO add your handling code here:
        SendRequestToFloodSolutionDepartment floodsolution;
    try {
        floodsolution = new SendRequestToFloodSolutionDepartment(userProcessContainer, account, business, enterprise.getOrganizationDirectory());
        userProcessContainer.add("floodsolutiondepartment", floodsolution);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    } catch (IOException ex) {
        Logger.getLogger(FloodsensormanagementJpanel.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_SendRequestjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SendRequestjButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
