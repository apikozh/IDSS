/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idss;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.event.MouseEvent;
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
    ArrayList<MapObject> routeWithBestTime = new ArrayList<>();
	ArrayList<MapObject> routeWithBestDist = new ArrayList<>();
	ArrayList<MapObject> routeWithBestFuelCons = new ArrayList<>();
    ArrayList<Point> selectedPoints = new ArrayList<>(); 
	Connection connection;
	ArrayList<Car> cars = new ArrayList<>();
	
    //Timer timer = new Timer();
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {    
        initComponents();
        
        Car car;
		
		car = new Car();
        car.setName("Car 1");
		car.setMaxSpeed(22.22); //m/s = 80 km/h
        car.setFuelCons(8/1000);
        car.setFuelConsLight(30 * car.getFuelCons());
		cars.add(car);
		
		car = new Car();
        car.setName("Car 2");
		car.setMaxSpeed(30.0); //m/s
        car.setFuelCons(10/1000);
        car.setFuelConsLight(30 * car.getFuelCons());
		cars.add(car);
		
		car = new Car();
        car.setName("Car 3");
		car.setMaxSpeed(18.0); //m/s
        car.setFuelCons(12/1000);
        car.setFuelConsLight(40 * car.getFuelCons());
		cars.add(car);
		
        map = new MapInfo();
        mapPanel.setMapInfo(map);

		try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/idss", "idss", "idss");
            map.loadFromDB(connection);
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

        horizontalScrollBar.setMaximum(mapPanel.getMaxScrollX());
        verticalScrollBar.setMaximum(mapPanel.getMaxScrollY());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane2 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        scrollPanel = new javax.swing.JPanel();
        mapPanel = new idss.MapPanel();
        horizontalScrollBar = new javax.swing.JScrollBar();
        verticalScrollBar = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        calcRoute = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        routeSelectList = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jScrollPane2.setMinimumSize(new java.awt.Dimension(23, 100));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(106, 100));

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setRows(5);
        textArea.setPreferredSize(new java.awt.Dimension(104, 150));
        textArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textAreaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(textArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jScrollPane2, gridBagConstraints);

        scrollPanel.setMinimumSize(new java.awt.Dimension(30, 30));
        scrollPanel.setPreferredSize(new java.awt.Dimension(500, 400));
        scrollPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                scrollPanelComponentResized(evt);
            }
        });
        scrollPanel.setLayout(new java.awt.GridBagLayout());

        mapPanel.setMinimumSize(new java.awt.Dimension(400, 400));
        mapPanel.setPreferredSize(new java.awt.Dimension(581, 400));
        mapPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mapPanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
        mapPanel.setLayout(mapPanelLayout);
        mapPanelLayout.setHorizontalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );
        mapPanelLayout.setVerticalGroup(
            mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        scrollPanel.add(mapPanel, gridBagConstraints);

        horizontalScrollBar.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        horizontalScrollBar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                horizontalScrollBarPropertyChange(evt);
            }
        });
        horizontalScrollBar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                horizontalScrollBarAdjustmentValueChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        scrollPanel.add(horizontalScrollBar, gridBagConstraints);

        verticalScrollBar.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                verticalScrollBarAdjustmentValueChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        scrollPanel.add(verticalScrollBar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(scrollPanel, gridBagConstraints);

        jPanel1.setMinimumSize(new java.awt.Dimension(200, 46));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        calcRoute.setText("Calculate route");
        calcRoute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcRouteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(calcRoute, gridBagConstraints);

        routeSelectList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Route with best time (red)", "Route with best dist (blue)", "Route with best fuel consumption (green)" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        routeSelectList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                routeSelectListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(routeSelectList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jScrollPane1, gridBagConstraints);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Car 1", "Car 2", "Car 3" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(jScrollPane3, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Select route criteria:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Select car:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void markRoute(ArrayList<MapObject> path, int type) {
        if (path != null) {
			for (MapObject mo : path) {
				mo.setSelected(type);
			}
		}
	}
	
	private void clearRoute(ArrayList<MapObject> path) {
        if (path != null) {
			markRoute(path, 0);
			path.clear();
			path = null;
		}
	}
	
    private void calcRouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcRouteActionPerformed
        if (!routeWithBestTime.isEmpty() || !routeWithBestDist.isEmpty() ||
				!routeWithBestFuelCons.isEmpty())
		{
			clearRoute(routeWithBestTime);
			clearRoute(routeWithBestDist);
			clearRoute(routeWithBestFuelCons);		
			
			for (Point p : selectedPoints)
				p.setColor(null);
			selectedPoints.clear();
			
			calcRoute.setText("Calculate route");
			repaint();
			return;
		}
		
		if (selectedPoints.isEmpty())
			return;
		
		calcRoute.setText("Clear route");
        Car car;
		car = new Car();
        car.setMaxSpeed(22.22); //m/s = 80 km/h
        car.setFuelCons(8/1000);
        car.setFuelConsLight(30 * car.getFuelCons());
        
        //int from = (int)jSpinner1.getValue()-1;
        //int to = (int)jSpinner2.getValue()-1;
        
		Point from, to = selectedPoints.get(0);
		for (int i=1; i<selectedPoints.size(); i++) {
			from = to;
			to = selectedPoints.get(i);
			routeWithBestTime.addAll(map.findRouteWithBestTime(from, to, null, car));
			routeWithBestDist.addAll(map.findRouteWithBestDist(from, to));
			routeWithBestFuelCons.addAll(map.findRouteWithBestFuelCons(from, to, null, car));
		}
		
        markRoute(routeWithBestTime, 1);
        markRoute(routeWithBestDist, 2);
        markRoute(routeWithBestFuelCons, 3);
		textArea.setText("Помощь в выборе пути:");
		int counter=0;
        if (routeWithBestTime != null) {
			for (MapObject mo : routeWithBestTime) if (mo instanceof Road){
				counter++;
				textArea.setText(textArea.getText()+"\nНа участке дороги #" + counter + " выбран путь #"  + mo.getId());
				textArea.setText(textArea.getText()+" т.к. это самый быстрый способ добраться до пункта назначения. ");
			}
		}		 
		counter=0;
        if (routeWithBestDist != null) {
			for (MapObject mo : routeWithBestDist) if (mo instanceof Road){
				counter++;
				textArea.setText(textArea.getText()+"\nПри выборе наикоротшей дороги на участке #" + counter + " выбирается путь #"  + mo.getId());
				textArea.setText(textArea.getText()+" т.к. он лежит на самом коротком пути");
			}
		}
		counter=0;
        if (routeWithBestFuelCons != null) {
			for (MapObject mo : routeWithBestFuelCons) if (mo instanceof Road){
				counter++;
				textArea.setText(textArea.getText()+"\nВ наиболее экономичном с точки зрения затрат топлива маршруте на участке #" + counter + " выбирается путь #"  + mo.getId());
				textArea.setText(textArea.getText()+" т.к. он позволяет сократить затраты топлива по сравнению с наиболее быстрым по времени маршрутом. ");	
			}
		}
		for (int j=0; j<routeWithBestTime.size(); j++)
		{
			if (routeWithBestTime.get(j)!=routeWithBestDist.get(j) )
					{
						routeWithBestTime.get(j-1).setTitle("Точка принятия решения");
						break;
					}
		}

		repaint();
    }//GEN-LAST:event_calcRouteActionPerformed

    private void mapPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapPanelMousePressed
        Point point = (Point)mapPanel.getObjectAt(evt.getX(), evt.getY());
		if (point != null) {
			if (evt.getButton() == MouseEvent.BUTTON1) {
				selectedPoints.add(point);
				point.setColor(Color.BLUE);
			}else{
				selectedPoints.remove(point);
				point.setColor(null);
			}
			if (evt.isControlDown() && map.godMode && selectedPoints.size() == 2) {
				Road road = new Road(selectedPoints.get(0), selectedPoints.get(1), true, 2, 1);
				map.addRoadToDB(road);
				for (Point p : selectedPoints)
					p.setColor(null);
				selectedPoints.clear();
			}
			
	        repaint();
		}else{
			if (map.godMode) {
				mapPanel.addPointAt(evt.getX(), evt.getY());
				repaint();
			}
		}
			
    }//GEN-LAST:event_mapPanelMousePressed

    private void routeSelectListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_routeSelectListValueChanged
        switch (routeSelectList.getSelectedIndex()) {
			case 0: markRoute(routeWithBestTime, 1); break;
			case 1: markRoute(routeWithBestDist, 2); break;
			case 2: markRoute(routeWithBestFuelCons, 3); break;
		}
        repaint();
    }//GEN-LAST:event_routeSelectListValueChanged

    private void scrollPanelComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_scrollPanelComponentResized
        //horizontalScrollBar.setMaximum(mapPanel.getMaxScrollX());
        //verticalScrollBar.setMaximum(mapPanel.getMaxScrollY());
    }//GEN-LAST:event_scrollPanelComponentResized

    private void horizontalScrollBarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_horizontalScrollBarPropertyChange
        System.out.println("dverver");
    }//GEN-LAST:event_horizontalScrollBarPropertyChange

    private void horizontalScrollBarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_horizontalScrollBarAdjustmentValueChanged
        mapPanel.setScrollX(horizontalScrollBar.getValue());
		repaint();
    }//GEN-LAST:event_horizontalScrollBarAdjustmentValueChanged

    private void verticalScrollBarAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_verticalScrollBarAdjustmentValueChanged
        mapPanel.setScrollY(verticalScrollBar.getValue());
		repaint();
    }//GEN-LAST:event_verticalScrollBarAdjustmentValueChanged

    private void textAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAreaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_G) {
			map.godMode = !map.godMode;
			repaint();
		}else if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
			for (Point point : selectedPoints) {
				map.removePointFromDB(point);
			}
			selectedPoints.clear();
			repaint();
		}
    }//GEN-LAST:event_textAreaKeyPressed

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
    private javax.swing.JButton calcRoute;
    private javax.swing.JScrollBar horizontalScrollBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private idss.MapPanel mapPanel;
    private javax.swing.JList routeSelectList;
    private javax.swing.JPanel scrollPanel;
    private javax.swing.JTextArea textArea;
    private javax.swing.JScrollBar verticalScrollBar;
    // End of variables declaration//GEN-END:variables

}
