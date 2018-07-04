package csci230.hwk4;

import java.util.EmptyStackException;

/**
 * A LIFO stack that has constant time complexity O(1) for
 * all three stack interface methods (i.e., push, pop, and 
 * peek).
 * 
 * This data structure was discussed in class along with the 
 * operations, please review your notes.
 * 
 * @author CSCI 230: Data Structures and Algorithms Spring 2017 
 * (Modified by Neal Sakash)
 * @since 2/15/2017
 * @version 1
 * HW 4 - CSCI 230.01
 *
 * @param <AnyType>
 */
public class ConstantTimeStack<AnyType extends Comparable> implements Stack<AnyType>{
	
	/**
	 * private instance variables
	 */
	private SinglyLinkedList<AnyType> list = new SinglyLinkedList<AnyType>();

	/**
	 * Pushes an item onto the top of this stack in constant 
	 * time O(1)
	 * 
	 * @param t the item to be pushed onto this stack.
	 */
	public void push(AnyType t) {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your push solution must be a constant 
         * time O(1) operation
         * 
         */
            list.add(0,t);
		
	} // end push() method

	/**
	 * Removes the object at the top of this stack and return the 
	 * item in constant time O(1)
	 * .
	 * @return The item at the top of this stack
	 * @throws EmptyStackException - if this stack is empty.
	 */
	public AnyType pop() throws EmptyStackException {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your pop solution must be a constant 
         * time O(1) operation
         * 
         */
            if(list.isEmpty()){
                throw new EmptyStackException();
            }
            else
                return list.remove(0);
		
		
	} // end pop() method

	/**
	 * Looks at the item at the top of this stack without removing it 
	 * from the stack in constant time O(1)
	 * 
	 * @return the item at the top of this stack
	 * @throws EmptyStackException  - if this stack is empty.
	 */
	public AnyType peek() throws EmptyStackException {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your peek solution must be a constant 
         * time O(1) operation
         * 
         */
            if(list.isEmpty()){
                throw new EmptyStackException();
            }
            else
		return list.get(0);
		
	} // end peek() method
	
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
		
		/**
         * -------------------------------------------
         * TODO: You put your test cases here
         * 
         */
        ConstantTimeStack<Integer> cts = new ConstantTimeStack();
        try{
            System.out.println("Test cases for ConstantTimeStack.java "
                    + "methods");
            System.out.println();//space

            //add ten integers to the array
            System.out.println("----------------------------------------------");
            System.out.println("Push 5 elements to the stack and peek with "
                       + "each addition");
                for(int i = 0; i < 5; i++){
                cts.push(i+10);
                System.out.println("Element " + (i+1) + " pushed: " + cts.peek());
                }
            System.out.println("----------------------------------------------");
            System.out.println();//space
            System.out.println("----------------------------------------------");

            System.out.println("Peek top of stack and remove the element");
            System.out.println();//space
            for(int i = 0; i<5; i++){
                System.out.println("Element at top of stack: " + cts.peek());
                cts.pop();
                System.out.println("Element has been removed");
                System.out.println("New element at top of stack: " + cts.peek());
                System.out.println();//space
            }
            System.out.println("----------------------------------------------");
            System.out.println();
            System.out.println("----------------------------------------------");

        }
        catch(EmptyStackException e) {
            System.out.println(e);
        }

        System.out.println("Test cases for exception handling in "
            + "ConstantTimeStack.java methods");
        System.out.println();//space

        //Exception testing for get() method
        try{
            System.out.println("Exception test for pop() method");
            System.out.println("Element on top of stack before pop: " 
                    + cts.peek());
            cts.pop();
            System.out.println("Exception: " + cts.pop());
        }
        catch(IndexOutOfBoundsException e) {
           System.out.println(e);
        }

        System.out.println();
        
        //Exception testing for peek() method        
        try{
            System.out.println("Exception test for peek() method");
            System.out.println("Element on top of stack: " 
                    + cts.peek());
            cts.pop();
            cts.pop();
            System.out.println("Exception: ");
            cts.peek();
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println(e);
        }


   System.out.println();//space

   System.out.println("Test cases for exception handling in "
    + "ConstantTimeStack.java methods completed");

    } // end main method

} // end ConstantTimeStack class definition
