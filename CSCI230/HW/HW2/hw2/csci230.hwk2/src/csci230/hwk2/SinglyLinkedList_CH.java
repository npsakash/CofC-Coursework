package csci230.hwk2;

/**
 * Singly LinkedList Data Structure
 *
 * @author CSCI 230: Data Structures and Algorithms Spring 2017
 *
 * @param <AnyType>
 */
public class SinglyLinkedList_CH<AnyType extends Comparable> implements List<AnyType> {
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
        else getNode(size - 1).setNextNode(t);

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


        if (index < 0 || index > size()) throw new IndexOutOfBoundsException( "Index out of bounds." );

        if (index == size) {
            // case 1: add new node to the end of the linked list
            addNode(t);
        } else {
            if ( index == 0 && size > 0) {
                // case 2: add new node to the start of the linked list
                t.setNextNode(headNode);
                headNode = t;
            } else {
                // case 3: add new node to the middle of the list
                Node<AnyType> previousNode = getNode(index-1);

                if (index < size) {
                    t.setNextNode(previousNode.getNextNode());
                }

                previousNode.setNextNode(t);
            }
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

        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException( "Index out of bounds." );

        if (index == 0 && size == 1) {
            // case 1: set first node when size is 1
            headNode = t;
        } else if (index == 0 && size > 1) {
            // case 2: set first node when size is > 1
            t.setNextNode(headNode.getNextNode());
            headNode = t;
        } else {
            // case 3: set middle or last node

            Node<AnyType> previousNode = getNode(index-1);

            if (index + 1 < size) {
                // set pointer to nodes after the one at index
                t.setNextNode(previousNode.getNextNode().getNextNode());
            }

            previousNode.setNextNode(t);
        }



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
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException( "Index out of bounds." );

        Node<AnyType> returnNode = null;

        if (index == 0 && size == 1) {
            // case 1: remove the only node
            returnNode = headNode;
            headNode = null;
        } else if (index == 0) { // && size > 1
            // case 2: remove first node
            returnNode = headNode;
            headNode = headNode.getNextNode();
        } else {
            // case 3: remove middle or last node
            Node<AnyType> previousNode = getNode(index - 1);
            returnNode = previousNode.getNextNode();

            if (index + 1 < size) {
                previousNode.setNextNode(previousNode.getNextNode().getNextNode());
            } else {
                previousNode.setNextNode(null);
            }
        }
        size--;

        return returnNode;

    }// end removeNode() method

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
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException( "Index out of bounds." );
        Node<AnyType> currentNode = headNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;



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
            //System.out.println(sll.headNode);
           
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


        // end main() method

    }
}


// end SinglyLinkedList class definition

