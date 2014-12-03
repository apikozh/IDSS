/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idss;

/**
 *
 * @author Andrew
 */
public class Restriction {
    int id;
    Point cross;
    Road from, to;
    boolean inverted;
    TrafficLight trafficLight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getCross() {
        return cross;
    }

    public void setCross(Point cross) {
        this.cross = cross;
    }

    public Road getFrom() {
        return from;
    }

    public void setFrom(Road from) {
        this.from = from;
    }

    public Road getTo() {
        return to;
    }

    public void setTo(Road to) {
        this.to = to;
    }

    public boolean isInverted() {
        return inverted;
    }

    public void setInverted(boolean inverted) {
        this.inverted = inverted;
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }

    public void setTrafficLight(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }
    
    
}
