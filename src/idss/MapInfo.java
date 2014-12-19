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
	Connection connection;
	boolean godMode;
    ArrayList<Point> points = new ArrayList<>();
    ArrayList<Road> roads = new ArrayList<>();
	
    private double getHeuristicCostForTime(Point a, Point b, Car car) {
        return a.getDistanceTo(b)/car.getMaxSpeed();
    }

    private double getHeuristicCostForFuel(Point a, Point b, Car car) {
        return a.getDistanceTo(b) * car.getFuelCons();
    }
	
    public ArrayList<MapObject> findRouteWithBestTime(Point from, Point to, Time time, Car car) 
	{
        ArrayList<Point> closedSet = new ArrayList<>();
        PriorityQueue<Point> openSet = new PriorityQueue<>();
        ArrayList<MapObject> path = new ArrayList<>();
        
        from.cameFrom = null;
        from.tentativeTime = from.getLag();
        from.heuristicCost = getHeuristicCostForTime(from, to, car);
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
                double tentativeTime = best.tentativeTime + 
						road.getTimeDelay(time, car, 100) + 
						neighbor.getLag() + 
						(road.getBegin() == best ? road.getToLag() : road.getFromLag());
                if (openSet.contains(neighbor)) {
                    if (tentativeTime < neighbor.tentativeTime) {
                        neighbor.cameFrom = road;
                        neighbor.tentativeTime = tentativeTime;
                        neighbor.heuristicCost = getHeuristicCostForTime(neighbor, to, car);
                        neighbor.totalCost = neighbor.tentativeTime + neighbor.heuristicCost;
                    }
                }else{
                    neighbor.cameFrom = road;
                    neighbor.tentativeTime = tentativeTime;
                    neighbor.heuristicCost = getHeuristicCostForTime(neighbor, to, car);
                    neighbor.totalCost = neighbor.tentativeTime + neighbor.heuristicCost;
                    openSet.add(neighbor);
                }
            }
        }
        return null;
    }

    public ArrayList<MapObject> findRouteWithBestDist(Point from, Point to) {
        ArrayList<Point> closedSet = new ArrayList<>();
        PriorityQueue<Point> openSet = new PriorityQueue<>();
        ArrayList<MapObject> path = new ArrayList<>();
        
        from.cameFrom = null;
        from.tentativeTime = 0;
        from.heuristicCost = from.getDistanceTo(to);	//getHeuristicCost(from, to, car);
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
                double tentativeTime = best.tentativeTime + road.getLength();
                if (openSet.contains(neighbor)) {
                    if (tentativeTime < neighbor.tentativeTime) {
                        neighbor.cameFrom = road;
                        neighbor.tentativeTime = tentativeTime;
                        neighbor.heuristicCost = neighbor.getDistanceTo(to);	//getHeuristicCost(neighbor, to, car);
                        neighbor.totalCost = neighbor.tentativeTime + neighbor.heuristicCost;
                    }
                }else{
                    neighbor.cameFrom = road;
                    neighbor.tentativeTime = tentativeTime;
                    neighbor.heuristicCost = neighbor.getDistanceTo(to);
                    neighbor.totalCost = neighbor.tentativeTime + neighbor.heuristicCost;
                    openSet.add(neighbor);
                }
            }
        }
        return null;
    }

    public ArrayList<MapObject> findRouteWithBestFuelCons(Point from, Point to, Time time, Car car) 
	{
        ArrayList<Point> closedSet = new ArrayList<>();
        PriorityQueue<Point> openSet = new PriorityQueue<>();
        ArrayList<MapObject> path = new ArrayList<>();
        
        from.cameFrom = null;
        from.tentativeTime = from.getLag() * car.getFuelConsLight();
        from.heuristicCost = getHeuristicCostForFuel(from, to, car);
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
                double tentativeTime = best.tentativeTime + 
						road.getLength() * car.getFuelCons() + 
						neighbor.getLag() * car.getFuelConsLight();
                if (openSet.contains(neighbor)) {
                    if (tentativeTime < neighbor.tentativeTime) {
                        neighbor.cameFrom = road;
                        neighbor.tentativeTime = tentativeTime;
                        neighbor.heuristicCost = getHeuristicCostForFuel(neighbor, to, car);
                        neighbor.totalCost = neighbor.tentativeTime + neighbor.heuristicCost;
                    }
                }else{
                    neighbor.cameFrom = road;
                    neighbor.tentativeTime = tentativeTime;
                    neighbor.heuristicCost = getHeuristicCostForFuel(neighbor, to, car);
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
		connection = conn;
        
        Statement stmt = null;
        try{
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM point");
            while(rs.next()){
                int id = rs.getInt("id");
                double x  = rs.getInt("x");
                double y = rs.getInt("y");
                int lag = rs.getInt("lag");
                Point p = new Point(x, y);
                p.setId(id);
                p.setLag(lag/1000.f);
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
                int ToLag = rs.getInt("tolag");
                int FromLag = rs.getInt("fromlag");
                
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
                r.setFromLag(FromLag/1000.f);
                r.setToLag(ToLag/1000.f);
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
	
	public void addRoadToDB(Road road) {
        Statement stmt = null;
		//PreparedStatement addStmt = null;
        try{
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM road");
            if (!rs.next())
				return;
			int id = rs.getInt(1) + 1;
                
			stmt.execute("INSERT INTO road (id, start, dest, bidirectional, " + 
					"lanes_num, int_score, tolag, fromlag) VALUES (" + 
					id + "," + road.getBegin().getId() + "," + road.getEnd().getId() +  "," + 
					road.isBidirectional() + "," + road.getLanesNum() + "," + 
					road.getIntScore() + "," + road.getToLag() + "," + road.getFromLag() + ")");                
			
			road.setId(id);
			roads.add(road);
			
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

	public void removeRoadFromDB(Road road) {
        Statement stmt = null;
		//PreparedStatement addStmt = null;
        try{
            stmt = connection.createStatement();
			stmt.execute("DELETE FROM road WHERE id = " + road.getId());			
			points.remove(road);
			
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
	
	public void addPointToDB(Point point) {
        Statement stmt = null;
		//PreparedStatement addStmt = null;
        try{
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM point");
            if (!rs.next())
				return;
			int id = rs.getInt(1) + 1;
                
			stmt.execute("INSERT INTO point (id, x, y) VALUES (" + 
					id + "," + point.getX() + "," + point.getY() + ")");
			
			point.setId(id);
			points.add(point);
			
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
	
	public void removePointFromDB(Point point) {
        Statement stmt = null;
		//PreparedStatement addStmt = null;
        try{
            stmt = connection.createStatement();
			stmt.execute("DELETE FROM point WHERE id = " + point.getId());			
			points.remove(point);
			
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
