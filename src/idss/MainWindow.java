/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrew
 */
public class MainWindow extends javax.swing.JFrame {

    MapInfo map;
    
    //Timer timer = new Timer();
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {    
        /*
        Crossroad3 cr1 = new Crossroad3(250, 100);
        Crossroad3 cr2 = new Crossroad3(50, 200);
        Crossroad3 cr3 = new Crossroad3(100, 250);
        JunctionPoint jp1 = new JunctionPoint(200, 50);
        JunctionPoint jp2 = new JunctionPoint(250,250);
        EndPoint ep = new EndPoint(100, 300);
        points.add(cr1);
        points.add(cr2);
        points.add(cr3);
        points.add(jp1);
        points.add(jp2);
        points.add(ep);
        Road r = new Road(cr1, cr2, true, 2, 1);
        cr1.setR2(r);
        cr2.setR2(r);
        roads.add(r);
        r = new Road(cr1, jp1, true, 2, 1);
        cr1.setR3(r);
        jp1.setR1(r);
        roads.add(r);
        r = new Road(cr1, jp2, true, 2, 1);
        cr1.setR1(r);
        jp2.setR1(r);
        roads.add(r);
        r = new Road(cr2, jp1, true, 2, 1);
        cr2.setR1(r);
        jp1.setR2(r);
        roads.add(r);
        r = new Road(cr2, cr3, true, 2, 1);
        cr2.setR3(r);
        cr3.setR3(r);
        roads.add(r);
        r = new Road(jp2, cr3, true, 2, 1);
        jp2.setR2(r);
        cr3.setR1(r);
        roads.add(r);
        r = new Road(ep, cr3, true, 2, 1);
        ep.setR1(r);
        cr3.setR2(r);
        roads.add(r);
        */

        initComponents();
        
        map = new MapInfo();
        mapPanel.setMapInfo(map);
        /*try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/idss", "idss", "idss");
            map.loadFromDB(conn);
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*Point p1 = new Point(250, 100);
        Point p2 = new Point(50, 200);
        Point p3 = new Point(100, 250);
        Point p4 = new Point(200, 50);
        Point p5 = new Point(250, 250);
        Point p6 = new Point(100, 300);
        map.points.add(p1);
        map.points.add(p2);
        map.points.add(p3);
        map.points.add(p4);
        map.points.add(p5);
        map.points.add(p6);
        map.roads.add(new Road(p1, p2, true, 2, 1));
        map.roads.add(new Road(p1, p4, true, 2, 1));
        map.roads.add(new Road(p1, p5, true, 2, 1));
        map.roads.add(new Road(p2, p4, true, 2, 1));
        map.roads.add(new Road(p2, p3, true, 2, 1));
        map.roads.add(new Road(p5, p3, true, 2, 1));
        map.roads.add(new Road(p6, p3, true, 2, 1));
        
        Car car = new Car();
        car.setMaxSpeed(80);
        
        ArrayList<MapObject> path = map.findBestRoute(p1, p6, null, car);
        for (MapObject mo : path) {
            mo.setSelected(true);
        }
        map.path = path;*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mapPanel = new idss.MapPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(mapPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 370));

        jButton1.setText("Calculate route \\w best dist");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 6, 1));

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(1, 1, 6, 1));

        jButton2.setText("Calculate route \\w best time");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 240, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (map.path != null)
        for (MapObject mo : map.path) {
            mo.setSelected(0);
        }
        
        Car car = new Car();
        car.setMaxSpeed(22.22); //m/s = 80 km/h
        
        int from = (int)jSpinner1.getValue()-1;
        int to = (int)jSpinner2.getValue()-1;
        
        ArrayList<MapObject> path = map.findRouteWithBestDist(map.points.get(from), map.points.get(to));
        for (MapObject mo : path) {
            mo.setSelected(1);
        }
        map.path = path;
        
        repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (map.path != null)
        for (MapObject mo : map.path) {
            mo.setSelected(0);
        }
        
        Car car = new Car();
        car.setMaxSpeed(22.22); //m/s = 80 km/h
        
        int from = (int)jSpinner1.getValue()-1;
        int to = (int)jSpinner2.getValue()-1;
        
        ArrayList<MapObject> path = map.findRouteWithBestTime(map.points.get(from), 
                map.points.get(to), null, car);
        for (MapObject mo : path) {
            mo.setSelected(2);
        }
        map.path = path;
        
        repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private idss.MapPanel mapPanel;
    // End of variables declaration//GEN-END:variables

}
