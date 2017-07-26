/**
 * Tests for Stack, implements the SweetStack interface
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
public class StackTest {

	private Stack stack;
	
	static private int INITIAL_STACK_SIZE = 50;
	
	static private int HUGE_STACK_SIZE = 1_000_000;

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
		stack = new Stack();
		
		for(int i = 0; i < INITIAL_STACK_SIZE; i++) {
			stack.push(i);
		}
				
		assertTrue( stack.size() == INITIAL_STACK_SIZE );
	}

	/**
	 * Create a large stack, test it halfway through and at the end
	 * The maximum size of the stack depends on the JVM memory parameters
	 * If more memory is required than the JVM parameters
	 * this program would generate an OutOfMemory Error and exit
	 * To fix this a JVM with upgraded memory parameters should be launched the next time
	 *
	 */
	@Test
	public final void testCanAHugeStackBeCreated() {
		stack = new Stack();
		
		for(int i = 0; i < HUGE_STACK_SIZE / 2; i++) {
			stack.push(i);
		}

		assertFalse( stack.isEmpty());
		assertTrue( stack.size() == HUGE_STACK_SIZE / 2 );
		
		for(int i = HUGE_STACK_SIZE / 2; 
				i < HUGE_STACK_SIZE; i++) {
			stack.push(i);
		}
		
		assertFalse( stack.isEmpty());
		assertTrue( stack.size() == HUGE_STACK_SIZE );

	}
	
	/**
	 * Stack should be empty after populating and emptying it 
	 * 
	 */
	@Test
	public final void testStackIsEmpty() {
		stack = new Stack();
		
		for(int i = 0; i < INITIAL_STACK_SIZE; i++) {
			stack.push(i);
		}
				
		for(int i = 0; i < INITIAL_STACK_SIZE; i++) {
			stack.pop();
		}

		assertTrue( stack.isEmpty() );
	}

	/**
	 * Stack should be empty after populating and emptying it 
	 * 
	 */
	@Test
	public final void testStackMaxValueMatching() {
		stack = new Stack();
		
		for(int i = 0; i < INITIAL_STACK_SIZE; i++) {
			stack.push(i);
		}
		
		// The loop in reverse order should match all the max values 
		// all the way to very first element pushed
		for(int i = INITIAL_STACK_SIZE - 1; i >=0; i--) {
			
			assertTrue( i == stack.max() );
			stack.pop();
		}

		assertTrue( stack.isEmpty() );
	}
	
	/**
	 * Stack should return error value in an underflow condition
	 * 
	 */
	@Test
	public final void testStackUnderFlow() {
		stack = new Stack();
		
		stack.push(10);
		stack.push(17);
		
		int n = stack.pop();
		assertTrue( n == 17 );

		n = stack.pop();
		assertTrue( n == 10 );
		
		n = stack.pop();
		assertTrue( n == Stack.STACK_EMPTY );
		
		n = stack.pop();
		assertTrue( n == Stack.STACK_EMPTY );
		assertTrue( stack.isEmpty() );
	}

	/**
	 * Verify that duplicated max values can be handled
	 * 
	 */
	@Test
	public final void testDuplicatedMaxValues() {
		stack = new Stack();
		int n;
		
		stack.push(10);
		stack.push(20);
		stack.push(20);
		stack.push(30);
		stack.push(30);
		
		// verify max
		assertTrue( stack.max() == 30 );
		
		// verify that max is still the duplicated value of 30
		stack.pop();
		assertTrue( stack.max() == 30 );
		
		// verify that max value now is 20
		stack.pop();	
		assertTrue( stack.max() == 20 );

		// pop all 20s
		stack.pop();
		stack.pop();
		
		// verify that max value now is 10
		assertTrue( stack.max() == 10 );
	
		// pop 10
		stack.pop();
		
		// empty the stack
		n = stack.pop();
		assertTrue( n == Stack.STACK_EMPTY );
		assertTrue( stack.isEmpty() );
	}

	@Test
	public final void testVisualizeStackContent() {
		stack = new Stack();
		
		for(int i = 0; i < INITIAL_STACK_SIZE; i++) {
			stack.push(i);
		}
		
		String str = stack.toString();
		System.out.println("Stack content: " + str);
		assertTrue(str != null);
	}

}

