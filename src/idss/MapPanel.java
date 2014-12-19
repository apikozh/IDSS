/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idss;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.GlyphVector;

/**
 *
 * @author Andrew
 */
public class MapPanel extends javax.swing.JPanel {
    
    MapInfo map;
	int scrollX, scrollY;
    float zoom = 1;
	
    /**
     * Creates new form MapPanel
     */
    public MapPanel() {
        initComponents();
    }

    public MapInfo getMapInfo() {
        return map;
    }

    public void setMapInfo(MapInfo map) {
        this.map = map;
    }

	public int getScrollX() {
		return scrollX;
	}

	public void setScrollX(int scrollX) {
		this.scrollX = scrollX;
	}

	public int getScrollY() {
		return scrollY;
	}

	public void setScrollY(int scrollY) {
		this.scrollY = scrollY;
	}

	public int getMaxScrollX() {
		return 1000;
	}

	public int getMaxScrollY() {
		return 1000;
	}

	public float getZoom() {
		return zoom;
	}

	public void setZoom(float zoom) {
		this.zoom = zoom;
	}
	
	public MapObject getObjectAt(int x, int y) {
		Point cursor = new Point(x + scrollX, y + scrollY);
		for (Point point : map.points) {
			if (point.getDistanceTo(cursor) < 15)
				return point;
		}
		//TODO: Add roads
		return null;
	}
	
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
		if (map != null && map.godMode) {
			Font font = g2d.getFont().deriveFont(80.f);
			String text = "God Mode!";
			GlyphVector gv = font.createGlyphVector(g2d.getFontRenderContext(), text);
			Shape ol = gv.getOutline(30, 150);
			g2d.setStroke(new BasicStroke(2.f));
			g2d.setColor(new Color(255, 255, 255, 127));
			g2d.draw(ol);
			g2d.setColor(new Color(255, 0, 0, 127));
			// Color(0, 170, 0, 127) G
			// Color(0, 0, 255, 127) B
			// Color(255, 0, 0, 127) R
			// Color(100, 100, 0, 127) Y
			// Color(0, 150, 150, 127) T
			// Color(150, 0, 150, 127) P
			g2d.fill(ol);
			g2d.setStroke(new BasicStroke(1.f));
		}
		
		g2d.translate(-scrollX, -scrollY);
        if (map != null) {
            for (Road r : map.roads) {
                r.drawTo(g, 0, 0, zoom);
            }
            for (Point p : map.points) {
                p.drawTo(g, 0, 0, zoom);
            }            
        }
		g2d.translate(scrollX, scrollY);

        //g.drawString("BLAH", 20, 20);
        g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.BLACK);
		g2d.drawRect(0, 0, getWidth()-1, getHeight()-1);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

	void addPointAt(int x, int y) {
		Point point = new Point(x + scrollX, y + scrollY);
		map.addPointToDB(point);
	}
}
