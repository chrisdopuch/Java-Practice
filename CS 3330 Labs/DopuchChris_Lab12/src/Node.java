/*
 * Name: Chris Dopuch
 * Class: cs3330
 * Lab: B
 * Date: 5/1/13
 */


// TODO: Replace all /* MISSING */ segments

/*
 * Node class. Think of this as a node in a linked
 * list, as it is pretty much what it is. Remember
 * your linked list structs from 1050 or 2050, whichever
 * taught it, and what is contained in the attributes should
 * become clear.
 */
public class Node<T> {
	
	/* Attributes */
	
	private Stats data; // The class the node holds
	private Node<T> next; // The next node in the list
	private Node<T> prev; // The previous node in the list
	
	/* Constructor */
	
	public Node(Stats data) {
		this.setData(data);
		this.setNext(null);
		this.setPrev(null);
	};
	
	/* Getters/Setters */
	
	public void setData(Stats data) {
		this.data = data;
	}
	public Stats getData() { return this.data; }
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	public Node<T> getNext() { return this.next; };
	
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	public Node<T> getPrev() { return this.prev; }
	
	/* Methods */
	
	@Override
	public String toString() {
		return this.getData().toString();
	}
}
