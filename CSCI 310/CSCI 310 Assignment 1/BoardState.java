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
 * BoardState.java
 * Code has been modified from Professors's BoardState class
 */

import java.util.ArrayList;
import java.util.Arrays;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte1.other;

public class BoardState implements Comparable{
	private int[] currentState;
	private BoardState parent;
	private int g;
	private int h;
	
	public BoardState(int[] data){
		this.currentState = new int[9];
		for(int i = 0;i < 9;++i){
			this.currentState[i] = data[i];
		}
		this.parent = null;
		this.g = 0;
		this.h = 0;
	}
	
	public int compareTo(Object item){
		// You must implement this method
		// Since we are implementing the A* algorithm,
		// this method needs to compare the g+h in both objects.

		int s1 = this.getG() + this.getH();
		BoardState comp = (BoardState) item;
		int s2 = comp.getG() + comp.getH();

		if(s1 > s2){
			return 1;
		}
		else if (s1 == s2){
			return 0;
		}
		else{
			return -1;
		}
	}
	

	public boolean equals(Object item) {
		// You must implement this method
		// The objects are equal if the currentState[] arrays
		// are identical
		Boolean isEqual = true;
		BoardState equal = ((BoardState) item);
		for (int i = 0; i < equal.getCurrentState().length; i++) {
			if (currentState[i] != equal.getCurrentState()[i]) {
				isEqual = false;
			}
		}
		return isEqual;
	}

	

	public String toString(){
		// You need to implement this method
		// See example output to determine how to implement this method

		ArrayList tempArr = new ArrayList();
//
 		String tempStr = "";
// 		String[]tempArr = {""};
		//BoardState brdStr = new BoardState(this);
		for (int i=0; i<currentState.length;i++){
			tempStr += this.getCurrentState()[i];
			if((i+1)%3 == 0){
				tempStr+= "\n";
			}
		}
		return tempStr;
	}
	
	
	public int[] getCurrentState() {
		return currentState;
	}

	public void setCurrentState(int[] currentState) {
		this.currentState = currentState;
	}

	public BoardState getParent() {
		return parent;
	}//for print path

	public void setParent(BoardState parent) {
		this.parent = parent;
	}//for move()

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

 
}
