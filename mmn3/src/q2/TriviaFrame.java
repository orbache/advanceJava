/**
 * Create: Evyatar Orbach
 * Date: 07/12/2018
 * Brief: mmn 13 qu 2
 */
package q2;

import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 * this class create the frame for the trivia game and create new trivia game
 */
public class TriviaFrame extends JFrame {
	private Trivia trivia;
	private Qpanel qpanel;
	
	TriviaFrame() {
		super("Trivia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 200);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		trivia = new Trivia();
		trivia.shuffle();
		qpanel = new Qpanel(trivia);		
		this.add(qpanel);	
		setVisible(true);

	}
}
