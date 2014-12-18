/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idss;

import java.sql.Time;
import java.sql.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Andrew
 */
public class MapInfo {
    ArrayList<Point> points = new ArrayList<>();
    ArrayList<Road> roads = new ArrayList<>();
    ArrayList<MapObject> path;
    
    private double getHeuristicCost(Point a, Point b, Car car) {
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();
        return Math.sqrt(dx*dx + dy*dy)/car.getMaxSpeed();
    }
    
    public ArrayList<MapObject> findBestRoute(Point from, Point to, Time time, 
			Car car/*, boolean includeDelays, boolean include*/) {
        ArrayList<Point> closedSet = new ArrayList<>();
        PriorityQueue<Point> openSet = new PriorityQueue<>();
        ArrayList<MapObject> path = new ArrayList<>();
        
        from.cameFrom = null;
        from.tentativeTime = 0;
        from.heuristicCost = getHeuristicCost(from, to, car);
        from.totalCost = from.tentativeTime + from.heuristicCost;
        openSet.add(from);
        
        while (!openSet.isEmpty()) {
            Point best = openSet.poll();
            if (best == to) {
                path.add(to);
                Point curr = to;
                Road lastRoad = curr.cameFrom;
                while(lastRoad != null) {
                    path.add(lastRoad);
                    curr = lastRoad.getEnd() == curr ? lastRoad.getBegin() : lastRoad.getEnd();
                    path.add(curr);
                    lastRoad = curr.cameFrom;
                }
                return path;
            }
            closedSet.add(best);
            for (Road road : best.getRoads()) {
                Point neighbor = road.getBegin() == best ? road.getEnd() : road.getBegin();
                if (closedSet.contains(neighbor)) {
                    continue;
                }
                double tentativeTime = best.tentativeTime + road.getTimeDelay(time, car, 100);
                if (openSet.contains(neighbor)) {
                    if (tentativeTime < neighbor.tentativeTime) {
                        neighbor.cameFrom = road;
                        neighbor.tentativeTime = tentativeTime;
                        neighbor.heuristicCost = getHeuristicCost(neighbor, to, car);
                        neighbor.totalCost = neighbor.tentativeTime + neighbor.heuristicCost;
                    }
                }else{
                    neighbor.cameFrom = road;
                    neighbor.tentativeTime = tentativeTime;
                    neighbor.heuristicCost = getHeuristicCost(neighbor, to, car);
                    neighbor.totalCost = neighbor.tentativeTime + neighbor.heuristicCost;
                    openSet.add(neighbor);
                }
            }
        }
        return null;
    }
    
    private Point findPointByID(int id) {
        for(Point p : points) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    
    public void loadFromDB(Connection conn) {
        roads.clear();
        points.clear();
        
        Statement stmt = null;
        try{
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM point");
            while(rs.next()){
                int id = rs.getInt("id");
                double x  = rs.getInt("x");
                double y = rs.getInt("y");
                Point p = new Point(x, y);
                p.setId(id);
                points.add(p);
            }

            rs = stmt.executeQuery("SELECT * FROM road");
            while(rs.next()){
                int id = rs.getInt("id");
                int fromId  = rs.getInt("start");
                int toId = rs.getInt("dest");
                boolean bidir = rs.getBoolean("bidirectional");
                int lanesNum = rs.getInt("lanes_num");
                int intScore = rs.getInt("int_score");
                int trafficJamScore = rs.getInt("traffic_jam");
                float speedLimit = (float)rs.getDouble("speed_limit");
                
                Point from = findPointByID(fromId);
                Point to = findPointByID(toId);
                if (from == null || to == null)
                    continue;
                Road r = new Road(from, to, bidir, lanesNum, intScore);
                r.setSpeedLimit(speedLimit);
                r.setId(id);
                r.setTrafficJamScore(trafficJamScore);
                roads.add(r);
            }
            
            /*rs = stmt.executeQuery("SELECT * FROM restriction");
            while(rs.next()){
                int id = rs.getInt("id");
                int crossId  = rs.getInt("point");
                int fromId = rs.getInt("road_fr");
                int toId = rs.getInt("road_to");
                boolean inverted = rs.getBoolean("inverted");
                int trafficLightId = rs.getInt("traffic_light");
                
                Point cross = findPointByID(crossId);
                Road from = findRoadByID(fromId);
                Road to = findRoadByID(toId);
                if (from == null || to == null)
                    continue;
                Restriction r = new Restriction();
                r.setId(id);
                r.setCross(cross);
                r.setFrom(from);
                r.setTo(to);
                r.setInverted(inverted);
                r.setTrafficLight(null);
                //roads.add(r);
            }*/
            
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
               if(stmt != null)
                  stmt.close();
            }catch(SQLException se2){
            }
        }
    }
    
}
