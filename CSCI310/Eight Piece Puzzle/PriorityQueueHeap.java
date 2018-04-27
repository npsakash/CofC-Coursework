// CSCI 310 Advanced Algorithms
// Sebastian van Delden
//
// Skeleton Code for Eight Puzzle Assignment
//
/**
 * @author Neal Sakash
 * @since October 14, 2017
 * @version 1
 * HW 1 - CSCI 310 Fall 2017
 * PriorotyQueueHeap.java
 * Code has been modified from Professors's PriorityQueueHeap class
 */

import com.sun.xml.internal.bind.AnyTypeAdapter;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Collections;

public class PriorityQueueHeap<T extends Comparable<T>> extends PriorityQueue<T> {

	PriorityQueueHeap(){
		super();
	}
	
	public T PriorityDequeue() {
        // You must implement this...
        // NOTE: when swapping items in an ArrayList,
        // use Collections.swap()....

        if (getData().size() <= 0) {
            System.out.println("Unable to dequeue an empty heap");
            return null;
        } else {
            ArrayList list = getData();
            int length = getData().size();

            T temp = (T) list.get(0);
            //System.out.println("ROOT: "+getData().get(0));

            list.set(0, list.get(getData().size() - 1));
            //System.out.println("NEW ROOT: "+getData().get(0));

          if (list.size() == 1) {
                	//System.out.println("size 1");
                list.remove(0);
                return temp;
            } else if (list.size() == 2) {
                	//System.out.println("size 2");
                list.remove(length - 1);
                return temp;
            } else if (list.size() == 3) {
              //System.out.println(getData());
                //	System.out.println("size 3");

                list.remove(length - 1);
                return temp;
            } else {
                list.remove(length - 1);
                //System.out.println(getData());

                //parent, child variables
                int i = 0;
                int parent = i;
                int leftChild = 2 * i + 1;
                int rightChild = 2 * i + 2;

                //compare variables
                //int compareLeft = getData().get(parent).compareTo(getData().get(leftChild));
                //int compareRight = getData().get(parent).compareTo(getData().get(rightChild));

                //minHeapify

                while (list != null && getData().get(parent).compareTo(getData().get(leftChild)) > 0
                        || getData().get(parent).compareTo(getData().get(rightChild)) > 0) {
//			if ((getData().get(leftChild) != null) || (getData().get(rightChild) != null)) {
                    if (getData().get(leftChild).compareTo(getData().get(rightChild)) > 0) {
                        Collections.swap(list, parent, rightChild);
                    } else {
                        Collections.swap(list, parent, leftChild);
                    }
                    //System.out.println("Infinite Loop");

//			}
                }

                return temp;
            }
        }
    }




	public void PriorityEnqueue(Comparable<T> item) {
		// You must implement this...
		// NOTE: when swapping items in an ArrayList, 
		// use Collections.swap()....

		ArrayList list = getData();
		int length = getData().size();

		if (length == 0) {
			list.add((T) item);
		}

//		else if (item.compareTo(getData().get(0)) < 0){
//			list.add(0, (T) item);
//		}

		else {
			list.add(item);
			//int child = list.size() - 1;
			//int parent = (child - 1) / 2;

//			int child = length-1;
//			//int parent = (child-1)/2;
//			int parent = (int) Math.floor((child - 1) / 2);
//			for (int i = length-1; i >=0; i--){
//			while (getData().get(parent).compareTo(getData().get(child)) > 0) {
//				Collections.swap(list, parent, child);
//				child = length - 1;
//				//int parent = (child-1)/2;
//				parent = (int) Math.floor((child - 1) / 2);
//			}
//			}

			for (int i = length; i >= 0; i--) {
				int child = i;
				int parent = (int) Math.floor((child - 1) / 2);
				if (getData().get(parent).compareTo(getData().get(child)) > 0) {
					Collections.swap(list, parent, child);
				}
//				else{
//					break;
//				}
			}
//					for (int i = 0; i < list.size(); i++) {
//						Collections.swap(list, parent, child);
//						//child = list.size() - 1;
//						//parent = (child - 1) / 2;
//
//					}


//			//System.out.println("1  " + parent + " " + item + " " + child);
//			while (parent >= 0 && (getData().get(parent).compareTo(getData().get(child)) > 0)) {
//				//System.out.println("Swapping: " + parent + " Parent for Child: " + child);
//				Collections.swap(list, parent, child);
//				child = list.size() - 1;
//				parent = (child - 1) / 2;
//			}
		}


//		//enqueue empty ArrayList
//		if(length == 0){
//			list.add((T) item);
//		}
//
//		//Enqueue when is item is larger than parent
//		else if(item.compareTo(getData().get(0)) > 0){
//			getData().add(getData().size(), (T) item);
//			for (int i = 0; i < list.size()-1; i++){
//				int parent = i;
//				int child = i+1;
//				if(getData().get(parent).compareTo((T) getData().get(child)) > 0 ){
//					Collections.swap(getData(), parent, child);
//				}
//			}
//		}
//
//		//Enqueue when item is smaller than parent
//		else{
//			list.add(0,item);
//		}
//
//		int parent = list.indexOf(item);
//		int child = list.size()-1;
//
//		if(parent < child){
//			Collections.swap(list, child,parent);}
		}





//		/*int compare = element.compareTo( node.getElement() );
//
//		if ( compare == 0 ) {
//
//			throw new DuplicateElementException();
//
//		} else if ( compare < 0 ) {
//
//			if ( node.getLeft() == null ) {
//
//				node.setLeft( new BinaryNode<AnyType>( element ) );
//				node.getLeft().setParent( node );
//
//			} else {
//
//				add( node.getLeft(), element );
//
//			}
//
//		} else if ( compare > 0 ) {
//
//			if ( node.getRight() == null ) {
//
//				node.setRight( new BinaryNode<AnyType>( element ) );
//				node.getRight().setParent( node );
//
//			} else {
//
//				add( node.getRight(), element );
//
//			}
//
//		}*/
			}





