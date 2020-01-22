/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EnvironmentSensorEnterprise.AirPollutionManagement;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.AirPollutionSolutionOrganization;
import Business.Organization.EnvironmentSensorOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Sensors.AirPollutionSensor;
import Business.Sensors.Sensor;
import Business.Sensors.SensorDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AirPollutionSolutionWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.IntervalXYDataset;

/**
 *
 * @author Akshay
 */
public class SendRequestToAirPollutionSolutionDepartment extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private OrganizationDirectory organizationDirectory;
    /**
     * Creates new form SendRequestToAirPollutionSolutionDepartment
     */
    public SendRequestToAirPollutionSolutionDepartment(JPanel userProcessContainer, UserAccount userAccount, EcoSystem business, OrganizationDirectory organizationDirectory) throws IOException {
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
        ArrayList<Sensor> sensorList = null;
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
                                        if(sd.AirPollutionSensorExists(valuesOfArray2[1]))
                                        {
                                            break;
                                        }
                                        else
                                        {
                                        Sensor s = sd.createSensor(Sensor.SensorType.AirPollutionSensor);
                                        AirPollutionSensor aps = (AirPollutionSensor) s;
                                        String valuesOfArray[] = dataCsvArr.get(i);
                                        aps.setLocation(valuesOfArray[0]);
                                        aps.setZipcode(valuesOfArray[1]);
                                        aps.setLatitude(valuesOfArray[2]);
                                        aps.setLongitude(valuesOfArray[3]);
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
        ArrayList<AirPollutionSensor> tempAirPollutionSensorList = new ArrayList<AirPollutionSensor>();

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
                    if(s instanceof AirPollutionSensor)
                    {
                        AirPollutionSensor a = (AirPollutionSensor)s;
                        tempAirPollutionSensorList.add(a);
                    }
                }
            }

            }
        }   }
            
            DefaultTableModel model = (DefaultTableModel) SensorReadingsjTable.getModel();
        model.setRowCount(0);
        
        for(AirPollutionSensor aps : tempAirPollutionSensorList)
                {
                Object[] row = new Object[3];
                row[0] = aps;
                row[1] = aps.getZipcode();
                row[2] = aps.getAirQualityIndex();
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
        SensorReadingsjTable = new javax.swing.JTable();
        SendRequestjButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        HighlyPollutedAreasjTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SensorInfoToEnterprisejButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        SensorReadingsjTable.setBackground(new java.awt.Color(234, 234, 249));
        SensorReadingsjTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SensorReadingsjTable.setForeground(new java.awt.Color(0, 0, 51));
        SensorReadingsjTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(SensorReadingsjTable);

        SendRequestjButton.setBackground(new java.awt.Color(0, 0, 204));
        SendRequestjButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SendRequestjButton.setForeground(new java.awt.Color(255, 255, 255));
        SendRequestjButton.setText("Send Request to Air Pollution Solution Department");
        SendRequestjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendRequestjButtonActionPerformed(evt);
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

        HighlyPollutedAreasjTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HighlyPollutedAreasjTable.setForeground(new java.awt.Color(204, 0, 0));
        HighlyPollutedAreasjTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(HighlyPollutedAreasjTable);
        if (HighlyPollutedAreasjTable.getColumnModel().getColumnCount() > 0) {
            HighlyPollutedAreasjTable.getColumnModel().getColumn(0).setResizable(false);
            HighlyPollutedAreasjTable.getColumnModel().getColumn(1).setResizable(false);
            HighlyPollutedAreasjTable.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Get highly Air polluted Areas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Air Pollution Sensor Readings");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Polluted Sensors with Zipcode");

        SensorInfoToEnterprisejButton.setBackground(new java.awt.Color(0, 0, 204));
        SensorInfoToEnterprisejButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SensorInfoToEnterprisejButton.setForeground(new java.awt.Color(255, 255, 255));
        SensorInfoToEnterprisejButton.setText("Send Sensor Information to Government");
        SensorInfoToEnterprisejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SensorInfoToEnterprisejButtonActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Bar Graph Representation");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 204));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Line Graph Representation");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(546, 546, 546)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 1013, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backJButton)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(SensorInfoToEnterprisejButton)
                    .addComponent(SendRequestjButton)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 840, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(32, 32, 32)
                        .addComponent(jButton3)))
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(SendRequestjButton)
                .addGap(28, 28, 28)
                .addComponent(SensorInfoToEnterprisejButton)
                .addGap(47, 47, 47)
                .addComponent(backJButton)
                .addGap(44, 44, 44))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SendRequestjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendRequestjButtonActionPerformed
        // TODO add your handling code here:
        int row = HighlyPollutedAreasjTable.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        //AirPollutionSensor airPollutionSensor = (AirPollutionSensor)SensorReadingsjTable.getValueAt(row, 0);
        
        Sensor airPollutionSenso = (Sensor)HighlyPollutedAreasjTable.getValueAt(row, 0);
        
        AirPollutionSensor airPollutionSensor = (AirPollutionSensor) airPollutionSenso;
        AirPollutionSolutionWorkRequest request = new AirPollutionSolutionWorkRequest();
        request.setAirPollutionSensor(airPollutionSensor);
        request.setSender(userAccount);
        request.setStatus("Sent");
        request.setMessage("Air Pollution is detriorating please have a look");
        
        Organization orgn = null;
        Organization orgn1 = null;
        for(Network n: business.getNetworkList())
        {
            for(Enterprise enterprise : n.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
                {
                    if (org instanceof AirPollutionSolutionOrganization){
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
                JOptionPane.showMessageDialog(null, "Request sent to Air Pollution Solution Department successfully");
            }
            else
            {
            for(WorkRequest request1 : orgn.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof AirPollutionSolutionWorkRequest)
                {
                    AirPollutionSolutionWorkRequest req = (AirPollutionSolutionWorkRequest) request1; 
                    sensorIDsArray.add(req.getAirPollutionSensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(request.getAirPollutionSensor().getSensorId() == sensorIDsArray.get(i))
                        {
                            workRequestAlreadyPresent = true;
                        }
                    }
                }
            }
                    if(workRequestAlreadyPresent)   
                    {
                        JOptionPane.showMessageDialog(null, "Request has already been sent about this sensor to the Air Pollution Solution Department");
                    }
                    else
                    {
                        orgn.getWorkQueue().getWorkRequestList().add(request);
                        userAccount.getWorkQueue().getWorkRequestList().add(request);
                        JOptionPane.showMessageDialog(null, "Request sent to Air Pollution Solution Department successfully");
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
                if(request1 instanceof AirPollutionSolutionWorkRequest)
                {
                    AirPollutionSolutionWorkRequest req = (AirPollutionSolutionWorkRequest) request1; 
                    sensorIDsArray.add(req.getAirPollutionSensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(request.getAirPollutionSensor().getSensorId() == sensorIDsArray.get(i))
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
    }//GEN-LAST:event_SendRequestjButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        //SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ArrayList<AirPollutionSensor> tempAirPollutionSensorList = new ArrayList<AirPollutionSensor>();

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
                    if(s instanceof AirPollutionSensor)
                    {
                        AirPollutionSensor a = (AirPollutionSensor)s;
                        tempAirPollutionSensorList.add(a);
                    }
                }
            }

            }
        }   }
            
            DefaultTableModel model = (DefaultTableModel) HighlyPollutedAreasjTable.getModel();
        model.setRowCount(0);
        
        for(AirPollutionSensor aps : tempAirPollutionSensorList)
                {
                    if(aps.getAirQualityIndex()>150)
                    {
                        Object[] row = new Object[4];
                        row[0] = aps;
                        row[1] = aps.getZipcode();
                        row[2] = aps.getAirQualityIndex();
                        model.addRow(row);
                    }
                }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SensorInfoToEnterprisejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SensorInfoToEnterprisejButtonActionPerformed
        // TODO add your handling code here:
        SendRequestToGovernmentJPanel sendRequestToGovernmentJPanel = new SendRequestToGovernmentJPanel(userProcessContainer, userAccount, business, organizationDirectory);
        userProcessContainer.add("sendRequestToGovernmentJPanel", sendRequestToGovernmentJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_SensorInfoToEnterprisejButtonActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       DefaultCategoryDataset dataset=new DefaultCategoryDataset();
          
       for(Organization o : organizationDirectory.getOrganizationList())
          {
            if (o instanceof EnvironmentSensorOrganization){
               EnvironmentSensorOrganization eo = (EnvironmentSensorOrganization)o;
               SensorDirectory sd = eo.getSensorDirectory();
                    for (Map.Entry<String, Float> entry : sd.getAirPollutionSensorValues().entrySet()) {
                                dataset.setValue(entry.getValue(), "Readings", entry.getKey());
                    }
            }
          }
       
       double d =9.0;
//        final JFreeChart chart =
//            ChartFactory.createBarChart(
//                    "Chart Title",
//                    "Zipcodes",
//                    "Sensor Reading",
//                    dataset,
//                    PlotOrientation.VERTICAL,
//                    true,
//                    true,
//                    false);
        //JFreeChart chart=ChartFactory.createBarChart3D("Sensor Readings", "Zip Code", "Readings", dataset,PlotOrientation.VERTICAL,true,true,false);
        JFreeChart chart=ChartFactory.createBarChart("Sensor Readings", "Zip Code", "Readings", dataset,PlotOrientation.VERTICAL,true,true,false);
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
//        JFreeChart chart=ChartFactory.createBarChart3D("Sensor Readings", "Zip Code", "Readings", dataset,PlotOrientation.VERTICAL,false,true,false);
//       JFreeChart chart=ChartFactory.createBarChart("Sensor Readings", "Zip Code", "Readings", dataset);
//       chart.setBackgroundPaint(Color.BLACK);
//       chart.getTitle().setPaint(Color. white);
//       
//       CategoryPlot p=chart.getCategoryPlot();
//       p.setRangeGridlinePaint(Color.BLACK);
       ChartFrame frame=new ChartFrame("Bar Chart for Sensors",chart);
       frame.setVisible(true);
       frame.setSize(650,550);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
          
       for(Organization o : organizationDirectory.getOrganizationList())
          {
            if (o instanceof EnvironmentSensorOrganization){
               EnvironmentSensorOrganization eo = (EnvironmentSensorOrganization)o;
               SensorDirectory sd = eo.getSensorDirectory();
                    for (Map.Entry<String, Float> entry : sd.getAirPollutionSensorValues().entrySet()) {
                                dataset.setValue(entry.getValue(), "Readings", entry.getKey());
                    }
            }
          }
       
       double d =9.0;
//        final JFreeChart chart =
//            ChartFactory.createBarChart(
//                    "Chart Title",
//                    "Zipcodes",
//                    "Sensor Reading",
//                    dataset,
//                    PlotOrientation.VERTICAL,
//                    true,
//                    true,
//                    false);
        //JFreeChart chart=ChartFactory.createBarChart3D("Sensor Readings", "Zip Code", "Readings", dataset,PlotOrientation.VERTICAL,true,true,false);
        //JFreeChart chart=ChartFactory.createBarChart("Sensor Readings", "Zip Code", "Readings", dataset,PlotOrientation.VERTICAL,true,true,false);
        JFreeChart chart=ChartFactory.createLineChart("Sensor Readings", "Zip Code", "Readings", dataset,PlotOrientation.VERTICAL,true,true,false);
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
//        JFreeChart chart=ChartFactory.createBarChart3D("Sensor Readings", "Zip Code", "Readings", dataset,PlotOrientation.VERTICAL,false,true,false);
//       JFreeChart chart=ChartFactory.createBarChart("Sensor Readings", "Zip Code", "Readings", dataset);
//       chart.setBackgroundPaint(Color.BLACK);
//       chart.getTitle().setPaint(Color. white);
//       
//       CategoryPlot p=chart.getCategoryPlot();
//       p.setRangeGridlinePaint(Color.BLACK);
       ChartFrame frame=new ChartFrame("Bar Chart for Sensors",chart);
       frame.setVisible(true);
       frame.setSize(650,550);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable HighlyPollutedAreasjTable;
    private javax.swing.JButton SendRequestjButton;
    private javax.swing.JButton SensorInfoToEnterprisejButton;
    private javax.swing.JTable SensorReadingsjTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
