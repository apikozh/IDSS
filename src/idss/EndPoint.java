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
public class EndPoint extends Point {
    Road r1;

    public EndPoint(double x, double y) {
        super(x, y);
    }

    public Road getR1() {
        return r1;
    }

    public void setR1(Road r1) {
        this.r1 = r1;
    }


    //@Override
    public Time getTimeToPass(Time time, Road from, Road to) {
        return time;
    }
    
    @Override
    public int getRoadsCount() {
        return 1;
    }
    
    @Override
    public Road getRoad(int index) {
        switch (index) {
            case 0: return r1;
            default: return null;
        } 
    }
}
