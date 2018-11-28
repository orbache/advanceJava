package q1;

import java.util.ArrayList;

/**
* This class implement Data that save Arraylists of points and arcs and the sum of all the arcs distances
* @author Evyatar Orbach
*/
public class Data {
	private ArrayList<Point> points = new ArrayList<Point>();
	private ArrayList<Arc> arcs = new ArrayList<Arc>();
	private double sumOfDistances;
	
	public ArrayList<Arc> getArcs() {
		return arcs;
	}

	public void newPoint(int x,int y) {
		Point point = new Point(x,y);
		if(!points.isEmpty()) {
			arcs.add(new Arc(points.get(points.size()-1), point));
			sumOfDistances += arcs.get(arcs.size()-1).getDistance();
		}
		points.add(point);
	}
	
	public ArrayList<Point> getPointsArray() {
		return points;
	}

	public ArrayList<Arc> getDistances() {
		return arcs;
	}

	public double getSumOfDistances() {
		return sumOfDistances;
	}

}
