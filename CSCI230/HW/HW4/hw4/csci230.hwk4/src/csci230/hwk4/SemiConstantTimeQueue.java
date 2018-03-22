package csci230.hwk4;

import java.util.NoSuchElementException;

/**
 * A semi-constant time FIFO queue. The time complexity for 
 * the interface methods are:
 * ----------------------------------
 * 1) add: O(1) - not considering capacity resize operations
 * 2) remove: O(n) - not considering capacity resize operations
 * 3) peek: O(1)
 * 
 * Please note: the above time complexities do not factor in
 * capacity resize (grow and shrink) operations. Even though
 * capacity resize operations will occur, for this assignment 
 * you may assume the are negligible.
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
public class SemiConstantTimeQueue<AnyType extends Comparable> implements Queue<AnyType> {
	
	/**
	 * private instance variables
	 */
	private ArrayList<AnyType> list = new ArrayList<AnyType>();


	/**
	 * Inserts the specified element at the end of the queue in 
	 * constant time O(1)
	 * 
	 * @param t element to add
	 * @throws NullPointerException- if the specified element is null 
	 *                               (queue does not permit null elements)
	 */
	public void add(AnyType t) throws NullPointerException {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your add solution must be a constant 
         * time O(1) operation (not considering capacity 
         * resize operations)
         * 
         */
                
            if(list == null || t == null){
                throw new NullPointerException();
            }
            list.add(list.size(),t);
//          if (list.size() == 0){
//                list.add(t);
//            }
//            else
//                list.add(list.size(), t);
//            
	} // end add() method

	/**
	 * Retrieves and removes the head of the queue in
	 * linear time O(n).
	 * 
	 * Hint: shift operations will make this a linear time
	 * operation.
	 * 
	 * @return the head of the queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public AnyType remove() throws NoSuchElementException {
		
		/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your push solution must be a linear 
         * time O(n) operation. See hint above.
         * 
         *
         */
            if(list.isEmpty()){
                throw new NoSuchElementException();
            }
//            else{
//                int top = -1;
//                top = (top +1)%list.size();
//            }
            else
                return list.remove(0);
	} // end remove() method

	/**
	 * Retrieves, but does not remove, the head of the queue, 
	 * or returns null if this queue is empty.
	 * 
	 * @return the head of this queue, or null if this queue is empty
	 */
	public AnyType peek() {
            	
	/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Note: Your add solution must be a constant 
         * time O(1) operation 
         * 
         */
            if(list.isEmpty()){
                return null;
            }
            else
                return list.get(0);
	} // end peek() method
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
         * -------------------------------------------
         * TODO: You put your test cases here
         * 
         */
	        SemiConstantTimeQueue<Integer> scts = new SemiConstantTimeQueue();
                SemiConstantTimeQueue<Integer> scts2 = null;
        try{
            System.out.println("Test cases for SemiConstantTimeQueue.java "
                    + "methods");
            System.out.println();//space

            //add five integers to the list
            System.out.println("----------------------------------------------");
            System.out.println("add 5 elements to the queue and peek with "
                       + "each addition");
                for(int i = 0; i < 5; i++){
                scts.add(i+10);
                System.out.println("Element added: " + (i+10));
                }
            System.out.println("----------------------------------------------");
            System.out.println();//space
            System.out.println("----------------------------------------------");

            System.out.println("Peek top of queue and remove the element");
            System.out.println();//space
            for(int i = 0; i<5; i++){
                System.out.println("Element at top of queue: " + scts.peek());
                scts.remove();
                System.out.println("Element has been removed");
                System.out.println("New element at top of queue: " + scts.peek());
                System.out.println();//space
            }
            System.out.println("----------------------------------------------");
            System.out.println();
            System.out.println("----------------------------------------------");

        }
        catch(NullPointerException e) {
            System.out.println(e);
        }

        System.out.println("Test cases for exception handling in "
            + "SemiConstantTimeQueue.java methods");
        System.out.println();//space

        //Exception testing for get() method
        try{
            System.out.println("Exception test for remove() method");
            System.out.println("Element on top of queue before remove: " 
                    + scts.peek());
            System.out.println("Exception: " + scts.remove());
        }
        catch(NoSuchElementException e) {
           System.out.println(e);
        }

        System.out.println();
        
        //Exception testing for add() method        
        try{
            System.out.println("Exception test for add() method");
            //scts2 is a null object
            scts2.add(10);
            
        }
        catch(NullPointerException e) {
            System.out.println(e);
        }


   System.out.println();//space

   System.out.println("Test cases for exception handling in "
    + "ConstantTimeStack.java methods completed");	
		

	} // end main() method

} // end ConstantTimeQueue class definition
