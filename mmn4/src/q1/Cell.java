/**
 * Create: Evyatar Orbach
 * Date: 21/12/2018
 * Brief: mmn 14 qu1
 */
package q1;

/**
 * this class implement cell
 * @author eorbach
 *
 * @param <E> - generic cell can used by all types except of primitive
 */
public class Cell <E>{
	private E cellContent;
	private Cell<E> nextCell;
	
	public Cell(E cellContent) {
		this.cellContent = cellContent;
		this.nextCell = null;
	}
	
	public Cell(E cellContent, Cell<E> nextCell) {
		this.cellContent = cellContent;
		this.nextCell = nextCell;
	}

	public E getCellContent() {
		return cellContent;
	}

	public void setCellContent(E cellContent) {
		this.cellContent = cellContent;
	}

	public Cell<E> getNextCell() {
		return this.nextCell;
	}

	public void setNextCell(Cell<E> nextCell) {
		this.nextCell = nextCell;
	}
	
	
}
