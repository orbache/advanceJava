package q1;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.ArrayList;

/**
* This class implement DrawGraph that extend JPanel for drawing lines between points of data object
* @author Evyatar Orbach
*/
public class DrawGraph extends JPanel{
	private ArrayList<Arc> arcs;
	
	DrawGraph(Data data) {
		arcs = data.getArcs();
	}
	
	/**
	* @param Graphics for system call
	* drawing arcs
	*/
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int index,x1,x2,y1,y2;
		int xLongStringLocation;
		int yLongStringLocation;
		String distance;
		for(index=0; arcs != null && index < arcs.size(); index++) {
			x1 = arcs.get(index).getPoint1().getX();
			y1 = arcs.get(index).getPoint1().getY();
			x2 = arcs.get(index).getPoint2().getX();
			y2 = arcs.get(index).getPoint2().getY();
			
			xLongStringLocation = (x1+x2)/2;
			yLongStringLocation = (y1+y2)/2;
			distance = String.valueOf(String.format("%.2f", arcs.get(index).getDistance()));
			
			g.drawLine(x1, y1, x2, y2);
			g.drawString(distance,xLongStringLocation,yLongStringLocation);
		}
	}
	
	
	
}


