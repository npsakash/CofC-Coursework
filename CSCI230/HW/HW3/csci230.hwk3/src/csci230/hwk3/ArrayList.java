package csci230.hwk3;

/**
 * ArrayList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Spring 2017 
 * (Modified by Neal Sakash)
 * @since 2/2/2017
 * @version 1
 * HW 3 - CSCI 230.01
 * 
 *
 * @param <AnyType>
 */
public class ArrayList<AnyType extends Comparable> implements List<AnyType> {
     
    // instance variables
    private Object[] array;
    private int size = 0;
    private final static int INITIAL_CAPACITY = 10;
    private int capacity = INITIAL_CAPACITY;
    
    /**
     * Constructs an empty list with an initial capacity
     * (for this assignment initial capacity is 10 - see 
     * constant instance variable)
     * 
     */
    public ArrayList() {
    	
    	array = new Object[ INITIAL_CAPACITY ];
    	
    } // end constructor
 
    /**
     * Appends the specified element to the end of this list.
     * 
     * @param t
     */
    public void add( AnyType t) {
         
    	if ( size >= capacity )
    		grow();
    	
    	array[size]=t;
        size++;
         
    } // end add() method
    
    
    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, AnyType t) throws IndexOutOfBoundsException {
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
        */
        
        if (index < 0 || index > size()){
            throw new IndexOutOfBoundsException();
        }
        else if(size >= capacity)
            grow();
        
        for(int i = size-1; i>=index; i--){
            array[i+1] = array[i];
        }
        array[index] = t;        
        size++;
        
    }// end add() method

    /**
     * Replaces the element at the specified position in this list with the 
     * specified element.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void set(int index, AnyType t) throws IndexOutOfBoundsException {
         /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
        if (index < 0 || index > size()){
            throw new IndexOutOfBoundsException();
        }
        array[index] = t;
    } // end set() method
 
    /**
     * Removes the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    @SuppressWarnings("unchecked")
	public AnyType remove( int index ) throws IndexOutOfBoundsException {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation 
         * available in the Java API) to perform left or right
         * shift operations
         * 
         */

        if (index < 0 || index > size()){
            throw new IndexOutOfBoundsException();
        }
        else if(size < capacity/2)
            shrink();
        
        AnyType removed = (AnyType) array[index];
        
        for(int i = index; i <= size-1; i++){
            array[i] = array[i+1];
        }
        size--;
    	return removed;
    } // end remove() method
 
    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    @SuppressWarnings("unchecked")
    public AnyType get(int index) throws IndexOutOfBoundsException {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */

        if (index < 0 || index > size()){
            throw new IndexOutOfBoundsException();
        }    
    return (AnyType) array[index];
    } // end get() method
 
    /**
     * Returns the number of elements in this list. 
     * 
     * @return
     */
    public int size() {
         
        return size;
         
    } // end size() method
 
    /**
     * Returns true if this list contains no elements.
     * 
     * @return
     */
    public Boolean isEmpty() {
         
        return ( size == 0 );
         
    } // end isEmpty() method
     
     
    /**
     * Removes all of the elements from this list.
     * and the initial capacity is set back to 10
     * 
     */
    public void clear() {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
        
        for (int i = 0; i < size; i++){
            array[i] = null;
        }

        size = 0;

    } // end clear method
    
    /**
     * Double the capacity of the array
     * 
     */
    private void grow() {
    	
    	/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation 
         * available in the Java API)
         * 
         */
        
        int oldCapacity = capacity;
        
        int newCapacity = oldCapacity * 2;
        
        Object[] newArray = new Object[newCapacity];
        
        for (int i=0; i < capacity; i++){
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    } // end grow() method
    
    
    /**
     * Half the capacity of the array
     * 
     */
    private void shrink() {
    	
    	/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation 
         * available in the Java API)
         * 
         */
        
        int oldCapacity = capacity;
        int newCapacity = oldCapacity / 2;
        
        Object[] newArray = new Object[newCapacity];
        for(int i = 0; i <= size-1; i++){
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    } // end shrink() method
     
     
    /**
     * 
     * @param args
     */
    public static void main( String[] args ) {
         ArrayList<Integer> mal = new ArrayList<>();
         /**
         * -------------------------------------------
         * TODO: Put your test cases here
         * 
         */
         
        try{

           System.out.println("Test cases for ArrayList.java methods");
           System.out.println();//space

           //add ten integers to the array
           System.out.println("----------------------------------------------");
           System.out.println("Add 10 elements to the array");
           for(int i = 0; i <= 10; i++){
               mal.add(i+10);
           }
           System.out.println("----------------------------------------------");

           System.out.println();//space

           //return elements of the array
           System.out.println("----------------------------------------------");
           System.out.println("Return elements in the array");
           System.out.println("Results:");
           for(int i =0; i <= mal.size(); i++){
               System.out.println("Element at " + i + " " + mal.get(i));
           }
           System.out.println("----------------------------------------------");

           System.out.println();//space

           //Insert elements into a particular position in the array
           System.out.println("----------------------------------------------");
           System.out.println("Insert elements at beginning, middle, and end "
                   + "of the array");
           mal.add(0,100);
           mal.add(mal.size/2, 150);
           mal.add(mal.size, 200);
           System.out.println("Results:");
           for(int i =0; i <= mal.size(); i++){
               System.out.println("Element at " + i + " " + mal.get(i));
           }
           System.out.println("----------------------------------------------");

           System.out.println();//space

           //Remove elements at a particular position in the array
           System.out.println("----------------------------------------------");
           System.out.println("Remove elements at beginning, middle, and end "
                   + "of the array");
           System.out.println("Results:");
           mal.remove(0);
           mal.remove(mal.size/2-1);
           mal.remove(mal.size-1);
           for(int i =0; i <= mal.size(); i++){
               System.out.println("Element at " + i + " " + mal.get(i));
           }
           System.out.println("----------------------------------------------");

           System.out.println();//space

           //Set elements at a particular position in the array
           System.out.println("----------------------------------------------");
           System.out.println("Set elements at beginning, middle, and end of "
                   + "the array:");
           System.out.println("Results:");
           mal.set(0,100);
           mal.set(mal.size/2,150);
           mal.set(mal.size-1,200);
           for(int i =0; i <= mal.size(); i++){
               System.out.println("Element at " + i + " " + mal.get(i));
           }
           System.out.println("----------------------------------------------");

           System.out.println();//space

           //test for grow() and shrink() methods
           System.out.println("----------------------------------------------");
           System.out.println("Test grow() and shrink() methods in the array");
           System.out.println("Array capacity before calling grow(): " 
                   + mal.array.length);
           mal.grow();
           System.out.println("Array capacity after calling grow(): " 
                   + mal.array.length);
           mal.shrink();
           System.out.println("Array capacity after calling shrink(): " 
                   + mal.array.length);
           System.out.println("----------------------------------------------");

           System.out.println();//space

          //Test clear() method
          System.out.println("-----------------------------------------------");
           System.out.println("Test clear() method in the array");
           System.out.println("Array before calling clear(): "); 
           for(int i =0; i <= mal.size(); i++){
               System.out.println("Element at " + i + " " + mal.get(i));
           }
           mal.clear();
           System.out.println("Array after calling clear(): ");
           for(int i =0; i <= mal.size(); i++){
               System.out.println("Element at " + i + " " + mal.get(i));
           }
           System.out.println("----------------------------------------------");

           System.out.println();//space

           System.out.println("Test cases for ArrayList.java methods "
                   + "completed");

           System.out.println();//space
           System.out.println("----------------------------------------------");
           System.out.println("----------------------------------------------");
           System.out.println();//space
        }

        catch(IndexOutOfBoundsException e) {
           System.out.println(e);
       }

        System.out.println("Test cases for exception handling in "
                + "ArrayList.java methods");
        System.out.println();//space

        //Exception testing for get() method
       try{
       System.out.println("Exception test for get() method");
       mal.get(-15);
       mal.get(15);
       }
       catch(IndexOutOfBoundsException e) {
           System.out.println(e);
       }

       //Exception testing for add() method        
       try{
       System.out.println();//space
       System.out.println("Exception test for add() method");
       mal.add(-25, 100);
       mal.add(25, 100);
       }
       catch(IndexOutOfBoundsException e) {
           System.out.println(e);
       }

       //Exception testing for remove() method        
       try{
       System.out.println();//space
       System.out.println("Exception test for remove() method");
       mal.remove(-25);
       mal.remove(25);
       }
       catch(IndexOutOfBoundsException e) {
           System.out.println(e);
       }

       //Exception testing for set() method
       try{
       System.out.println();//space
       System.out.println("Exception test for set() method");
       mal.set(-25, 100);
       mal.set(25, 100);
       }
       catch(IndexOutOfBoundsException e) {
           System.out.println(e);
       }
       
       System.out.println();//space
       
       System.out.println("Test cases for exception handling in "
        + "ArrayList.java methods completed");
       
    } // end main() method
  
} // end ArrayList class definition
