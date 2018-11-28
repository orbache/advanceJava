package q1;

/**
* This class implement Arc that complex of 2 points and the distance between them
* @author Evyatar Orbach
*/
public class Arc {
	private double distance;
	private Point point1;
	private Point point2;
 
	public Arc(Point point1, Point point2) {
		int point1X = point1.getX();
		int point1Y = point1.getY();
		int point2X = point2.getX();
		int point2Y = point2.getY();
		
		this.point1 = new Point(point1X,point1Y);
		this.point2 = new Point(point2X,point2Y);
		this.distance = Math.sqrt(Math.pow((point1X-point2X), 2) + Math.pow((point1Y-point2Y), 2));
	}
	
	public double getDistance() {
		return distance;
	}
	
	public Point getPoint1() {
		return point1;
	}
	
	public Point getPoint2() {
		return point2;
	}

}
