/**
 * Tests for secondary stack implementation
 * 
 */
package rogelio.stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Unit tests for stack used to track maximum element in the stack
 * 
 * @author Rogelio
 */
public class MaxStackTest {

	static private int INITIAL_STACK_SIZE = 50;
	
	static private int HUGE_STACK_SIZE = 1_000_000;
	
	private MaxStack stack;

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	/**
	 * Create an avg. size stack and verify that its size matches 
	 * 
	 */
	@Test
	public final void testIsStackSizeEqualToInitialSize() {
		stack = new MaxStack();
		
		for(int i = 0; i < INITIAL_STACK_SIZE; i++) {
			stack.push(i);
		}
				
		assertTrue( stack.getSize() == INITIAL_STACK_SIZE );
	}

	/**
	 * Create a large stack, test it halfway through and at the end
	 * 
	 */
	@Test
	public final void testCanAHugeStackBeCreated() {
		stack = new MaxStack();
		
		for(int i = 0; i < HUGE_STACK_SIZE / 2; i++) {
			stack.push(i);
		}

		assertFalse( stack.isEmpty());
		assertTrue( stack.getSize() == HUGE_STACK_SIZE / 2);
		
		for(int i = HUGE_STACK_SIZE / 2; 
				i < HUGE_STACK_SIZE; i++) {
			stack.push(i);
		}
		
		assertFalse( stack.isEmpty());
		assertTrue( stack.getSize() == HUGE_STACK_SIZE );

	}
	
	/**
	 * Stack should be empty after populating and emptying it 
	 * 
	 */
	@Test
	public final void testStackIsEmpty() {
		stack = new MaxStack();
		
		for(int i = 0; i < INITIAL_STACK_SIZE; i++) {
			stack.push(i);
		}
				
		for(int i = 0; i < INITIAL_STACK_SIZE; i++) {
			stack.pop();
		}

		assertTrue( stack.isEmpty() );
	}
	

	/**
	 * Stack should return null for an underflow condition
	 * 
	 */
	@Test
	public final void testStackUnderFlow() {
		stack = new MaxStack();
		
		stack.push(10);
		stack.push(17);
		
		Node n = stack.pop();
		assertTrue( n.getData() == 17);

		n = stack.pop();
		assertTrue( n.getData() == 10);
		
		n = stack.pop();
		assertTrue( n == null);
		
		n = stack.pop();
		assertTrue( n == null);
		assertTrue( stack.isEmpty() );
	}
	
	@Test
	public final void testVisualizeStackContent() {
		stack = new MaxStack();
		
		for(int i = 0; i < INITIAL_STACK_SIZE; i++) {
			stack.push(i);
		}
		
		String str = stack.toString();
		System.out.println("Stack content: " + str);
	}

}
