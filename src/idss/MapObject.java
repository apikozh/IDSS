/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idss;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.Time;

/**
 *
 * @author Andrew
 */
public abstract class MapObject {
    int id;
    float lag;
    Time timeToReach;
    MapObject path;
    int selected;
	Color color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getLag() {
        return lag;
    }

    public void setLag(float lag) {
        this.lag = lag;
    }

    
    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
    
    public Time getTimeToReach() {
        return timeToReach;
    }

    public void setTimeToReach(Time timeToReach) {
        this.timeToReach = timeToReach;
    }
   
    public abstract void drawTo(Graphics g, int scrollX, int scrollY, float zoom);
    
}
