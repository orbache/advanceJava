/**
 * Create: Evyatar Orbach
 * Date: 07/12/2018
 * Brief: Create Frame consist of some panels
 */
package q1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Frame extends JFrame implements ActionListener{
	private static final int ROWS = 5;
	private static final int COLUMNS = 7;
	private static final Color[] PLAYERS = new Color[] {Color.BLUE,Color.RED};
	private int player = 0;
	private BoardPanel boardPanel;
	private JPanel buttonsPanel;
	private JPanel columnsPanel;
	private JPanel clearPanel;
	private JButton[] columnButton;
	private JButton clearButton;
	
	/**
	 * Constructor of Frame, create panels for board, columns buttons and clear button
	 */
	Frame() {
		int x;
		
		boardPanel = new BoardPanel(ROWS,COLUMNS,PLAYERS);
		buttonsPanel = new JPanel();
		columnsPanel = new JPanel();
		clearPanel = new JPanel();
		columnButton = new JButton[COLUMNS];
		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		
		for(x=0;x<COLUMNS;x++) {
			columnButton[x] = new JButton(String.valueOf(x));
			columnButton[x].addActionListener(this);
			columnsPanel.add(columnButton[x]);
		}
		columnsPanel.setLayout(new GridLayout(1, COLUMNS));
		clearPanel.add(clearButton,BorderLayout.CENTER);
		buttonsPanel.setLayout(new GridLayout(2, 1));
		buttonsPanel.add(columnsPanel);
		buttonsPanel.add(clearPanel);
		
		this.add(boardPanel);
		this.add(buttonsPanel,BorderLayout.SOUTH);
	}
	
	/**
	 *Override actionPerformed for respond to buttons clicks
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int x,y;
		for(x=0;x<COLUMNS;x++) {
			if(e.getSource() == columnButton[x]) {
				for(y=0;y<ROWS;y++) {
					if(boardPanel.getBoard().getBoard()[y][x].isFree()) {
						boardPanel.getBoard().getBoard()[y][x].setColor(PLAYERS[player]);
						boardPanel.getBoard().getBoard()[y][x].setStatus(false);
						boardPanel.repaint();
						player += 1;
						
						if(CheckLine.checkLine(boardPanel.getBoard(), y, x)) {
							JOptionPane.showMessageDialog(null,"You are the winner!!");
							boardPanel.getBoard().clearBoard();
							boardPanel.repaint();
						}
						
						if(player == PLAYERS.length) {
							player = 0;
						}
						
						break;
					}
				}
				if(y==ROWS) {
					JOptionPane.showMessageDialog(null, "The Column is full!", "Illegal move", JOptionPane.INFORMATION_MESSAGE);
				}
			} 
		}
		if(e.getSource() == clearButton){
			boardPanel.getBoard().clearBoard();
			boardPanel.repaint();
			player = 0;
		}
	}
	
	
}
