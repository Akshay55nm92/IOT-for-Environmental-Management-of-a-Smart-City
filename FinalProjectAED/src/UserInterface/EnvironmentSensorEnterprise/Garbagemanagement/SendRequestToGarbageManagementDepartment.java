/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EnvironmentSensorEnterprise.Garbagemanagement;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.EnvironmentSensorOrganization;
import Business.Organization.GarbageManagementOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Sensors.FloodAlertSensor;
import Business.Sensors.GarbageSensor;
import Business.Sensors.Sensor;
import Business.Sensors.SensorDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.GarbageManagementWorkRequest;
import Business.WorkQueue.NoisePollutionSolutionWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import static javafx.scene.input.KeyCode.G;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author arjit
 */
public class SendRequestToGarbageManagementDepartment extends javax.swing.JPanel {

     private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private OrganizationDirectory organizationDirectory;
    /**
     * Creates new form SendRequestToNoisePollutionSolutionDepartmentJPanel
     */
    public SendRequestToGarbageManagementDepartment(JPanel userProcessContainer, UserAccount userAccount, EcoSystem business, OrganizationDirectory organizationDirectory) throws IOException {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.userAccount = userAccount;
        this.organizationDirectory = organizationDirectory;
        
        readFromCSV();
        populateTable();
    }

    public void readFromCSV() throws IOException
    {
        //String csvFile = "C:\\Users\\Akshay\\Desktop\\AirPollution.csv";
        
        String csvFile = "src\\CSV_Files\\AirPollution.csv";
	        BufferedReader bufferedReader = null;
	        String line = "";
	        String cvsSplitBy = ",";
	        try {
	            bufferedReader = new BufferedReader(new FileReader(csvFile));
                    ArrayList<String[]> dataCsvArr = new ArrayList();
                    int count = 0;
	            while ((line = bufferedReader.readLine()) != null) {
	                String[] dataFromCsv = line.split(cvsSplitBy);
                        dataCsvArr.add(count,dataFromCsv);
                        count++;
	            }
                    for(int i=1;i<dataCsvArr.size();i++){ 
                                for(Organization o : organizationDirectory.getOrganizationList())
                                {
                                    if (o instanceof EnvironmentSensorOrganization){
                                        EnvironmentSensorOrganization eo = (EnvironmentSensorOrganization)o;
                                        SensorDirectory sd = eo.getSensorDirectory();
                                        String valuesOfArray2[] = dataCsvArr.get(i);
                                        if(sd.GarbageManagementSensorExists(valuesOfArray2[1]))
                                        {
                                            break;
                                        }
                                        else
                                        {
                                        Sensor s = sd.createSensor(Sensor.SensorType.GarbageSensor);
                                        GarbageSensor gas = (GarbageSensor) s;
                                        String valuesOfArray[] = dataCsvArr.get(i);
                                        gas.setLocation(valuesOfArray[0]);
                                        gas.setZipcode(valuesOfArray[1]);
                                        gas.setLatitude(valuesOfArray[2]);
                                        gas.setLongitude(valuesOfArray[3]);
                                        }
                                    }
                                }
                            }
                        bufferedReader.close();
                }
	         catch (FileNotFoundException e) {
	            e.printStackTrace();
                }
    }
    
    public void populateTable()
    {
        ArrayList<GarbageSensor> garbageSensorList = new ArrayList<GarbageSensor>();

        for(Network n: business.getNetworkList())
        {
            for(Enterprise enterprise : n.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
            {
            if(org instanceof EnvironmentSensorOrganization)
            {
                SensorDirectory sd;
                sd = ((EnvironmentSensorOrganization) org).getSensorDirectory();
                
                for(Sensor s : sd.getSensorList())
                {
                    if(s instanceof GarbageSensor)
                    {
                        GarbageSensor a = (GarbageSensor)s;
                        garbageSensorList.add(a);
                    }
                }
            }

            }
        }   }
            
            DefaultTableModel model = (DefaultTableModel) garbagereading.getModel();
        model.setRowCount(0);
        
        for(GarbageSensor nps : garbageSensorList)
                {
                Object[] row = new Object[3];
                row[0] = nps;
                row[1] = nps.getZipcode();
                row[2] = nps.getCurrentlevel();
                model.addRow(row);
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
        garbagereading = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        garbagehigh = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        garbagereading.setBackground(new java.awt.Color(234, 234, 249));
        garbagereading.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        garbagereading.setForeground(new java.awt.Color(0, 0, 51));
        garbagereading.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sensorid", "Zipcode", "Garbage level"
            }
        ));
        jScrollPane1.setViewportView(garbagereading);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Garbage Sensor Readings ");

        garbagehigh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        garbagehigh.setForeground(new java.awt.Color(153, 0, 0));
        garbagehigh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sensorid", "Zipcode", "Garbage level"
            }
        ));
        jScrollPane2.setViewportView(garbagehigh);

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Garbege above trashold value");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Send request to solution department");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 204));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Bar Graph Representation");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 0, 204));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Line Graph Representation");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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
        jLabel2.setText("Garbage Sensors above Trashold");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(backJButton)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton2)
                .addGap(31, 31, 31)
                .addComponent(backJButton)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ArrayList<GarbageSensor> garbageSensorList = new ArrayList<GarbageSensor>();

        for(Network n: business.getNetworkList())
        {
            for(Enterprise enterprise : n.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
            {
            if(org instanceof EnvironmentSensorOrganization)
            {
                SensorDirectory sd;
                sd = ((EnvironmentSensorOrganization) org).getSensorDirectory();
                
                for(Sensor s : sd.getSensorList())
                {
                    if(s instanceof GarbageSensor)
                    {
                        GarbageSensor a = (GarbageSensor)s;
                        garbageSensorList.add(a);
                    }
                }
            }

            }
        }   }
            
            DefaultTableModel model = (DefaultTableModel) garbagehigh.getModel();
        model.setRowCount(0);
        
        for(GarbageSensor nps : garbageSensorList)
            if(nps.getCurrentlevel()>200)
                {
                Object[] row = new Object[3];
                row[0] = nps;
                row[1] = nps.getZipcode();
                row[2] = nps.getCurrentlevel();
                model.addRow(row);
                }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int row = garbagehigh.getSelectedRow();
         if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        //AirPollutionSensor airPollutionSensor = (AirPollutionSensor)SensorReadingsjTable.getValueAt(row, 0);

        Sensor garbageSensor = (Sensor) garbagehigh.getValueAt(row, 0);

        GarbageSensor garbagealertSensor = (GarbageSensor) garbageSensor;
        GarbageManagementWorkRequest request = new GarbageManagementWorkRequest();
        request.setGarbagesensor(garbagealertSensor);
        request.setSender(userAccount);
        request.setStatus("Sent");
        request.setMessage("Garbage bins are filled ");

        Organization orgn = null;
        Organization orgn1 = null;
        for(Network n: business.getNetworkList())
        {
            for(Enterprise enterprise : n.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
                {
                    //System.out.println(org.getName());
                    if (org instanceof GarbageManagementOrganization){
                        orgn = org;
                        break;
                    }

                }
                for(Organization org1 : enterprise.getOrganizationDirectory().getOrganizationList())
                {
                    if(org1 instanceof EnvironmentSensorOrganization){
                        orgn1 = org1;
                        break;
                    }
                }

            } }
            if (orgn!=null){
            
            ArrayList<Integer> sensorIDsArray = new ArrayList<Integer>();
            boolean workRequestAlreadyPresent = false;
                    
            if(orgn.getWorkQueue().getWorkRequestList().isEmpty())
            {
                orgn.getWorkQueue().getWorkRequestList().add(request);
                userAccount.getWorkQueue().getWorkRequestList().add(request);
                JOptionPane.showMessageDialog(null, "Request sent to Garbage management Department successfully");
            }
            else
            {
            for(WorkRequest request1 : orgn.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof GarbageManagementWorkRequest)
                {
                    GarbageManagementWorkRequest req = (GarbageManagementWorkRequest) request1; 
                    sensorIDsArray.add(req.getGarbagesensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(request.getGarbagesensor().getSensorId() == sensorIDsArray.get(i))
                        {
                            workRequestAlreadyPresent = true;
                        }
                    }
                }
            }
                    if(workRequestAlreadyPresent)   
                    {
                        JOptionPane.showMessageDialog(null, "Request has already been sent about this sensor to the Garbage management Department");
                    }
                    else
                    {
                        orgn.getWorkQueue().getWorkRequestList().add(request);
                        userAccount.getWorkQueue().getWorkRequestList().add(request);
                        JOptionPane.showMessageDialog(null, "Request sent to Garbage management Department successfully");
                    }
                }
            }

        if (orgn1!=null){
            ArrayList<Integer> sensorIDsArray = new ArrayList<Integer>();
            boolean workRequestAlreadyPresent = false;
            if(orgn1.getWorkQueue().getWorkRequestList().isEmpty())
            {
                orgn1.getWorkQueue().getWorkRequestList().add(request);
                userAccount.getWorkQueue().getWorkRequestList().add(request);
            }
            else
            {
            for(WorkRequest request1 : orgn1.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof GarbageManagementWorkRequest)
                {
                    GarbageManagementWorkRequest req = (GarbageManagementWorkRequest) request1; 
                    sensorIDsArray.add(req.getGarbagesensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(request.getGarbagesensor().getSensorId() == sensorIDsArray.get(i))
                        {
                            workRequestAlreadyPresent = true;
                        }
                    }
                }
            }
                    if(!(workRequestAlreadyPresent))                    
                    {
                        orgn1.getWorkQueue().getWorkRequestList().add(request);
                        userAccount.getWorkQueue().getWorkRequestList().add(request);
                    }
                }
        }
         }
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();

        for(Organization o : organizationDirectory.getOrganizationList())
        {
            if (o instanceof EnvironmentSensorOrganization){
                EnvironmentSensorOrganization eo = (EnvironmentSensorOrganization)o;
                SensorDirectory sd = eo.getSensorDirectory();
                for (Map.Entry<String, Float> entry : sd.getGarbageManagementSensorValues().entrySet()) {
                    dataset.setValue(entry.getValue(), "Readings", entry.getKey());
                }
            }
        }

        double d =9.0;
        JFreeChart chart=ChartFactory.createBarChart("Garbage Management Sensor Readings", "Zip Codes", "Garbage Level", dataset,PlotOrientation.VERTICAL,true,true,false);
        chart.setBackgroundPaint(Color.white);
        // Set the background color of the chart
        chart.getTitle().setPaint(Color.DARK_GRAY);
        chart.setBorderVisible(true);
        // Adjust the color of the title
        CategoryPlot plot = chart.getCategoryPlot();
        plot.getRangeAxis().setLowerBound(d);
        // Get the Plot object for a bar graph
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinePaint(Color.BLACK);
        CategoryItemRenderer renderer = plot.getRenderer();
        //renderer.setSeriesPaint(0, Color.decode("#00008B"));
        renderer.setSeriesPaint(0, Color.decode("#2F4F4F"));

        ChartFrame frame=new ChartFrame("Bar Chart for Sensors",chart);
        frame.setVisible(true);
        frame.setSize(650,550);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();

        for(Organization o : organizationDirectory.getOrganizationList())
        {
            if (o instanceof EnvironmentSensorOrganization){
                EnvironmentSensorOrganization eo = (EnvironmentSensorOrganization)o;
                SensorDirectory sd = eo.getSensorDirectory();
                for (Map.Entry<String, Float> entry : sd.getGarbageManagementSensorValues().entrySet()) {
                    dataset.setValue(entry.getValue(), "Readings", entry.getKey());
                }
            }
        }

        double d =9.0;
        JFreeChart chart=ChartFactory.createLineChart("Garbage Management Sensor Readings", "Zip Codes", "Garbage Level", dataset,PlotOrientation.VERTICAL,true,true,false);
        chart.setBackgroundPaint(Color.white);
        // Set the background color of the chart
        chart.getTitle().setPaint(Color.DARK_GRAY);
        chart.setBorderVisible(true);
        // Adjust the color of the title
        CategoryPlot plot = chart.getCategoryPlot();
        plot.getRangeAxis().setLowerBound(d);
        // Get the Plot object for a bar graph
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinePaint(Color.BLACK);
        CategoryItemRenderer renderer = plot.getRenderer();
        //renderer.setSeriesPaint(0, Color.decode("#00008B"));
        renderer.setSeriesPaint(0, Color.decode("#B8860B"));
        ChartFrame frame=new ChartFrame("Line Chart for Sensors",chart);
        frame.setVisible(true);
        frame.setSize(650,550);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        //SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTable garbagehigh;
    private javax.swing.JTable garbagereading;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
