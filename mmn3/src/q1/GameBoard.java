/**
 * Create: Evyatar Orbach
 * Date: 07/12/2018
 * Brief: Create Game board
 */
package q1;

public class GameBoard {
	private Cell[][] board;

	/**
	 * Constructor of GameBoard
	 * @param rows - number of rows in board
	 * @param columns - number of columns in board
	 */
	GameBoard(int rows,int columns) {
		board = new Cell[rows][columns];
		for(int x=0;x<rows;x++) {
			for(int y=0;y<columns;y++) {
				board[x][y] = new Cell(); 
			}
		}
	}
	
	/**
	 * clear the board to the beginning status
	 */
	public void clearBoard() {
		for(int x=0;x<board.length;x++) {
			for(int y=0;y<board[x].length;y++) {
				board[x][y].setColor(null); 
				board[x][y].setStatus(true);
			}
		}	
	}
	
	public Cell[][] getBoard() {
		return board;
	}
}
