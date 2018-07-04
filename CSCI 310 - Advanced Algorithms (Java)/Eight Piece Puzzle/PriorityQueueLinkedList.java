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
 * PriorityLinkedList.java
 * Code has been modified from Professors's PriorityLinkedList class
 */

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PriorityQueueLinkedList<T extends Comparable<T>> extends PriorityQueue<T>{
	
	PriorityQueueLinkedList(){
		super();
	}
	
	public T PriorityDequeue(){
		// You must implement this...
		ArrayList list = getData();
		int length = getData().size();
		if (getData().size() < 0) {
			System.out.println("Unable to dequeue an empty Linked List");
			return null;
		}
		else{
			return getData().remove(0);
		}
	}
	
	public void PriorityEnqueue(Comparable<T> item){
		// You must implement this...

		int length = getData().size();
		//enqueue empty ArrayList
		if(length == 0){
			getData().add((T) item);
		}
		//enqueue at end
		else if (getData().get(length-1).compareTo((T) item)<=0){
			getData().add((T) item);
		}
		//enqueue at zero
		else if(getData().get(0).compareTo((T) item) >= 0){
			getData().add(0,(T) item);
		}
		//enqueue in ordered index
		else {
			int k = length - 1;
			while (getData().get(k).compareTo((T) item) > 0 && k > 0) {
				k = k - 1;
				getData().add(k + 1, (T) item);
			}
		}
		}
}
