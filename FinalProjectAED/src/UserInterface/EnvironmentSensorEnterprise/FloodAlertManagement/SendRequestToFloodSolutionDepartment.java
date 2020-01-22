/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EnvironmentSensorEnterprise.FloodAlertManagement;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.EnvironmentSensorOrganization;
import Business.Organization.FloodAlertManagementOrganization;
import Business.Organization.GovernmentOrganization;
import Business.Organization.NoisePollutionSolutionOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Sensors.AirPollutionSensor;
import Business.Sensors.FloodAlertSensor;
import Business.Sensors.NoisePollutionSensor;
import Business.Sensors.Sensor;
import Business.Sensors.SensorDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FloodAlertWorkRequest;
import Business.WorkQueue.GovernmentWorkRequest;
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
public class SendRequestToFloodSolutionDepartment extends javax.swing.JPanel {
       private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount account;
    private OrganizationDirectory organizationDirectory;
    private ArrayList<FloodAlertSensor> floodAlertSensorList = new ArrayList<FloodAlertSensor>();
    /**
     * Creates new form sendrequestforsolution
     */
   

    SendRequestToFloodSolutionDepartment(JPanel userProcessContainer, UserAccount account, EcoSystem business, OrganizationDirectory organizationDirectory) throws IOException {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.account = account;
        this.organizationDirectory = organizationDirectory;
        readFromCSV();
        populateTable();
        
        SensorReadingsjTable3.setVisible(false);
        jButton3.setVisible(false);
        SensorInfoToEnterprisejButton.setVisible(false);
    }
    
    public void readFromCSV() throws IOException
    {
        //String csvFile = "C:\\Users\\Akshay\\Desktop\\Flood.csv";
        
        String csvFile = "src\\\\CSV_Files\\\\AirPollution.csv";
        
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
                                        if(sd.FloodAlertSensorSensorExists(valuesOfArray2[1]))
                                        {
                                            break;
                                        }
                                        else
                                        {
                                        Sensor s = sd.createSensor(Sensor.SensorType.FloodAlertSensor);
                                        FloodAlertSensor fas = (FloodAlertSensor) s;
                                        String valuesOfArray[] = dataCsvArr.get(i);
                                        fas.setLocation(valuesOfArray[0]);
                                        fas.setZipcode(valuesOfArray[1]);
                                        fas.setLatitude(valuesOfArray[2]);
                                        fas.setLongitude(valuesOfArray[3]);
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
    
    public void populateTable(){
     ArrayList<FloodAlertSensor> floodalertlist = new ArrayList<FloodAlertSensor>();
          for (Organization organization : organizationDirectory.getOrganizationList()) {
            if(organization instanceof EnvironmentSensorOrganization)
            {
                SensorDirectory sd;
                sd = ((EnvironmentSensorOrganization) organization).getSensorDirectory();
                
                for(Sensor s : sd.getSensorList())
                {
                    if(s instanceof FloodAlertSensor)
                    {
                        FloodAlertSensor a = (FloodAlertSensor)s;
                        floodalertlist.add(a);
                    }
                }
            }
        }
         
           DefaultTableModel model = (DefaultTableModel) noisesensortable1.getModel();
        model.setRowCount(0);
        
        for(FloodAlertSensor  fas :floodalertlist )
                {
                Object[] row = new Object[4];
                row[0] = fas.getSensorId();
                row[1] = fas.getZipcode();
                row[2] = fas.getCurrentlevel();
                model.addRow(row);
                }
         
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        noisesensortable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        SensorReadingsjTable3 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        SensorInfoToEnterprisejButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        FloodAlertMessage = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        noisesensortable1.setBackground(new java.awt.Color(234, 234, 249));
        noisesensortable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        noisesensortable1.setForeground(new java.awt.Color(0, 0, 51));
        noisesensortable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sensor id", "Zipcode", "Current Water Level"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(noisesensortable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Flood Alert Sensor Readings");

        jButton2.setBackground(new java.awt.Color(0, 0, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Check Collective Sensor Reading");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Abnormal Sensor Readings");

        SensorReadingsjTable3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SensorReadingsjTable3.setForeground(new java.awt.Color(153, 0, 0));
        SensorReadingsjTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sensor Id", "Zipcode", "Pollution reading"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SensorReadingsjTable3.setEnabled(false);
        SensorReadingsjTable3.setRowSelectionAllowed(false);
        jScrollPane4.setViewportView(SensorReadingsjTable3);

        jButton3.setBackground(new java.awt.Color(0, 0, 204));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Send request to solution department");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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

        SensorInfoToEnterprisejButton.setBackground(new java.awt.Color(0, 0, 204));
        SensorInfoToEnterprisejButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SensorInfoToEnterprisejButton.setForeground(new java.awt.Color(255, 255, 255));
        SensorInfoToEnterprisejButton.setText("Send Sensor Information to Government");
        SensorInfoToEnterprisejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SensorInfoToEnterprisejButtonActionPerformed(evt);
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

        FloodAlertMessage.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        FloodAlertMessage.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backJButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(FloodAlertMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton5)))
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SensorInfoToEnterprisejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 764, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(32, 32, 32)
                        .addComponent(jButton5)))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(FloodAlertMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton3)
                .addGap(29, 29, 29)
                .addComponent(SensorInfoToEnterprisejButton)
                .addGap(30, 30, 30)
                .addComponent(backJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       ArrayList<FloodAlertSensor> floodalertlist = new ArrayList<FloodAlertSensor>();
       
       int count = 0 ;
       
        for (Organization organization : organizationDirectory.getOrganizationList()) {
            if(organization instanceof EnvironmentSensorOrganization)
            {
                SensorDirectory sd;
                sd = ((EnvironmentSensorOrganization) organization).getSensorDirectory();

                for(Sensor s : sd.getSensorList())
                {
                    if(s instanceof FloodAlertSensor)
                    {
                        FloodAlertSensor a = (FloodAlertSensor)s;
                        floodalertlist.add(a);
                    }
                }
            }
        }
        
        for(int i=0; i<floodalertlist.size(); i++)
            System.out.println(floodalertlist.get(i).getZipcode()+"\n");
        DefaultTableModel model = (DefaultTableModel) SensorReadingsjTable3.getModel();
        model.setRowCount(0);

        for(FloodAlertSensor  fas :floodalertlist ){
        if(fas.getCurrentlevel()>200)
            {
                count++;
                Object[] row = new Object[4];
                row[0] = fas;
                row[1] = fas.getZipcode();
                row[2] = fas.getCurrentlevel();
                model.addRow(row);
            }
        }
        
            if(count>=2)
            {
                for(FloodAlertSensor fase : floodalertlist)
                {
                    floodAlertSensorList.add(fase);
                }
                FloodAlertMessage.setText("Areas Sorrounding the river are under high risk of being flooded due to rise in water lavels in the river");
                SensorReadingsjTable3.setVisible(true);
                jButton3.setVisible(true);
                SensorInfoToEnterprisejButton.setVisible(true);
            }
            
            else
            {
                SensorReadingsjTable3.setVisible(false);
                jButton3.setVisible(false);
                SensorInfoToEnterprisejButton.setVisible(false);
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
//         int row = SensorReadingsjTable3.getSelectedRow();
//         if(row <0){
//            JOptionPane.showMessageDialog(null, "No row selected");
//        }else{
//        //AirPollutionSensor airPollutionSensor = (AirPollutionSensor)SensorReadingsjTable.getValueAt(row, 0);
//
//        Sensor floodsensor = (Sensor) SensorReadingsjTable3.getValueAt(row, 0);
//
//        FloodAlertSensor floodalertSensor =  (FloodAlertSensor) floodsensor;
        FloodAlertWorkRequest request = new FloodAlertWorkRequest();
        request.setFloodalertsensors(floodAlertSensorList);
//        for(int i=0; i<floodAlertSensorList.size(); i++)
//            System.out.println(floodAlertSensorList.get(i).getZipcode()+"\n");
        request.setSender(account);
        request.setStatus("Sent");
        request.setMessage("Areas Sorrounding the River are on high risk of being flooded");

        Organization orgn = null;
        Organization orgn1 = null;
        for(Network n: business.getNetworkList())
        {
            for(Enterprise enterprise : n.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
                {
                    //System.out.println(org.getName());
                    if (org instanceof FloodAlertManagementOrganization){
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
                account.getWorkQueue().getWorkRequestList().add(request);
                JOptionPane.showMessageDialog(null, "Request sent to Flood Alert Solution Department successfully");
            }
            else
            {
            for(WorkRequest request1 : orgn.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof FloodAlertWorkRequest)
                {
                    FloodAlertWorkRequest req = (FloodAlertWorkRequest) request1; 
                    
                        if(request.getFloodalertsensors().equals(req.getFloodalertsensors()))
                        {
                            workRequestAlreadyPresent = true;
                        }

                }
            }
                    if(workRequestAlreadyPresent)   
                    {
                        JOptionPane.showMessageDialog(null, "Request has already been sent about this sensor to the Flood Alert Solution Department");
                    }
                    else
                    {
                        orgn.getWorkQueue().getWorkRequestList().add(request);
                        account.getWorkQueue().getWorkRequestList().add(request);
                        JOptionPane.showMessageDialog(null, "Request sent to Flood Alert Solution Department successfully");
                    }
                }
            }

            if (orgn1!=null)
            {
            ArrayList<Integer> sensorIDsArray = new ArrayList<Integer>();
            boolean workRequestAlreadyPresent = false;
            if(orgn1.getWorkQueue().getWorkRequestList().isEmpty())
            {
                orgn1.getWorkQueue().getWorkRequestList().add(request);
                account.getWorkQueue().getWorkRequestList().add(request);
            }
            else
            {
            for(WorkRequest request1 : orgn1.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof FloodAlertWorkRequest)
                {
                    FloodAlertWorkRequest req = (FloodAlertWorkRequest) request1; 
                    //sensorIDsArray.add(req.getFloodAlertSensor().getSensorId());
                        if(request.getFloodalertsensors().equals(req.getFloodalertsensors()))
                        {
                            workRequestAlreadyPresent = true;
                        }
                }
            }
                    if(!(workRequestAlreadyPresent))                    
                    {
                        orgn1.getWorkQueue().getWorkRequestList().add(request);
                        account.getWorkQueue().getWorkRequestList().add(request);
                    }
                }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();

        for(Organization o : organizationDirectory.getOrganizationList())
        {
            if (o instanceof EnvironmentSensorOrganization){
                EnvironmentSensorOrganization eo = (EnvironmentSensorOrganization)o;
                SensorDirectory sd = eo.getSensorDirectory();
                for (Map.Entry<String, Float> entry : sd.getFloodAlertSensorValues().entrySet()) {
                    dataset.setValue(entry.getValue(), "Readings", entry.getKey());
                }
            }
        }

        double d =9.0;
        JFreeChart chart=ChartFactory.createBarChart("Flood Alert Sensor Readings", "Zip Codes", "Water Level", dataset,PlotOrientation.VERTICAL,true,true,false);
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
                for (Map.Entry<String, Float> entry : sd.getFloodAlertSensorValues().entrySet()) {
                    dataset.setValue(entry.getValue(), "Readings", entry.getKey());
                }
            }
        }

        double d =9.0;
        JFreeChart chart=ChartFactory.createLineChart("Flood Alert Sensor Readings", "Zip Codes", "Water Level", dataset,PlotOrientation.VERTICAL,true,true,false);
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

    private void SensorInfoToEnterprisejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SensorInfoToEnterprisejButtonActionPerformed
        // TODO add your handling code here:
        
        GovernmentWorkRequest request = new GovernmentWorkRequest();
        request.setFloodAlertSensorList(floodAlertSensorList);

        request.setSender(account);
        request.setStatus("Sent");
        request.setFloodAlertMessage("Areas Sorrounding the River are on high risk of being flooded please inform Citizens to be careful");

        Organization orgn = null;
        for(Network n: business.getNetworkList())
        {
            for(Enterprise enterprise : n.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
                {
                    //System.out.println(org.getName());
                    if (org instanceof GovernmentOrganization)
                    {
                        orgn = org;
                        break;
                    }
                }
            } 
        }     
        
            if (orgn!=null)
            {            
            ArrayList<Integer> sensorIDsArray = new ArrayList<Integer>();
            boolean workRequestAlreadyPresent = false;
                    
                    orgn.getWorkQueue().getWorkRequestList().add(request);
                    account.getWorkQueue().getWorkRequestList().add(request);
                    JOptionPane.showMessageDialog(null, "Request sent to Government Organization successfully");
            }            
    }//GEN-LAST:event_SensorInfoToEnterprisejButtonActionPerformed

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
    private javax.swing.JLabel FloodAlertMessage;
    private javax.swing.JButton SensorInfoToEnterprisejButton;
    private javax.swing.JTable SensorReadingsjTable3;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable noisesensortable1;
    // End of variables declaration//GEN-END:variables
}
