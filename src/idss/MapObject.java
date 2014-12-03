/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idss;

import java.awt.Graphics;
import java.sql.Time;

/**
 *
 * @author Andrew
 */
public abstract class MapObject {
    int id;
    Time timeToReach;
    MapObject path;
    boolean selected;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    public Time getTimeToReach() {
        return timeToReach;
    }

    public void setTimeToReach(Time timeToReach) {
        this.timeToReach = timeToReach;
    }
   
    public abstract void drawTo(Graphics g, int scrollX, int scrollY);
    
}
