package csci230.hwk2;
 
/**
 * Singly LinkedList Data Structure
 * 
 * @author CSCI 230: Data Structures and Algorithms Spring 2017 (Modified by Neal Sakash)
 * @since 1/26/2017
 * @version 1
 * HW 2 - CSCI 230.01
 * 
 *
 * @param <AnyType>
 */
public class SinglyLinkedList<AnyType extends Comparable> implements List<AnyType> {
    // instance variables
    private Node<AnyType> headNode = null;
    private int size = 0;

    /**
     * Appends the specified element to the end of this list.
     * 
     * @param t
     */
    public void add(AnyType t) {
        addNode(new Node<AnyType>(t));
    } // end add() method

    /**
     * implementation for public add(AnyType t) method
     * 
     * @param t
     */
    private void addNode(Node<AnyType> t) {
        if (isEmpty()) headNode = t;
        else getNode(size-1).setNextNode(t);

        size++;
    } // end addNote() method

    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void add(int index, AnyType t) throws IndexOutOfBoundsException {
    	addNode(index, new Node<AnyType>(t));
    } // end add() method
    
    /*
     * 
     * Implementation for public add(int index, AnyType t) method
     *
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    private void addNode(int index, Node<AnyType> t) throws IndexOutOfBoundsException {
    	/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
        if (index > size){
            throw new IndexOutOfBoundsException();
        }
        
        if(headNode == null){
            headNode = t;
            size++;
        }
        
        if(index == 0){
            t.setNextNode(headNode);
            headNode = t;
            size++;
        }
        
        else{
            Node<AnyType> temp = getNode(index-1);
            t.setNextNode(temp.getNextNode());
            temp.setNextNode(t);
            size++;
        }
        
    } // end addNode() method
 
    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    public void set(int index, AnyType t) throws IndexOutOfBoundsException {
        setNode(index, new Node<AnyType>(t));
    } // end set() method
    
    /**
     * 
     * Implementation for public set(int index, AnyType t) method
     *
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    private void setNode(int index, Node<AnyType> t) throws IndexOutOfBoundsException {
    	/**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
        if (index > size){
            throw new IndexOutOfBoundsException();
        }
        
        else if(index == 0)
            headNode = t;
        
        else
            getNode(index-1).setNextNode(t);

    } // end setNode() method

 
    /**
     * Removes the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType remove(int index) throws IndexOutOfBoundsException {
    	return removeNode(index).getData();
    } // end remove() method
    
    /**
     *
     * Implementation for public remove(int index) method
     *
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    private Node<AnyType> removeNode(int index) throws IndexOutOfBoundsException {
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
        if (index > size-1){
            throw new IndexOutOfBoundsException();
        }
        
        Node<AnyType> returnNode;
        if(index == 0){
            returnNode = headNode;
            headNode = getNode(index + 1);
        
            size--;
        }
        
        else if( index == size-1){
            returnNode = getNode(index);
            getNode(index-1).setNextNode(null);
            size--;
        }
        
        else{
            returnNode = getNode(index);
            Node<AnyType> tempNode = getNode(index-1);
            tempNode.setNextNode(getNode(index+1));
            size--;
        }
        
        return returnNode;
        
        
    } // end removeNode() method
 
    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType get(int index) throws IndexOutOfBoundsException {
    	return getNode(index).getData();
    } // end get() method
    
    /**
     *
     * Implementation for public get(int index) method
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    private Node<AnyType> getNode(int index) throws IndexOutOfBoundsException {
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
        
        Node<AnyType> returnNode;
        if (index > size-1){
            throw new IndexOutOfBoundsException();
        }
        
        
        else if(index == 0){

            returnNode = headNode;
            
        }
        
       
        else{

            Node<AnyType> current = headNode;
            int count = 0;
            while(count < index ){

                current = current.getNextNode();

                count ++;
                
            }
            returnNode = current;
            
        }
       return returnNode;
        
        
    } // end getNode() method
 
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
        return (size == 0) ? true : false;
    } // end isEmpty() method
     
     
    /**
     * Removes all of the elements from this list.
     * 
     */
    public void clear() {
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
        headNode = null;
        size = 0;
    } // end clear method
     
     
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
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        
        try{
            //for loop for adding integers to linked list
            System.out.println("For loop for adding integers to linked list");
            for(int i = 0; i <= 5; i++){
                sll.add(i, i + 10);
                int current = sll.get(i);
                System.out.println("Element " + i +": " + current);
            }
            System.out.println();//space
           
            //for loop for removing integers from linked list
            System.out.println("For loop for removing integers from linked list: ");
            for(int i = 5; i >= 0; i--){
                sll.remove(i);
                System.out.println("Elements in linked list: ");
                for(int j = 0; j < sll.size()-1; j++){
                    int current = sll.get(j);
                System.out.println("Element " + j +": " + current);
                }
                System.out.println();
            }
            System.out.println();//space
            
            //for loop for adjusting values
            System.out.println("For loop for adjusting values in linked list");
            System.out.println("Original linked list: ");
            for(int i = 0; i <= 5; i++){
                sll.add(i, i + 10);
                int current = sll.get(i);
                System.out.println("Element " + i +": " + current);
            }
            System.out.println();//space
            
            System.out.println("Adjusted linked list: ");
            for(int i = 0; i < sll.size()-1; i++){
                sll.set(i, i + 20);
                int current = sll.get(i);
                System.out.println("Element " + i +": " + current);
            }
            System.out.println();//space
            
            //use of the clear method
            System.out.println("Use of the clear() method: ");
            System.out.println("Original linked list: ");
            for(int i = 0; i <= 5; i++){
                sll.add(i, i + 10);
                int current = sll.get(i);
                System.out.println("Element " + i +": " + current);
            }
            System.out.println();//space
            
            sll.clear();//clears linked list
            
            System.out.println("Linked list after sll.clear(): ");
            System.out.println(sll.headNode);
           
        }
        
        catch(IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        //Exception testing for get() method
        try{
        System.out.println();//space
        System.out.println("Exception test for get() method");
        sll.get(10);
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        //Exception testing for add() method        
        try{
        System.out.println();//space
        System.out.println("Exception test for add() method");
        sll.add(10, 10);
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println(e);
        }

        //Exception testing for remove() method        
        try{
        System.out.println();//space
        System.out.println("Exception test for remove() method");
        sll.remove(10);
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        
        //Exception testing for set() method
        try{
        System.out.println();//space
        System.out.println("Exception test for set() method");
        sll.set(10, 10);
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    
    } // end main() method
  
} // end SinglyLinkedList class definition
