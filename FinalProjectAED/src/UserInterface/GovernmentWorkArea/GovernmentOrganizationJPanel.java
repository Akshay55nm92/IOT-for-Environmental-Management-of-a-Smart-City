/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.GovernmentWorkArea;

import Business.Organization.Organization;
import Business.Organization.Organization.GovernmentType;
import Business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akshay
 */
public class GovernmentOrganizationJPanel extends javax.swing.JPanel {

    private OrganizationDirectory directory;
    private JPanel userProcessContainer;
    /**
     * Creates new form GovernmentEnterpriseJPanel
     */
    public GovernmentOrganizationJPanel(JPanel userProcessContainer, OrganizationDirectory directory) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.directory = directory;
        
        populateTable();
        populateCombo();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();

        model.setRowCount(0);

        for (Organization organization : directory.getOrganizationList()) {
            Object[] row = new Object[1];

            row[0] = organization;

            model.addRow(row);
        }
    }
    
    private void populateCombo() {
        organizationJComboBox.removeAllItems();
        for (Organization.GovernmentType type : Organization.GovernmentType.values()) {
            if (!type.getValue().equals(Organization.GovernmentType.GovernmentAdmin.getValue())) {
                organizationJComboBox.addItem(type);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        addJButton = new javax.swing.JButton();
        btnDeleteOrganization = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        organizationJTable.setBackground(new java.awt.Color(234, 234, 249));
        organizationJTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        organizationJTable.setForeground(new java.awt.Color(0, 0, 51));
        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Organization Type ");

        organizationJComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        organizationJComboBox.setForeground(new java.awt.Color(0, 0, 51));
        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });

        addJButton.setBackground(new java.awt.Color(0, 0, 204));
        addJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addJButton.setForeground(new java.awt.Color(255, 255, 255));
        addJButton.setText("Add Organization");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });

        btnDeleteOrganization.setBackground(new java.awt.Color(0, 0, 204));
        btnDeleteOrganization.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteOrganization.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteOrganization.setText("Delete Organization");
        btnDeleteOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteOrganizationActionPerformed(evt);
            }
        });

        backJButton.setBackground(new java.awt.Color(0, 0, 204));
        backJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Government Organization");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addJButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(backJButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDeleteOrganization))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(293, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(organizationJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(37, 37, 37)
                .addComponent(addJButton)
                .addGap(27, 27, 27)
                .addComponent(btnDeleteOrganization)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backJButton)
                .addContainerGap(133, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed

        GovernmentType type = (GovernmentType) organizationJComboBox.getSelectedItem();

        directory.createGovernmentOfficial(type);
        //directory.createEnvironmentManagement(type);
        populateTable();
    }//GEN-LAST:event_addJButtonActionPerformed

    private void btnDeleteOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteOrganizationActionPerformed
        // TODO add your handling code here:
        int selectedRow = organizationJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select the row");
            return;
        }
        Organization org = (Organization) organizationJTable.getValueAt(selectedRow, 0);
        directory.DeleteOrganization(org);
        populateTable();
        JOptionPane.showMessageDialog(null, "Organization deleted Succesfully");
    }//GEN-LAST:event_btnDeleteOrganizationActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnDeleteOrganization;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    // End of variables declaration//GEN-END:variables
}
