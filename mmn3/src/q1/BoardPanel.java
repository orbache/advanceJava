/**
 * Create: Evyatar Orbach
 * Date: 07/12/2018
 * Brief: Create board panel and paint it
 */
package q1;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class BoardPanel extends JPanel{

	private int rows;
	private int columns;
	private GameBoard board;
	private int numberOfPlayers;
	private Color[] players;
	
	/**
	 * Constructor of BoardPanel
	 * @param rows - number of rows in board
	 * @param columns - number of columns in board
	 * @param players - array of colors of players
	 */
	BoardPanel(int rows,int columns,Color[] players) {
		this.rows = rows;
		this.columns = columns;
		board = new GameBoard(rows,columns);
		this.players = players;
		this.numberOfPlayers = players.length;
	}
	
	public GameBoard getBoard() {
		return board;
	}

	/**
	 * Override paintComponent to 
	 * draw ovals at the cells as the color of the cell owner
	 * and drawing lines to divide the board
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getWidth();     
		int height = getHeight();
		int x = 0;
		int y = 0;
		int widthOffset = width/columns;
		int heightOffset = height/(rows);
		
		for(y=widthOffset;y<(width-widthOffset);y+=widthOffset) {
			g.drawLine(y, 0, y, height);
		}
		
		for(x=heightOffset;x<(height);x+=heightOffset) {
			g.drawLine(0, x, width, x);
		}
		
		for(x=0;x<rows;x++) {
			for(y=0;y<columns;y++) {
				if(board.getBoard()[x][y].isFree() == false) {
					for(int playerCount=0;playerCount<this.numberOfPlayers;playerCount++) {
						if(board.getBoard()[x][y].getColor().equals(players[playerCount])) {
							g.setColor(players[playerCount]);
						}
						g.fillOval((y)*widthOffset, (rows-x-1)*heightOffset, widthOffset, heightOffset);
					}
				}
			}
		}
	}
}
