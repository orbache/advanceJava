/**
 *Create: Evyatar Orbach
 *ID: 301740015
 *Date: 6/11/2018
 *Title: MMN 2 - Advanced Java programming 
 */

package q1;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Test {
	static final int HEIGHT = 400;
	static final int WIDTH = 400;
	
	public static void main(String[] args) { 
		int x = 0,y = 0;
		String xMessage = null;
		String yMessage = null;
		Data dataManager = new Data();		
		JFrame window = new JFrame();
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DrawGraph graph = new DrawGraph(dataManager);
		window.add(graph);
		window.setVisible(true);
		
		while(true) {
			xMessage = JOptionPane.showInputDialog("Please enter X cordinate:");
			if(xMessage == null || xMessage == null || xMessage.isEmpty()) {
				JOptionPane.showMessageDialog(graph, "Thank you! bye bye","Exit", JOptionPane.CLOSED_OPTION);
				break;
			}else { 
				try {
					x = Integer.parseInt(xMessage);
				}catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(graph, "Illegal value","ERROR", JOptionPane.ERROR_MESSAGE);
					continue;
				}
				yMessage = JOptionPane.showInputDialog("Please enter Y cordinate:");
				if(yMessage == null || yMessage == null || yMessage.isEmpty()) {
					JOptionPane.showMessageDialog(graph, "Thank you! bye bye","Exit", JOptionPane.CLOSED_OPTION);
					break;
				}
				try {
					y = Integer.parseInt(yMessage);
				}catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(graph, "Illegal value","ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			if(x > graph.getWidth() || x < 0 || y > graph.getHeight() || y < 0) {
				JOptionPane.showMessageDialog(graph, "Out of limit","ERROR", JOptionPane.ERROR_MESSAGE);
			}else {
				dataManager.newPoint(x, y);
				graph.repaint();
			}
		}
		System.exit(0);
	}
}


