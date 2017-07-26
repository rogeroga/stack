/**
 * 
 * Main stack class that implements SweetStack interface
 * Uses two single linked lists to implement the main stack
 * A secondary stack is used to track of the max values pushed into the main stack
 * 
 */
package rogelio.stack;

/**
 * Implementation of the SweetStack interface
 * 
 * @author Rogelio
 */
public class Stack implements SweetStack {

	static public int STACK_EMPTY = -1;
	
	// Top of the stack
	private Node top;
	
	// Current size of the stack
	private int size;
	
	// Secondary stack used to track/store the max values pushed into the main stack 
	private MaxStack maxStack;
	
	/**
	 * Initialize a stack, set it as empty 
	 */
	public Stack() {
		
		top = null;
		size = 0;

		// create secondary stack
		maxStack = new MaxStack();
	}
	
	/**
	 * Push value into the stack
	 * 
	 * @param value
	 */
	@Override
	public void push(int value) {
		
		Node aNode = new Node(value);
		size = size + 1;
		
		if ( isEmpty() ) {
			top = aNode;
			
			maxStack.push(value);
		}
		else {
			aNode.setNext(top);
			top = aNode;
			
			// allow duplicates for max values
			// if duplicates are pushed into the main stack, allow that in secondary stack 
			if ( value >= maxStack.getTop().getData() ) {
				maxStack.push(value);
			}
		}
	}
	
	/**
	 * Takes the current top node and adjusts the single linked list used as a stack
	 * node's next value would be the new top and size is reduced
	 * 
	 * @return
	 */
	@Override
	public int pop() {
		
		if ( isEmpty() ) {
			return STACK_EMPTY;
		}
		
		Node aNode = top;
		
		top = top.getNext();
		size = size - 1;
		
		if ( aNode.getData() == maxStack.getTop().getData() ) {
			maxStack.pop();
		}
		
		return aNode.getData();
	}

	/**
	 * Returns stack size
	 * 0 if is empty
	 * 
	 * @return Node
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns the current max value pushed into the stack
	 * STACK_EMPTY(-1) if is empty
	 * 
	 * @return Node
	 */
	@Override
	public int max() {
		
		int value = STACK_EMPTY;
		Node aNode = maxStack.getTop();

		if ( aNode != null ) {
			 value = maxStack.getTop().getData();
		}
		
		return value;
	}

	/**
	 * Returns top node so it can be evaluated if a new max value is necessary
	 * null if the stack is empty
	 * 
	 * @return Node
	 */
	public Node getTop() {
		return top;
	}
		
	/**
	 * TRUE if the stack is empty, 
	 * FALSE otherwise
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return ( top == null );
	}
	
	/**
	 * Generates a string representation of the content of the stack
	 * for visualization/testing purposes
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
