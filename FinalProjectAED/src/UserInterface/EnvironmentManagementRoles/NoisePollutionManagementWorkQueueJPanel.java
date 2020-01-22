/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EnvironmentManagementRoles;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.NoisePollutionSolutionWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akshay
 */
public class NoisePollutionManagementWorkQueueJPanel extends javax.swing.JPanel {

    private OrganizationDirectory directory;
    private UserAccount userAccount;
    private JPanel userProcessContainer;
    /**
     * Creates new form NoisePollutionManagementWorkQueueJPanel
     */
    public NoisePollutionManagementWorkQueueJPanel(JPanel userProcessContainer, UserAccount userAccount, OrganizationDirectory directory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.directory = directory;
        
        populateTable();        
    }
    
    public void populateTable(){
        NoisePollutionSolutionWorkRequest noise_wrs = null;
        DefaultTableModel model = (DefaultTableModel) WorkQueuejTable.getModel();
        model.setRowCount(0);
        
        for(Organization organization : directory.getOrganizationList())
        {
        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
            if (wr instanceof NoisePollutionSolutionWorkRequest){
                noise_wrs = (NoisePollutionSolutionWorkRequest)wr;
            
                Object[] row = new Object[8];
                row[0] = noise_wrs;
                row[1] = noise_wrs.getSender();
                row[2] = noise_wrs.getNoisePollutionSensor().getSensorId();
                row[3] = noise_wrs.getNoisePollutionSensor().getZipcode();
                row[4] = noise_wrs.getStatus();
                row[5] = noise_wrs.getMessage();
                row[6] = noise_wrs.getRequestDate();
                row[7] = noise_wrs.getResolveDate();
                model.addRow(row);
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
        WorkQueuejTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Noise Pollution Management Work Queue");
        add(jLabel1);
        jLabel1.setBounds(40, 40, 497, 29);

        WorkQueuejTable.setBackground(new java.awt.Color(234, 234, 249));
        WorkQueuejTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        WorkQueuejTable.setForeground(new java.awt.Color(0, 0, 51));
        WorkQueuejTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Work Request ID", "Sender", "Sensor Id", "Zipcode", "Status", "Message", "Received Date", "Resolved Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(WorkQueuejTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(6, 128, 1360, 177);

        backJButton.setBackground(new java.awt.Color(0, 0, 204));
        backJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton);
        backJButton.setBounds(6, 353, 91, 25);

        jButton2.setBackground(new java.awt.Color(0, 0, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Resolve");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(450, 353, 85, 25);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/pics/Noise Pollution.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(5, -14, 1380, 920);
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
        int row = WorkQueuejTable.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        Random rn = new Random();

        WorkRequest workRequest = (WorkRequest) WorkQueuejTable.getValueAt(row, 0);

        NoisePollutionSolutionWorkRequest noisePollutionSolutionWorkRequest = (NoisePollutionSolutionWorkRequest)workRequest;
        noisePollutionSolutionWorkRequest.setStatus("Resolved");
        noisePollutionSolutionWorkRequest.setResolveDate(new Date());

        noisePollutionSolutionWorkRequest.getNoisePollutionSensor().setNoiseLevelInDecibel(rn.nextInt(60));

        populateTable();
        
        JOptionPane.showMessageDialog(null, "problem resolved");
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable WorkQueuejTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}