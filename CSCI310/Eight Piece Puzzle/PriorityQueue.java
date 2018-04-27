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
 * PriorityQueue.java
 * Code has been modified from Professors's PriorityQueue class
 */

import java.util.ArrayList;

public abstract class PriorityQueue<T> {

	private ArrayList<T> data;
	
	PriorityQueue(){
		this.data = new ArrayList<T>();
	}
	abstract T PriorityDequeue();
	
	abstract void PriorityEnqueue(Comparable<T> item);
	
	public void empty(){
		this.data = new ArrayList<T>();
	}
	
	public ArrayList<T> getData(){
		return this.data;
	}
}
