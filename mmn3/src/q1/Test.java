/**
 * Create: Evyatar Orbach
 * Date: 07/12/2018
 * Brief: main function create frame
 */
package q1;

import javax.swing.JFrame;

public class Test {
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	
	public static void main(String[] args) {	
		Frame window = new Frame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WIDTH, HEIGHT);
		window.setVisible(true);
	}
}
