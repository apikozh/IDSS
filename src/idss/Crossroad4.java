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
public class Crossroad4 extends Point {
    Road r1, r2, r3, r4;
    TrafficLight trafficLight;

    public Crossroad4(double x, double y) {
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

    public Road getR3() {
        return r3;
    }

    public void setR3(Road r3) {
        this.r3 = r3;
    }

    public Road getR4() {
        return r4;
    }

    public void setR4(Road r4) {
        this.r4 = r4;
    }
    
    public TrafficLight getTrafficLight() {
        return trafficLight;
    }

    public void setTrafficLight(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }    
    
    //@Override
    public Time getTimeToPass(Time time, Road from, Road to) {
        if (trafficLight == null)
            return time;
        else {
            if (from == r1) {
                if (to == r1) {
                    return null;
                }else if (to == r2) {
                    return trafficLight.getTimeToPass(time, false);
                }else if (to == r3) {
                    return trafficLight.getTimeToPass(time, false);
                }else
                    return null;
            }else if (from == r2) {
                if (to == r1) {
                    return trafficLight.getTimeToPass(time, true);
                }else if (to == r2) {
                    return null;
                }else if (to == r3) {
                    return trafficLight.getTimeToPass(time, true);
                }else
                    return null;
            }else if (from == r3) {
                if (to == r1) {
                    return trafficLight.getTimeToPass(time, false);
                }else if (to == r2) {
                    return trafficLight.getTimeToPass(time, false);
                }else if (to == r3) {
                    return null;
                }else
                    return null;
            }else
                return null;            
        }
    }
    
    @Override
    public int getRoadsCount() {
        return 4;
    }
    
    @Override
    public Road getRoad(int index) {
        switch (index) {
            case 0: return r1;
            case 1: return r2;
            case 2: return r3;
            case 3: return r4;
            default: return null;
        } 
    }
    
}
