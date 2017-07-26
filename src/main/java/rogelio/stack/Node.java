/**
 * Node for a single linked list
 * 
 */
package rogelio.stack;

/**
 * Node, contains data and the *next* pointer
 * 
 * @author Rogelio
 */
public class Node {

	// node's data
	private int data;

	// single linked list next pointer
	private Node next;
	
	/**
	 * Build a new node with the value received
	 * 
	 * @param value
	 */
	public Node(int value) {
		data = value;
		next = null;
	}
	
	/**
	 * 
	 * @return node's next pointer
	 */
	public Node getNext() {
		return next;
	}
	
	/**
	 * 
	 * @param sets value as the pointer to the next node
	 */
	public void setNext(Node value) {
		next = value;
	}	
	
	/**
	 * 
	 * @return the node's data content
	 */
	public int getData() {	
		return data;
	}

}
