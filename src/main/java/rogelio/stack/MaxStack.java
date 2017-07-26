/**
 * MaxStack, secondary stack to store the max values 
 * that have been pushed into the main class Stack
 * 
 */
package rogelio.stack;

/**
 * MaxStack, the secondary stack 
 * 
 * @author Rogelio  
 */
public class MaxStack {

	// top value of the stack
	private Node top;
	
	// current size of the stack
	private int size;
	
	
	public MaxStack() {
		top = null;
		size = 0;
	}
	
	/**
	 * Pushes a value into the stack
	 * Creates a new node and adds it to the single linked list
	 *  
	 * @param value
	 */
	public void push(int value) {
		
		Node aNode = new Node(value);
		size = size + 1;
		
		if ( isEmpty() ) {
			top = aNode;
		}
		else {
			aNode.setNext(top);
			top = aNode;
		}
	}
	
	/**
	 * Takes the current top node and adjusts the single linked list used as a stack
	 * node's next value would be the new top and size is reduced
	 * 
	 * @return Node
	 */
	public Node pop() {
		
		if ( isEmpty() ) {
			return null;
		}
		
		Node aNode = top;
		top = top.getNext();
		size = size - 1;
		
		return aNode;
	}

	/**
	 * Returns top node so it can be evaluated if a new max value is necessary
	 * null if the stack is empty
	 * 
	 * @return Top Node
	 */
	public Node getTop() {
		return top;
	}

	/**
	 * Returns stack size
	 * 0 if is empty
	 * 
	 * @return int
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 
	 * @return TRUE if the stack is empty, FALSE otherwise
	 */
	public boolean isEmpty() {
		return ( top == null );
	}
	
	/**
	 * Generates the string representation of the content of the stack
	 * for debug/test purposes
	 * 
	 */
	public String toString() {
		
		StringBuffer out = new StringBuffer();
	
		Node aNode = top;
		while ( aNode != null ) {
			
			out.append( String.valueOf( aNode.getData()) );
			out.append(" ");
			
			aNode = aNode.getNext();
		}
		
		return out.toString();
	}
	
}
