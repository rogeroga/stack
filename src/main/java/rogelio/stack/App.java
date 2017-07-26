package rogelio.stack;

import java.io.Console;

/**
 * Simple console app to demo the stack implementation
 *  
 * @author Rogelio  
 */
public class App 
{
	
    public static void main( String[] args )
    {
    	App app = new App();
    	Stack stack = new Stack();
		int choice, value;
		
    	while ( true ) {
    		System.out.println("\nSTACK"); 
    		System.out.println("Please select your choice\n");
    		System.out.println(" 1 Push \n 2 Pop \n 3 Get Current Max Value \n 4 Get Current Size of the Stack \n 5 Display Stack Content \n 6 Exit \n");
    		System.out.println("Type your numeric choice number: ");
    		
    		choice = app.getIntFromConsole();
    		System.out.println();
    	    
    		switch ( choice ) {
	    		case 1 :
	    			// PUSH
    				System.out.println("Enter push value: ");
	    			value = app.getIntFromConsole();
	    			if ( value != Stack.STACK_EMPTY ) {
	    				stack.push(value);
	    			}
	    			else {
	    				System.out.println("That is an invalid value, please use a different one"); 
	    			}
	    			
	    			break;
	    			
	    		case 2 :
	    			// POP
	    			value = stack.pop();
	    			if ( value == Stack.STACK_EMPTY ) {
	    				System.out.println("The stack is empty, no elements to get");
	    			}
	    			else {
	    				System.out.println("Popped value: " + value);
	    			}
	    			break;
	    			
	    		case 3 :
	    			// MAX
	    			value = stack.max();
	    			if ( value == Stack.STACK_EMPTY ) {
	    				System.out.println("The stack is empty, no max value");
	    			}
	    			else {
	    				System.out.println("Current maximum value in the stack: " + value);
	    			}
	    			break;

	    		case 4 :
	    			// SIZE
	    			value = stack.size();
	    			if ( value == 0 ) {
	    				System.out.println("The stack is empty, stack size is 0 (zero)");
	    			}
	    			else {
	    				System.out.println("Current stack's size: " + value);
	    			}
	    			break;

	    		case 5 :
	    			// DISPLAY
	    			String content = stack.toString();
	    			if ( content.isEmpty() ) {
	    				System.out.println("The stack is empty, doeesn't have any content");
	    			}
	    			else {
	    				System.out.println("Stack content, leftmost value is top and moves to the right towards the bottom: ");
	    				System.out.println(content);
	    			}
	    			break;
	    			
	    		case 6 :
	    			// EXIT
    				System.out.println("Finishing console app, bye!");
	    			System.exit(1);
	    			break;
	    		
	    		default :
	    			break;
    		
    		}
    		
    	}
        
    }
    
    /**
     * 
     * @return An integer obtained from the console
     */
    public int getIntFromConsole() {
    	Console console = System.console();
    	int result = -1;
    	
		try {
			String input = console.readLine(); 
			result = Integer.valueOf(input);
		}
		catch ( Throwable ex ) {
			
		}
		
		return result;
    }
    
}
