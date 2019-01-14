/**
 * Create: Evyatar Orbach
 * Date: 21/12/2018
 * Brief: mmn 14 qu1
 */
package q1;

/**
 * this class implemet linkedlist
 * @author eorbach
 *
 * @param <E> - generic type. linked list can used by any type except of primitives types
 */
public class LinkedList<E> {
	private Cell<E> head;
	private Cell<E> tail;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}

	public Cell<E> getHead() {
		return head;
	}

	public Cell<E> getTail() {
		return tail;
	}
	
	/**
	 * add cell to the last of list
	 * @param newCellContent - get new cell to add
	 */
	public void add(E newCellContent) {
		Cell<E> newCell = new Cell<E>(newCellContent);
		if(this.head == null) {
			this.head = newCell;
			this.tail = newCell;
			return;
		}
		this.tail.setNextCell(newCell);
		this.tail = newCell;
	}
	
	/**
	 * remove the first cell
	 * @return the new first cell
	 * @throws EmptyListException if the list is empty
	 */
	public E remove() throws EmptyListException{
		if(this.head != null) {
			E content = this.head.getCellContent();
			this.head = this.head.getNextCell();
			return content;
		}else {
			throw new EmptyListException();
		}
	}
	
	public String toString() {
		String linkedContents = "";
		int counter = 0;
		Cell<E> nextCell = this.head;
		
		while(nextCell != null) {
			linkedContents += counter +": "+ nextCell.getCellContent()+" ";
			nextCell = nextCell.getNextCell();
			counter++;
		}
		return linkedContents;
	}
	
	/**
	 * reverse list, recursive function
	 * @param newlist
	 * @return new reverse list
	 */
	public LinkedList<E> reverseList(LinkedList<E> newlist) {
		Cell<E> head = this.getHead();
		Cell<E> tail = this.getTail();
		
		newlist.add(tail.getCellContent());
		
		if(head == tail) return newlist; //exit point when the reverse has finished
		
		while(head != tail) {
			this.add(head.getCellContent());
			head = head.getNextCell();
			try {
				this.remove();
			} catch (EmptyListException e) {
				e.printStackTrace();
				return null;
			}
		}
		try {
			this.remove();
		} catch (EmptyListException e) {
			e.printStackTrace();
			return null;
		}
	    return reverseList(newlist);
	}
}
