/**
 * Create: Evyatar Orbach
 * Date: 07/12/2018
 * Brief: Check line in game boards
 */
package q1;

import java.awt.Color;

public class CheckLine {
	private final static int NUMBER_OF_LINE = 4;
	
	/**
	 * checking line from a given cell of given board
	 * @param gameBoard
	 * @param row - the row of the relevant cell
	 * @param col - the column of the relevant cell
	 * @return true if found a line or false if not
	 */
	public static boolean checkLine(GameBoard gameBoard, int row, int col) {
		if(!gameBoard.getBoard()[row][col].isFree()) {
			if(checkDown(gameBoard, row, col) >= NUMBER_OF_LINE ||
					checkLeft(gameBoard, row, col) + checkRight(gameBoard, row, col) - 1 >= NUMBER_OF_LINE ||
					checkDiagonalDownLeft(gameBoard, row, col) + checkDiagonalUpRight(gameBoard, row, col) - 1 >= NUMBER_OF_LINE ||
					checkDiagonalUpLeft(gameBoard, row, col) + checkDiagonalDownRight(gameBoard, row, col) - 1 >= NUMBER_OF_LINE ){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * count number of ownership down of the given cell owner
	 */
	public static int checkDown(GameBoard gameBoard, int row, int col) {
		int count=0;
		Color color = gameBoard.getBoard()[row][col].getColor();
		for(;row >= 0;row--) {
			if(!gameBoard.getBoard()[row][col].isFree() && gameBoard.getBoard()[row][col].getColor().equals(color)) {
				count++;
			}else {
				break;
			}
		}
		return count;
	}
	
	/**
	 * count number of ownership left of the given cell owner
	 */
	public static int checkLeft(GameBoard gameBoard, int row, int col) {
		int count=0;
		Color color = gameBoard.getBoard()[row][col].getColor();
		for(;col >= 0;col--) {
			if(!gameBoard.getBoard()[row][col].isFree() && gameBoard.getBoard()[row][col].getColor().equals(color)) {
				count++;
			}else {
				break;
			}
		}
		return count;
	}
	
	/**
	 * count number of ownership from right of the given cell owner
	 */
	public static int checkRight(GameBoard gameBoard, int row, int col) {
		int count=0;
		Color color = gameBoard.getBoard()[row][col].getColor();
		for(;col < gameBoard.getBoard()[row].length;col++) {
			if(!gameBoard.getBoard()[row][col].isFree() && gameBoard.getBoard()[row][col].getColor().equals(color)) {
				count++;
			}else {
				break;
			}
		}
		return count;
	}
	
	/**
	 * count number of ownership from diagonal up left of the given cell owner
	 */
	public static int checkDiagonalUpLeft(GameBoard gameBoard, int row, int col) {
		int count=0;
		Color color = gameBoard.getBoard()[row][col].getColor();
		for(;col >= 0 && row < gameBoard.getBoard().length;col--,row++) {
			if(!gameBoard.getBoard()[row][col].isFree() && gameBoard.getBoard()[row][col].getColor().equals(color)) {
				count++;
			}else {
				break;
			}
		}
		return count;
	}
	
	/**
	 * count number of ownership from diagonal up right of the given cell owner
	 */
	public static int checkDiagonalUpRight(GameBoard gameBoard, int row, int col) {
		int count=0;
		Color color = gameBoard.getBoard()[row][col].getColor();
		for(;row < gameBoard.getBoard().length && col < gameBoard.getBoard()[row].length;col++,row++) {
			if(!gameBoard.getBoard()[row][col].isFree() && gameBoard.getBoard()[row][col].getColor().equals(color)) {
				count++;
			}else {
				break;
			}
		}
		return count;
	}
	
	/**
	 * count number of ownership from diagonal down left of the given cell owner
	 */
	public static int checkDiagonalDownLeft(GameBoard gameBoard, int row, int col) {
		int count=0;
		Color color = gameBoard.getBoard()[row][col].getColor();
		for(;col >= 0 && row >= 0;col--,row--) {
			if(!gameBoard.getBoard()[row][col].isFree() && gameBoard.getBoard()[row][col].getColor().equals(color)) {
				count++;
			}else {
				break;
			}
		}
		return count;
	}
	
	/**
	 * count number of ownership from diagonal down right of the given cell owner
	 */
	public static int checkDiagonalDownRight(GameBoard gameBoard, int row, int col) {
		int count=0;
		Color color = gameBoard.getBoard()[row][col].getColor();
		for(;row > 0 && col < gameBoard.getBoard()[row].length;col++,row--) {
			if(!gameBoard.getBoard()[row][col].isFree() && gameBoard.getBoard()[row][col].getColor().equals(color)) {
				count++;
			}else {
				break;
			}
		}
		return count;
	}
}
