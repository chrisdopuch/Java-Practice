import java.util.Stack;

/*
 * Name: Chris Dopuch
 * Class: cs3330
 * Lab: B
 * Date: 5/1/13
 */

// TODO: Replace all /* MISSING */ segments

/*
 * List class, works similar to a Stack, but with
 * the ability to traverse it like a linked list.
 * 
 * Stack methods implemented
 * Partial list methods implemented
 */
public final class List<T> {
	
	/* Attributes */

	private static final long serialVersionUID = 1L;
	private Node<T> first;	// The first node in the list
	private Node<T> last;		// The last node in the list
	private int length;
	
	/* Constructor */
	
	public List() {
		this.setFirst(null);
		this.setLast(null);
		this.length = 0;
	}
	
	/* Getters/Setters */
	
	private void setFirst(Node<T> first) {
		this.first = first;
	}
	public Node<T> getFirst() { return this.first; }
	
	private void setLast(Node<T> last) {
		this.last = last;
	}
	private Node<T> getLast() { return this.last; }
	
	private void incLength() { this.length++; }
	private void decLength() {
		if(this.getLength() > 0) this.length--;
	}
	public int getLength() { return this.length; }
	
	/* Methods */
	
	// Pushes data onto the end of the list
	public void push(Stats data) {
		// Create a new node to hold the data being pushed on
		Node<T> node = new Node<T>(data);
		
		// Push the node onto the end of the list
		this.push(node);
	}
	
	// Pushed an existing node onto the end of the list
	public void push(Node<T> node) {
		// List is empty
		if(this.length == 0) {
			// Set first to node
			this.setFirst(node);
			// Set last to node
			this.setLast(node);
		}
		
		// List is not empty
		else {
			// Set the new node to the last node's
			// next node
			this.getLast().setNext(node);
			// Set the new node's prev node to the
			// last node
			node.setPrev(this.getLast());
			// Update the last node to the new node
			this.setLast(node);
		}
		// Increment the size of the list
		this.incLength();
	}
	
	public Stats pop() {
		// List is empty return nothing
		if(this.length == 0) return null;

		// Initialize the node you're
		// returning to null
		Node<T> current = this.getLast();
		
		// List has one element
		if(this.length == 1) {
			// Set the first node to null
			this.setFirst(null);
			// Set the last node to null
			this.setLast(null);
		}
		
		// List has more than one element
		else {
			// Set the last node to the previous last node's
			// predecessor
			this.setLast(this.getLast().getPrev());
			// Set the newest last node's next node to null
			this.getLast().setNext(null);
		}
		
		// Decrement the length count
		this.decLength();
		
		// Return the node's data
		return current.getData();
	}
	
	// Returns the object contained in the first node of the list
	public Stats first() {
		// If first is null, return null
		if(this.getFirst() == null) return null;
		
		// Otherwise return the data of the first node
		else return this.pop();
	}
	
	// Returns a list similar to the current list, but with the
	// first node element replaced
	// Do not rely on this method for anything more than demonstration
	// purposes, as copy/reference issues with the nodes' next/prev
	// could cause issues between lists
	public List<T> rest() {
		// Create a new list
		List<T> rest = new List<T>();
		
		// Get the first node of the current list
		Node<T> current = this.getFirst();
		
		// If the current node is null, return the
		// empty list
		if(current == null) return rest;
		
		// Otherwise, grab the next node in the chain,
		// as you only want everything AFTER the
		// first node
		current = current.getNext();
		
		// While the current node isn't null,
		// add it to the new list and move
		// to the next node in the list
		while(current != null) {
			rest.push(current);
			current = current.getNext();
		}
		
		// Return the new list you created
		return rest;
	}
}
