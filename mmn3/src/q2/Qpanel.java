/**
 * Create: Evyatar Orbach
 * Date: 07/12/2018
 * Brief: mmn 13 qu 2
 */
package q2;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

/**
 * this class create panel, buttons and timer for the trivia game
 * @author Evyatar Orbach
 */
public class Qpanel extends JPanel {
	private Trivia trivia;
	private JLabel qLabel;
	private JRadioButton[] buttons;
	private ButtonGroup group;
	private int numOfOption;
	private Timer timer;
	private Question question;
	
	final public static int DELAY = 4000;
	
	public Qpanel(Trivia trivia) {	
		this.setLayout(new GridLayout(5,1));
		this.trivia = trivia;
		this.trivia.startGame();
		this.question = new Question(trivia.getQ());
		this.numOfOption = question.getOptions().size();
		this.buttons = new JRadioButton[numOfOption];
		this.group = new ButtonGroup();
		this.qLabel = new JLabel();
		add(qLabel);

		for(int i=0;i<numOfOption;i++) {
			this.buttons[i] = new JRadioButton();
			add(this.buttons[i]);
			group.add(this.buttons[i]);
			this.buttons[i].addActionListener(new ActionListener() {
				
				/**
				 * implement ActionListener for the buttons so every press on them will cause a react
				 */
				@Override
				public void actionPerformed(ActionEvent e) {
					if(trivia.isPlay() == false) {
						if(e.getActionCommand().equals(question.getTheAnswer())) {
							JOptionPane.showMessageDialog(null, "Correct", ":)", JOptionPane.INFORMATION_MESSAGE);
							trivia.setScore(trivia.getScore()+1);
						}else {
							JOptionPane.showMessageDialog(null, "Wrong", ":(", JOptionPane.INFORMATION_MESSAGE);
						}
						question = trivia.getQ();
						trivia.setPlay(true);
						repaint();
					}
				}
			});
		}
		this.timer = new Timer(DELAY,new ActionListener() {
			
			/**
			 * implement ActionListener for the timer so it cause to replace question every DELAY time
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				trivia.setPlay(true);
				question = trivia.getQ();
				repaint();
			}	
		});
		timer.start();
	}
	
	/**
	 * Override paintComponent that extended from JPanel so it show the trivia questions 
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(trivia.isPlay()) {
			trivia.setPlay(false);
			timer.stop();
			if(question == null) {
				if(trivia.endGame() == false) {
					question = trivia.getQ();
				}else {
					System.exit(0);
				}
			}else {
				this.qLabel.setText(question.getQuestion());
				question.shuffle();
				for(int i=0;i<this.numOfOption;i++) {
					this.buttons[i].setText(question.getOptions().get(i));
				}	
				timer.restart();
			}		
		}
	}
}
	
	

