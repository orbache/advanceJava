/**
 * Create: Evyatar Orbach
 * Date: 07/12/2018
 * Brief: Create cell for games board
 */

package q1;

import java.awt.Color;

public class Cell {
	private boolean isFree;
	private Color color;
	
	/**
	 * Constructor for cell, initialize to free and no color owner
	 */
	Cell(){
		isFree = true;
		color = null;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public boolean isFree() {
		return isFree;
	}
	
	/**
	 * set the current status of the cell
	 * @param status true if it free and false if not
	 */
	public void setStatus(boolean status) {
		this.isFree = status;
	}
	
}
