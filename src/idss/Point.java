/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idss;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.Time;
import java.util.ArrayList;


/**
 *
 * @author Andrew
 */
public class Point extends MapObject implements Comparable {
    double x, y;    // lat, lon

    Road cameFrom;
    double tentativeTime, heuristicCost, totalCost;
    
    ArrayList<Road> roads = new ArrayList<>();
    ArrayList<Restriction> restrictions = new ArrayList<>();
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    //public abstract Time getTimeToPass(Time time, Road from, Road to);
    //public abstract int getRoadsCount();
    //public abstract Road getRoad(int index);
    
    public void addRoad(Road road) {
        roads.add(road);
    }

    public void removeRoad(Road road) {
        roads.remove(road);
    }
    
    public Road getRoad(int index) {
        return roads.get(index);
    }    

    public int getRoadsCount() {
        return roads.size();
    }    

    public void addRestriction(Restriction restriction) {
        restrictions.add(restriction);
    }

    public void removeRestriction(Restriction restriction) {
        restrictions.remove(restriction);
    }
    
    public Restriction getRestriction(int index) {
        return restrictions.get(index);
    }    

    public int getRestrictionsCount() {
        return restrictions.size();
    }    
    
    public Restriction findRestriction(Road from, Road to) {
        for (Restriction r : restrictions) {
            if (r.getFrom() == from && r.getTo() == to) {
                return r;
            }
        }
        return null;
    }
    
	public double getDistanceTo(Point point) {
        double dx = getX() - point.getX();
        double dy = getY() - point.getY();
        return Math.sqrt(dx*dx + dy*dy);
	}
	
    public Time getTimeToPass(Time time, Road from, Road to, Car car) {
        if (from != null && to != null && 
                roads.contains(from) && roads.contains(to))
        {
            Restriction r = findRestriction(from, to);
            if (r == null) {
                return time;
            }else if (r.getTrafficLight() == null) {                
                return null;
            }else{
                return r.getTrafficLight().getTimeToPass(time, false);
            }
        }
        return null;
    }
    
    public ArrayList<Road> getRoads() {
        return roads;
    }

    public ArrayList<Restriction> getRestrictions() {
        return restrictions;
    }
    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

	@Override
	public void drawTo(Graphics g, int scrollX, int scrollY, float zoom) {
		if (getColor() == null)
			g.setColor(Color.GRAY);
		else
			g.setColor(getColor());
		
		g.fillOval(scrollX + (int)x - 6, scrollY + (int)y - 8, 12, 16);
		g.setColor(Color.green);
		g.fillOval(scrollX + (int)x - 6+3, scrollY + (int)y+2, 5, 5);
		g.setColor(Color.red);
		g.fillOval(scrollX + (int)x - 6+3, scrollY + (int)y - 8, 5, 5);
		g.setColor(Color.yellow);
		g.fillOval(scrollX + (int)x - 6+3, scrollY + (int)y-3, 5, 5);
   }

    @Override
    public int compareTo(Object o) {
        if (totalCost < ((Point)o).totalCost)
            return -1;
        else if (totalCost > ((Point)o).totalCost)
            return 1;
        else
            return 0;
    }
    
}
