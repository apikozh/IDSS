/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idss;

import java.sql.Time;

/**
 *
 * @author Andrew
 */
public class JunctionPoint extends Point {
    Road r1, r2;
    TrafficLight trafficLight;

    public JunctionPoint(double x, double y) {
        super(x, y);
    }
    
    public Road getR1() {
        return r1;
    }

    public void setR1(Road r1) {
        this.r1 = r1;
    }

    public Road getR2() {
        return r2;
    }

    public void setR2(Road r2) {
        this.r2 = r2;
    }

    //@Override
    public Time getTimeToPass(Time time, Road from, Road to) {
        if (trafficLight == null)
            return time;
        else    
            return trafficLight.getTimeToPass(time, false);
    }
    
    @Override
    public int getRoadsCount() {
        return 2;
    }
    
    @Override
    public Road getRoad(int index) {
        switch (index) {
            case 0: return r1;
            case 1: return r2;
            default: return null;
        } 
    }
    
}
