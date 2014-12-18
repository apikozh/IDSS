/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idss;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.sql.Time;

/**
 *
 * @author Andrew
 */
public class Road extends MapObject {
    Point begin, end;
    boolean bidirectional;
    int lanesNum;   // 1 ...
    int intScore;   // 1(good road) .. 10(cant pass)
    int trafficJamScore;    // 1(no jam) .. 10 (big jam)
    float speedLimit;
    int ToLag, FromLag;
    
    //ArrayList<Accident> accidents;
    
    //Working time

    public Road(Point begin, Point end, boolean bidirectional
            , int lanesNum, int intScore) 
    {
        this.begin = begin;
        this.end = end;
        this.begin.addRoad(this);
        this.end.addRoad(this);        
        this.bidirectional = bidirectional;
        this.lanesNum = lanesNum;
        this.intScore = intScore;
        this.speedLimit = 60*10/36.f; // m/s
    }

    public float getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(float speedLimit) {
        this.speedLimit = speedLimit;
    }

    
    public boolean isBidirectional() {
        return bidirectional;
    }

    public void setBidirectional(boolean bidirectional) {
        this.bidirectional = bidirectional;
    }
    
    public double getTimeDelay(Time time, Car car, float percent) {
        double diff = intScore*trafficJamScore/lanesNum;
        if (diff < 1) diff = 1;
        double dx = begin.getX()-end.getX();
        double dy = begin.getY()-end.getY();
        double length = Math.sqrt(dx * dx + dy * dy);
        return length*diff/speedLimit;
    }

    public Time getTimeToPass(Time time, Car car, float percent) {
        return new Time(time.getTime() + (long)getTimeDelay(time, car, percent)*1000);
    }
    
    public Point getBegin() {
        return begin;
    }

    public void setBegin(Point begin) {
        this.begin = begin;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public int getLanesNum() {
        return lanesNum;
    }

    public void setLanesNum(int lanesNum) {
        this.lanesNum = lanesNum;
    }

    public int getIntScore() {
        return intScore;
    }

    public void setIntScore(int intScore) {
        this.intScore = intScore;
    }

    public int getFromLag() {
        return FromLag;
    }

    public void setFromLag(int fromLag) {
        this.FromLag = fromLag;
    }
    
    public int getToLag() {
        return ToLag;
    }

    public void setToLag(int toLag) {
        this.ToLag = toLag;
    }

    public int getTrafficJamScore() {
        return trafficJamScore;
    }

    public void setTrafficJamScore(int trafficJamScore) {
        this.trafficJamScore = trafficJamScore;
    }
    
    public void drawTo(Graphics g, int scrollX, int scrollY) {
       Graphics2D g2d=(Graphics2D)g;
        switch (selected) {       
           case 1:  g.setColor(Color.red);
                    break;
           case 2:  g.setColor(Color.blue);
                    break;
           case 3:  g.setColor(Color.green);
                    break;        
           default: g.setColor(Color.black);
                    break;
               }
       g2d.setStroke(new BasicStroke(3));
       g2d.drawLine(scrollX + (int)begin.getX(), scrollY + (int)begin.getY(), 
               scrollX + (int)end.getX(), scrollY + (int)end.getY());
   }
    
/*    public void drawTo(Graphics g, int scrollX, int scrollY) {
        Graphics2D g2d = (Graphics2D)g;
		if (selected)
            g.setColor(Color.red);
        else
            g.setColor(Color.black);
        double pNx = end.getY() - begin.getY(), pNy = begin.getX() - end.getX();
		pNx = pNx/Math.sqrt(pNx*pNx + pNy*pNy);
		pNy = pNy/Math.sqrt(pNx*pNx + pNy*pNy);

		g2d.setStroke(new BasicStroke(1.0f));
		
		g2d.draw(new Line2D.Double(
				scrollX + begin.getX() - pNx, 
				scrollY + begin.getY() - pNy, 
                scrollX + end.getX() - pNx, 
				scrollY + end.getY() - pNy));

		g2d.draw(new Line2D.Double(
				scrollX + begin.getX() + pNx, 
				scrollY + begin.getY() + pNy, 
                scrollX + end.getX() + pNx, 
				scrollY + end.getY() + pNy));

		double lX, lY;
		final float dash1[] = {5.0f};
		//lX = pNx * (1 + 6 * (i+1));
		//lY = pNy * (1 + 6 * (i+1));
			
		for (int i = 0; i < lanesNum; i++) {
			if (i < lanesNum-1)
				g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
						BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f));
			else
				g2d.setStroke(new BasicStroke(1.0f));
				
			lX = pNx * (1 + 6 * (i+1));
			lY = pNy * (1 + 6 * (i+1));
			
			g2d.draw(new Line2D.Double(
					scrollX + begin.getX() - lX, 
					scrollY + begin.getY() - lY, 
					scrollX + end.getX() - lX, 
					scrollY + end.getY() - lY));

			g2d.draw(new Line2D.Double(
					scrollX + begin.getX() + lX, 
					scrollY + begin.getY() + lY, 
					scrollX + end.getX() + lX, 
					scrollY + end.getY() + lY));
 		}
	}
  */  
}
