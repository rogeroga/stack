/**
 * 
 * Implement a Stack data structure for primitive int values with the following requirements:
 *
 *       a.  There should be no limit to the amount of nodes that are placed into the stack.
 *       b.  The Stack should implement the following interface all with O(1) complexity
 *       c.  Don’t use existing Java data structure APIs (no ArrayLists, etc).  Do it by hand
 *       
 */
package rogelio.stack;

/**
 * Stack interface
 * 
 */
public interface SweetStack {

    public void push(int val); //pushes the value into the stack
    
    public int pop(); //pops the top of the stack and returns it
    
    public int size(); //returns the size of the stack
    
    public int max(); //returns the current max in the stack
	
}
