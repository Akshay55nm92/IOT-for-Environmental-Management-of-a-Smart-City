/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.EnvironmentSensorEnterprise.NoisePollutionManagement;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.EnvironmentSensorOrganization;
import Business.Organization.NoisePollutionSolutionOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Sensors.AirPollutionSensor;
import Business.Sensors.NoisePollutionSensor;
import Business.Sensors.Sensor;
import Business.Sensors.SensorDirectory;
import Business.UserAccount.UserAccount;
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
 * @author Akshay
 */
public class SendRequestToNoisePollutionSolutionDepartmentJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private OrganizationDirectory organizationDirectory;
    /**
     * Creates new form SendRequestToNoisePollutionSolutionDepartmentJPanel
     */
    public SendRequestToNoisePollutionSolutionDepartmentJPanel(JPanel userProcessContainer, UserAccount userAccount, EcoSystem business, OrganizationDirectory organizationDirectory) throws IOException {
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
                                        if(sd.NoisePollutionSensorExists(valuesOfArray2[1]))
                                        {
                                            break;
                                        }
                                        else
                                        {
                                        Sensor s = sd.createSensor(Sensor.SensorType.NoisePollutionSensor);
                                        String valuesOfArray[] = dataCsvArr.get(i);
                                        s.setLocation(valuesOfArray[0]);
                                        s.setZipcode(valuesOfArray[1]);
                                        s.setLatitude(valuesOfArray[2]);
                                        s.setLongitude(valuesOfArray[3]);
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
        ArrayList<NoisePollutionSensor> tempNoisePollutionSensorList = new ArrayList<NoisePollutionSensor>();

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
                    if(s instanceof NoisePollutionSensor)
                    {
                        NoisePollutionSensor a = (NoisePollutionSensor)s;
                        tempNoisePollutionSensorList.add(a);
                    }
                }
            }

            }
        }   }
            
            DefaultTableModel model = (DefaultTableModel) SensorReadingsjTable.getModel();
        model.setRowCount(0);
        
        for(NoisePollutionSensor nps : tempNoisePollutionSensorList)
                {
                Object[] row = new Object[3];
                row[0] = nps;
                row[1] = nps.getZipcode();
                row[2] = nps.getNoiseLevelInDecibel();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SensorReadingsjTable = new javax.swing.JTable();
        NoisePollutionSensorReadingjButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        HighlyPollutedAreasjTable = new javax.swing.JTable();
        SendRequestjButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Noise Pollution Sensor Readings");

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

        NoisePollutionSensorReadingjButton.setBackground(new java.awt.Color(0, 0, 204));
        NoisePollutionSensorReadingjButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        NoisePollutionSensorReadingjButton.setForeground(new java.awt.Color(255, 255, 255));
        NoisePollutionSensorReadingjButton.setText("Get Highly Noisy Area's Sensor readings");
        NoisePollutionSensorReadingjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoisePollutionSensorReadingjButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Polluted Sensors with Zipcode");

        HighlyPollutedAreasjTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HighlyPollutedAreasjTable.setForeground(new java.awt.Color(153, 0, 0));
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

        SendRequestjButton.setBackground(new java.awt.Color(0, 0, 204));
        SendRequestjButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SendRequestjButton.setForeground(new java.awt.Color(255, 255, 255));
        SendRequestjButton.setText("Send Request to Noise Pollution Solution Department");
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(NoisePollutionSensorReadingjButton)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backJButton)
                            .addComponent(SendRequestjButton))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addContainerGap(442, Short.MAX_VALUE))))
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
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addComponent(NoisePollutionSensorReadingjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(SendRequestjButton)
                .addGap(30, 30, 30)
                .addComponent(backJButton)
                .addGap(79, 79, 79))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void NoisePollutionSensorReadingjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoisePollutionSensorReadingjButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<NoisePollutionSensor> tempNoisePollutionSensorList = new ArrayList<NoisePollutionSensor>();

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
                            if(s instanceof NoisePollutionSensor)
                            {
                                NoisePollutionSensor a = (NoisePollutionSensor)s;
                                tempNoisePollutionSensorList.add(a);
                            }
                        }
                    }

                }
            }   }

            DefaultTableModel model = (DefaultTableModel) HighlyPollutedAreasjTable.getModel();
            model.setRowCount(0);

            for(NoisePollutionSensor nps : tempNoisePollutionSensorList)
            {
                if(nps.getNoiseLevelInDecibel()>90)
                {
                    Object[] row = new Object[4];
                    row[0] = nps;
                    row[1] = nps.getZipcode();
                    row[2] = nps.getNoiseLevelInDecibel();
                    model.addRow(row);
                }
            }
    }//GEN-LAST:event_NoisePollutionSensorReadingjButtonActionPerformed

    private void SendRequestjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendRequestjButtonActionPerformed
        // TODO add your handling code here:

        int row = HighlyPollutedAreasjTable.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        //AirPollutionSensor airPollutionSensor = (AirPollutionSensor)SensorReadingsjTable.getValueAt(row, 0);

        Sensor noisePollutionSenso = (Sensor)HighlyPollutedAreasjTable.getValueAt(row, 0);

        NoisePollutionSensor noisePollutionSensor = (NoisePollutionSensor) noisePollutionSenso;
        NoisePollutionSolutionWorkRequest request = new NoisePollutionSolutionWorkRequest();
        request.setNoisePollutionSensor(noisePollutionSensor);
        request.setSender(userAccount);
        request.setStatus("Sent");
        request.setMessage("Please look at the reasons for such loud noise in the locality");

        Organization orgn = null;
        Organization orgn1 = null;
        for(Network n: business.getNetworkList())
        {
            for(Enterprise enterprise : n.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
                {
                    //System.out.println(org.getName());
                    if (org instanceof NoisePollutionSolutionOrganization){
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
            if (orgn!=null)
            {
            ArrayList<Integer> sensorIDsArray = new ArrayList<Integer>();
            boolean workRequestAlreadyPresent = false;
                    
            if(orgn.getWorkQueue().getWorkRequestList().isEmpty())
            {
                orgn.getWorkQueue().getWorkRequestList().add(request);
                userAccount.getWorkQueue().getWorkRequestList().add(request);
                JOptionPane.showMessageDialog(null, "Request sent to Noise Pollution Solution Department successfully");
            }
            else
            {
            for(WorkRequest request1 : orgn.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof NoisePollutionSolutionWorkRequest)
                {
                    NoisePollutionSolutionWorkRequest req = (NoisePollutionSolutionWorkRequest) request1; 
                    sensorIDsArray.add(req.getNoisePollutionSensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(request.getNoisePollutionSensor().getSensorId() == sensorIDsArray.get(i))
                        {
                            workRequestAlreadyPresent = true;
                        }
                    }
                }
            }
                    if(workRequestAlreadyPresent)   
                    {
                        JOptionPane.showMessageDialog(null, "Request has already been sent about this sensor to the Noise Pollution Solution Department");
                    }
                    else
                    {
                        orgn.getWorkQueue().getWorkRequestList().add(request);
                        userAccount.getWorkQueue().getWorkRequestList().add(request);
                        JOptionPane.showMessageDialog(null, "Request sent to Noise Pollution Solution Department successfully");
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
                if(request1 instanceof NoisePollutionSolutionWorkRequest)
                {
                    NoisePollutionSolutionWorkRequest req = (NoisePollutionSolutionWorkRequest) request1; 
                    sensorIDsArray.add(req.getNoisePollutionSensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(request.getNoisePollutionSensor().getSensorId() == sensorIDsArray.get(i))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();

        for(Organization o : organizationDirectory.getOrganizationList())
        {
            if (o instanceof EnvironmentSensorOrganization){
                EnvironmentSensorOrganization eo = (EnvironmentSensorOrganization)o;
                SensorDirectory sd = eo.getSensorDirectory();
                for (Map.Entry<String, Float> entry : sd.getNoisePollutionSensorValues().entrySet()) {
                    dataset.setValue(entry.getValue(), "Readings", entry.getKey());
                }
            }
        }

        double d =9.0;
        JFreeChart chart=ChartFactory.createBarChart("Noise Pollution Sensor Readings", "Zip Codes", "Noise in Decibels", dataset,PlotOrientation.VERTICAL,true,true,false);
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();

        for(Organization o : organizationDirectory.getOrganizationList())
        {
            if (o instanceof EnvironmentSensorOrganization){
                EnvironmentSensorOrganization eo = (EnvironmentSensorOrganization)o;
                SensorDirectory sd = eo.getSensorDirectory();
                for (Map.Entry<String, Float> entry : sd.getNoisePollutionSensorValues().entrySet()) {
                    dataset.setValue(entry.getValue(), "Readings", entry.getKey());
                }
            }
        }

        double d =9.0;
        JFreeChart chart=ChartFactory.createLineChart("Noise Pollution Sensor Readings", "Zip Codes", "Noise in Decibels", dataset,PlotOrientation.VERTICAL,true,true,false);
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
        ChartFrame frame=new ChartFrame("Bar Chart for Sensors",chart);
        frame.setVisible(true);
        frame.setSize(650,550);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable HighlyPollutedAreasjTable;
    private javax.swing.JButton NoisePollutionSensorReadingjButton;
    private javax.swing.JButton SendRequestjButton;
    private javax.swing.JTable SensorReadingsjTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
