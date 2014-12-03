/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idss;

import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class TrafficLight {
    //ArrayList<Road> directLinks;
    //ArrayList<Road> oppositeLinks;
    int id;
    long redTime;   //in ms
    long greenTime;
    Time workingStart;
    Time workingEnd;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getTimeToPass(Time time, boolean inverted) {
        return new Time(time.getTime() + 30*1000); // TODO: Timing
    }
}
