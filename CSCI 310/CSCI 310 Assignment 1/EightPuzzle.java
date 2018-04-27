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
 * EightPuzzle.java
 * Code has been modified from Professors's EightPuzzle class
 */
import jdk.nashorn.internal.ir.IfNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.swap;

public class EightPuzzle {

	//int[] baseState = {0,1,2,3,4,5,6,7,8};

	PriorityQueue<BoardState> openNodesQueue;
	Map<String, BoardState> closedNodes;
	BoardState GoalState;
	int AllPossibleStates[][];

	public EightPuzzle(PriorityQueue<BoardState> dataStructure, int[] Goal) {

		openNodesQueue = dataStructure; // Nice right? Polymorphism...
		GoalState = new BoardState(Goal);
		generateAllPossibleStates();
		closedNodes = new HashMap<String, BoardState>();

		long totalRunTime = 0;
		int statesSolved = 0;
		long endTime = 0;

		for (int i = 0; i < AllPossibleStates.length; ++i) {
			//Start clock
			//long startTime = System.currentTimeMillis();

			if (checkReachable(AllPossibleStates[i], GoalState.getCurrentState())) {
				//System.out.println("State is reachable!");
				// Do the EightPuzzle/A* algorithm:
				//
				// You need to finish this code here

				Boolean goalFound = false;

				BoardState currentState = new BoardState(AllPossibleStates[i]);
				System.out.println("Start State:");
				System.out.println(currentState.toString());

				openNodesQueue.PriorityEnqueue(currentState);


				//counting variables
				int path=0;
				int moves = 0;

				//Start clock
				long startTime = System.currentTimeMillis();
				while (!goalFound) {

					BoardState currentStateTemp = openNodesQueue.PriorityDequeue();
					//System.out.println(currentStateTemp.toString());

					if (currentStateTemp.equals(GoalState)) {
						goalFound = true;

						//Stop clock
						endTime = System.currentTimeMillis() - startTime;
						totalRunTime += endTime;

						statesSolved++;

						path = printPath(currentStateTemp, 1);
						System.out.println("==================================================");
						System.out.println("             PREVIOUS SOLUTION DATA               ");
						//System.out.println("Goal Found!");
						System.out.println("Number of moves: "+path+", Time Needed:  "+ endTime+ " Milliseconds"/*endTime/1000 +" Seconds"*/);
						System.out.println("States solved:   "+ statesSolved+", Total Running Time: "+totalRunTime+ " Milliseconds"/*(totalRunTime/1000)/60 +" Minutes"*/);
						//System.out.println("Move Count:" + moves);
						System.out.println("==================================================");


						//System.out.println(currentStateTemp.toString());

					}

					else {
						moves++;
						String addKey = makeKey(currentStateTemp);
						closedNodes.put(addKey, currentStateTemp);

						//Second Attempt A Star
						BoardState currentStateChild1 = move(currentStateTemp, 0, -1);
						int h1 = manhattan(currentStateChild1.getCurrentState(), GoalState.getCurrentState());
						currentStateChild1.setH(h1);

						BoardState currentStateChild2 = move(currentStateTemp, 0, 1);
						int h2 = manhattan(currentStateChild1.getCurrentState(), GoalState.getCurrentState());
						currentStateChild2.setH(h2);

						BoardState currentStateChild3 = move(currentStateTemp, -1, 0);
						int h3 = manhattan(currentStateChild1.getCurrentState(), GoalState.getCurrentState());
						currentStateChild3.setH(h3);

						BoardState currentStateChild4 = move(currentStateTemp, 1, 0);
						int h4 = manhattan(currentStateChild1.getCurrentState(), GoalState.getCurrentState());
						currentStateChild4.setH(h4);

						if(currentStateChild1 != null && !closedNodes.containsValue(currentStateChild1) /*&& !currentStateChild1.equals(currentStateTemp)*/){
							openNodesQueue.PriorityEnqueue(currentStateChild1);
						}
						if(currentStateChild2 != null && !closedNodes.containsValue(currentStateChild2) /*&& !currentStateChild2.equals(currentStateTemp)*//*
								&& currentStateChild2.getH()<currentStateChild1.getH()*/);{
									openNodesQueue.PriorityEnqueue(currentStateChild2);
						}
						if(currentStateChild3 != null && !closedNodes.containsValue(currentStateChild3)
								/*&& !currentStateChild2.equals(currentStateTemp)*//* && currentStateChild3.getH()<currentStateChild2.getH()*/);{
							openNodesQueue.PriorityEnqueue(currentStateChild3);
						}
						if(currentStateChild4 != null && !closedNodes.containsValue(currentStateChild4)
								/*&& !currentStateChild2.equals(currentStateTemp)*//* && currentStateChild4.getH()<currentStateChild3.getH()*/);{
							openNodesQueue.PriorityEnqueue(currentStateChild4);
						}

						//First attempt A star
//						BoardState currentStateChild = move(currentStateTemp, 0, -1);
//						if (currentStateChild != null && !closedNodes.containsValue(currentStateChild)) {
//							openNodesQueue.PriorityEnqueue(currentStateChild);
//							int h = manhattan(currentStateChild.getCurrentState(), GoalState.getCurrentState());
//							currentStateChild.setH(h);
//						}
//
//						currentStateChild = move(currentStateTemp, 0, 1);
//						if (currentStateChild != null && !closedNodes.containsValue(currentStateChild)) {
//							openNodesQueue.PriorityEnqueue(currentStateChild);
//							int h = manhattan(currentStateChild.getCurrentState(), GoalState.getCurrentState());
//							currentStateChild.setH(h);
//						}
//
//						currentStateChild = move(currentStateTemp, -1, 0);
//						if (currentStateChild != null && !closedNodes.containsValue(currentStateChild)) {
//							openNodesQueue.PriorityEnqueue(currentStateChild);
//							int h = manhattan(currentStateChild.getCurrentState(), GoalState.getCurrentState());
//							currentStateChild.setH(h);
//						}
//
//						currentStateChild = move(currentStateTemp, 1, 0);
//						if (currentStateChild != null && !closedNodes.containsValue(currentStateChild)) {
//							openNodesQueue.PriorityEnqueue(currentStateChild);
//							int h = manhattan(currentStateChild.getCurrentState(), GoalState.getCurrentState());
//							currentStateChild.setH(h);
//						}
					}
				}
			}// end if
//			else{
//				System.out.println("State is not reachable");
//			}
		}// end for
	} // end EightPuzzle


	
	
	public String makeKey(BoardState current){
		// You need to implement this
		// Convert the board state array into a String
		// so that it can be used as the key value in the closedNodes
		// hashmap.

		//String temp = current.toString();
		String tempStr = "";
		for (int i=0; i<current.getCurrentState().length;i++) {
			tempStr += current.getCurrentState()[i];
		}
		return tempStr;

//		int[] intArr = current.getCurrentState();
//		String strKey = "";
//		ArrayList currentArr = new ArrayList();
//		for(int i=0; i<intArr.length; i++){
//			char tile = (char) intArr[i];
//			strKey.concat(String.valueOf(tile));
//		}
//		//System.out.println(strKey);
//
//		//return current.toString();
//		return strKey;
	}
	
	public BoardState move(BoardState current, int rowMove, int colMove){

		// You need to implement this
		// Given a board state, return the new board state given
		// the rowMove/ColMove parameters which will be 0, 1, or -1.

		int[] intArr = current.getCurrentState();
		ArrayList currentArr = new ArrayList();
		for(int i=0; i<intArr.length; i++){
			int num = intArr[i];
			currentArr.add(num);
		}

		//Find index of zero
		int indexZero = currentArr.indexOf(0);
		//System.out.println(indexZero);
		//Find row of zero
		int rowZero = indexZero/3;
		//System.out.println(rowZero);
		int colZero = indexZero%3;
		//Find col of zero
		//System.out.println(colZero);
		//System.out.println(currentArr.toString());

		//Move Conditionals
		//Column Move
		//colMove = +1
		if(colMove == 1 && colZero+colMove <= 2) {
			swap(currentArr, indexZero, indexZero + 1);
			indexZero = currentArr.indexOf(0);
			rowZero = indexZero/3;
			colZero = indexZero%3;
		}
		//colMove = -1
		else if(colMove == -1 && colZero+colMove>=0){
			swap(currentArr,indexZero,indexZero-1);
			indexZero = currentArr.indexOf(0);
			rowZero = indexZero/3;
			colZero = indexZero%3;
		}
		//colMove = 0
		else{
//			BoardState nBoard = new BoardState(null);
//			return nBoard;
			//colZero=colZero;
			indexZero = indexZero;
			//return null;
		}
		//System.out.println(currentArr.toString());

		//Row Move
		//RowMove = +1
		if(rowMove == 1 && rowZero+rowMove <= 2) {
			swap(currentArr, indexZero, indexZero + 3);
			indexZero = currentArr.indexOf(0);
			rowZero = indexZero/3;
			colZero = indexZero%3;
		}
		//rowMove = -1
		else if(rowMove == -1 && rowZero+rowMove>=0){
			swap(currentArr,indexZero,indexZero-3);
			indexZero = currentArr.indexOf(0);
			rowZero = indexZero/3;
			colZero = indexZero%3;
		}
		//rowMove = 0
		else{
//			BoardState nBoard = new BoardState(null);
//			return nBoard;
			//rowZero=rowZero;
			indexZero = indexZero;
			//return null;
		}
		//System.out.println(currentArr.toString());

		int[] newArr = new int[9];

		for(int i=0; i<currentArr.size(); i++){
			int num = (int) currentArr.get(i);
			newArr[i] = num;
		}
		BoardState newBoard = new BoardState(newArr);

		//set parent
		newBoard.setParent(current);
		//set G
		newBoard.setG(current.getG()+1);

		//System.out.println(newBoard.toString());
		return newBoard;
	}
	
	public boolean checkReachable(int state1[], int state2[]){
		// You need to implement this
		// Returns true if any two states are reachable
		int count1 = 0;
		for (int i = 0; i < state1.length-1; i++)
			for (int j = i+1; j < state1.length; j++)
				// Value 0 is used for empty space
				if (state1[i] != 0 && state1[j] != 0 && state1[i] > state1[j]) {
					count1++;
				}
		//System.out.println("Count1: "+count1);

		int count2 = 0;
		for (int i = 0; i < state2.length-1; i++)
			for (int j = i+1; j < state2.length; j++)
				// Value 0 is used for empty space
				if (state2[i] != 0 && state2[j] != 0 && state2[i] > state2[j]) {
					count2++;
				}
		//System.out.println("Count2: "+count2);

		return(count1%2 == count2%2);
//		if (count1%2 == count2%2)
//			return true;
//		else
//			return false;
	}
	
	public int manhattan(int[] initialState, int[] endState){
		// You need to implement this
		// Return manhattan distance between these two states

		int distance = 0;
		int verticalCount = 0;
		int horizontalCount = 0;
		for(int i=0; i<initialState.length; i++){
			for(int j=0; j<endState.length; j++){
				if(initialState[i] != 0 && endState[j] != 0 && initialState[i] == endState[j]) {
					verticalCount = Math.abs(i/3 - j/3);
					horizontalCount = Math.abs(i%3 - j%3);
					distance += verticalCount+horizontalCount;
				}
			}
			//distance += verticalCount+horizontalCount;
		}
		//distance += verticalCount+horizontalCount;
		return distance;
	}

	public int printPath(BoardState current, int count){
		// You must implement this
		// Prints out path to goal state
		// Must be recursive
		int pathCount = 0;
		if (current.getParent() == null || count < 0){
			return 0;
		}
		else {
			pathCount++;
			pathCount += printPath(current.getParent(), count+1);
			System.out.println("---");
			System.out.println(current.toString());
		}
		return pathCount;
	}
	
	private void generateAllPossibleStates() {
		System.out.println("Generating All Possible States... ");
		//AllPossibleStates = new int[362880][9];
		AllPossibleStates = new int[10][9];
		// You must implement the rest of this method
		// Good luck! :)

		//100 hard coded permutations
//		AllPossibleStates[0] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
//		AllPossibleStates[1] = new int[]{1, 0, 2, 3, 4, 5, 6, 7, 8};
//		AllPossibleStates[2] = new int[]{1, 2, 0, 3, 4, 5, 6, 7, 8};
//		AllPossibleStates[3] = new int[]{1, 2, 3, 0, 4, 5, 6, 7, 8};
//		AllPossibleStates[4] = new int[]{1, 2, 3, 4, 0, 5, 6, 7, 8};
//		AllPossibleStates[5] = new int[]{1, 2, 3, 4, 5, 0, 6, 7, 8};
//		AllPossibleStates[6] = new int[]{1, 2, 3, 4, 5, 6, 0, 7, 8};
//		AllPossibleStates[7] = new int[]{1, 2, 3, 4, 5, 6, 7, 0, 8};
//		AllPossibleStates[8] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0};
//		AllPossibleStates[9] = new int[]{2, 1, 3, 4, 5, 6, 7, 8, 0};
//		AllPossibleStates[10] = new int[]{2, 3, 1, 4, 5, 6, 7, 8, 0};
//		AllPossibleStates[11] = new int[]{2, 3, 4, 1, 5, 6, 7, 8, 0};
//		AllPossibleStates[12] = new int[]{2, 3, 4, 5, 1, 6, 7, 8, 0};
//		AllPossibleStates[13] = new int[]{2, 3, 4, 5, 6, 1, 7, 8, 0};
//		AllPossibleStates[14] = new int[]{2, 3, 4, 5, 6, 7, 1, 8, 0};
//		AllPossibleStates[15] = new int[]{2, 3, 4, 5, 6, 7, 8, 1, 0};
//		AllPossibleStates[16] = new int[]{2, 3, 4, 5, 6, 7, 8, 0, 1};
//		AllPossibleStates[17] = new int[]{3, 2, 4, 5, 6, 7, 8, 0, 1};
//		AllPossibleStates[18] = new int[]{3, 4, 2, 5, 6, 7, 8, 0, 1};
//		AllPossibleStates[19] = new int[]{3, 4, 5, 2, 6, 7, 8, 0, 1};
//		AllPossibleStates[20] = new int[]{3, 4, 5, 6, 2, 7, 8, 0, 1};
//		AllPossibleStates[21] = new int[]{3, 4, 5, 6, 7, 2, 8, 0, 1};
//		AllPossibleStates[22] = new int[]{3, 4, 5, 6, 7, 8, 2, 0, 1};
//		AllPossibleStates[23] = new int[]{3, 4, 5, 6, 7, 8, 0, 2, 1};
//		AllPossibleStates[24] = new int[]{3, 4, 5, 6, 7, 8, 0, 1, 2};
//		AllPossibleStates[25] = new int[]{4, 3, 5, 6, 7, 8, 0, 1, 2};
//		AllPossibleStates[26] = new int[]{4, 5, 3, 6, 7, 8, 0, 1, 2};
//		AllPossibleStates[27] = new int[]{4, 5, 6, 3, 7, 8, 0, 1, 2};
//		AllPossibleStates[28] = new int[]{4, 5, 6, 7, 3, 8, 0, 1, 2};
//		AllPossibleStates[29] = new int[]{4, 5, 6, 7, 8, 3, 0, 1, 2};
//		AllPossibleStates[30] = new int[]{4, 5, 6, 7, 8, 0, 3, 1, 2};
//		AllPossibleStates[31] = new int[]{4, 5, 6, 7, 8, 0, 1, 3, 2};
//		AllPossibleStates[32] = new int[]{4, 5, 6, 7, 8, 0, 1, 2, 3};
//		AllPossibleStates[33] = new int[]{5, 4, 6, 7, 8, 0, 1, 2, 3};
//		AllPossibleStates[34] = new int[]{5, 6, 4, 7, 8, 0, 1, 2, 3};
//		AllPossibleStates[35] = new int[]{5, 6, 7, 4, 8, 0, 1, 2, 3};
//		AllPossibleStates[36] = new int[]{5, 6, 7, 8, 4, 0, 1, 2, 3};
//		AllPossibleStates[37] = new int[]{5, 6, 7, 8, 0, 4, 1, 2, 3};
//		AllPossibleStates[38] = new int[]{5, 6, 7, 8, 0, 1, 4, 2, 3};
//		AllPossibleStates[39] = new int[]{5, 6, 7, 8, 0, 1, 2, 4, 3};
//		AllPossibleStates[40] = new int[]{5, 6, 7, 8, 0, 1, 2, 3, 4};
//		AllPossibleStates[41] = new int[]{6, 5, 7, 8, 0, 1, 2, 3, 4};
//		AllPossibleStates[42] = new int[]{6, 7, 5, 8, 0, 1, 2, 3, 4};
//		AllPossibleStates[43] = new int[]{6, 7, 8, 5, 0, 1, 2, 3, 4};
//		AllPossibleStates[44] = new int[]{6, 7, 8, 0, 5, 1, 2, 3, 4};
//		AllPossibleStates[45] = new int[]{6, 7, 8, 0, 1, 5, 2, 3, 4};
//		AllPossibleStates[46] = new int[]{6, 7, 8, 0, 1, 2, 5, 3, 4};
//		AllPossibleStates[47] = new int[]{6, 7, 8, 0, 1, 2, 3, 5, 4};
//		AllPossibleStates[48] = new int[]{6, 7, 8, 0, 1, 2, 3, 4, 5};
//		AllPossibleStates[49] = new int[]{7, 6, 8, 0, 1, 2, 3, 4, 5};
//		AllPossibleStates[50] = new int[]{7, 8, 6, 0, 1, 2, 3, 4, 5};
//		AllPossibleStates[51] = new int[]{7, 8, 0, 6, 1, 2, 3, 4, 5};
//		AllPossibleStates[52] = new int[]{7, 8, 0, 1, 6, 2, 3, 4, 5};
//		AllPossibleStates[53] = new int[]{7, 8, 0, 1, 2, 6, 3, 4, 5};
//		AllPossibleStates[54] = new int[]{7, 8, 0, 1, 2, 3, 6, 4, 5};
//		AllPossibleStates[55] = new int[]{7, 8, 0, 1, 2, 3, 4, 6, 5};
//		AllPossibleStates[56] = new int[]{7, 8, 0, 1, 2, 3, 4, 5, 6};
//		AllPossibleStates[57] = new int[]{8, 7, 0, 1, 2, 3, 4, 5, 6};
//		AllPossibleStates[58] = new int[]{8, 0, 7, 1, 2, 3, 4, 5, 6};
//		AllPossibleStates[59] = new int[]{8, 0, 1, 7, 2, 3, 4, 5, 6};
//		AllPossibleStates[60] = new int[]{8, 0, 1, 2, 7, 3, 4, 5, 6};
//		AllPossibleStates[61] = new int[]{8, 0, 1, 2, 3, 7, 4, 5, 6};
//		AllPossibleStates[62] = new int[]{8, 0, 1, 2, 3, 4, 7, 5, 6};
//		AllPossibleStates[63] = new int[]{8, 0, 1, 2, 3, 4, 5, 7, 6};
//		AllPossibleStates[64] = new int[]{8, 0, 1, 2, 3, 4, 5, 6, 7};
//		AllPossibleStates[65] = new int[]{0, 8, 1, 2, 3, 4, 5, 6, 7};
//		AllPossibleStates[66] = new int[]{0, 1, 8, 2, 3, 4, 5, 6, 7};
//		AllPossibleStates[67] = new int[]{0, 1, 2, 8, 3, 4, 5, 6, 7};
//		AllPossibleStates[68] = new int[]{0, 1, 2, 3, 8, 4, 5, 6, 7};
//		AllPossibleStates[69] = new int[]{0, 1, 2, 3, 4, 8, 5, 6, 7};
//		AllPossibleStates[70] = new int[]{0, 1, 2, 3, 4, 5, 8, 6, 7};
//		AllPossibleStates[71] = new int[]{0, 1, 2, 3, 4, 5, 6, 8, 7};
//		AllPossibleStates[72] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
//		AllPossibleStates[73] = new int[]{1, 0, 2, 3, 4, 5, 6, 7, 8};
//		AllPossibleStates[74] = new int[]{1, 2, 0, 3, 4, 5, 6, 7, 8};
//		AllPossibleStates[75] = new int[]{1, 2, 3, 0, 4, 5, 6, 7, 8};
//		AllPossibleStates[76] = new int[]{1, 2, 3, 4, 0, 5, 6, 7, 8};
//		AllPossibleStates[77] = new int[]{1, 2, 3, 4, 5, 0, 6, 7, 8};
//		AllPossibleStates[78] = new int[]{1, 2, 3, 4, 5, 6, 0, 7, 8};
//		AllPossibleStates[79] = new int[]{6, 7, 8, 5, 0, 1, 2, 3, 4};
//		AllPossibleStates[80] = new int[]{6, 7, 8, 0, 5, 1, 2, 3, 4};
//		AllPossibleStates[81] = new int[]{6, 7, 8, 0, 1, 5, 2, 3, 4};
//		AllPossibleStates[82] = new int[]{6, 7, 8, 0, 1, 2, 5, 3, 4};
//		AllPossibleStates[83] = new int[]{6, 7, 8, 0, 1, 2, 3, 5, 4};
//		AllPossibleStates[84] = new int[]{6, 7, 8, 0, 1, 2, 3, 4, 5};
//		AllPossibleStates[85] = new int[]{7, 6, 8, 0, 1, 2, 3, 4, 5};
//		AllPossibleStates[86] = new int[]{7, 8, 6, 0, 1, 2, 3, 4, 5};
//		AllPossibleStates[87] = new int[]{7, 8, 0, 6, 1, 2, 3, 4, 5};
//		AllPossibleStates[88] = new int[]{7, 8, 0, 1, 6, 2, 3, 4, 5};
//		AllPossibleStates[89] = new int[]{7, 8, 0, 1, 2, 6, 3, 4, 5};
//		AllPossibleStates[90] = new int[]{7, 8, 0, 1, 2, 3, 6, 4, 5};
//		AllPossibleStates[91] = new int[]{7, 8, 0, 1, 2, 3, 4, 6, 5};
//		AllPossibleStates[92] = new int[]{7, 8, 0, 1, 2, 3, 4, 5, 6};
//		AllPossibleStates[93] = new int[]{8, 7, 0, 1, 2, 3, 4, 5, 6};
//		AllPossibleStates[94] = new int[]{8, 0, 7, 1, 2, 3, 4, 5, 6};
//		AllPossibleStates[95] = new int[]{8, 0, 1, 7, 2, 3, 4, 5, 6};
//		AllPossibleStates[96] = new int[]{8, 0, 1, 2, 7, 3, 4, 5, 6};
//		AllPossibleStates[97] = new int[]{8, 0, 1, 2, 3, 7, 4, 5, 6};
//		AllPossibleStates[98] = new int[]{8, 0, 1, 2, 3, 4, 7, 5, 6};
//		AllPossibleStates[99] = new int[]{8, 0, 1, 2, 3, 4, 5, 7, 6};
//		AllPossibleStates[100]= new int[]{8, 7, 6, 5, 4, 3, 2, 1, 0};
//		System.out.println("Done!");

		/**
		 * Below is my work on the permutations. Still incomplete.
		 */

		int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8};
		ArrayList baseState = new ArrayList();
		for (int i = 0; i < numbers.length; i++) {
			int num = numbers[i];
			baseState.add(num);
		}
		int n = baseState.size();
		int fc = 10;
		int j = 0;
		int m = 0;
		int k = 0;

		for (int permC = 0; permC < fc; permC++) {
			ArrayList perm = baseState;


			while (k != fc / n) {
				while (j != n-1) {
//					for (int row = 0; row < perm.size(); row++) {
						for (int col = 0; col < perm.size()-1; col++) {
							AllPossibleStates[j][col] = (int) perm.get(col);
						}
//					}
					//AllPossibleStates[k][j] = (int) perm.get(j);
					//AllPossibleStates[k][j] = (int) perm.get(j);
					System.out.println(perm);
					swap(perm, j, j + 1);
					//k++;
					//permC++;
					j++;
				}
				k++;
				j = 0;
			}
			m++;
			if (m == n)
				break;
			swap(baseState, 0, m);
			permC++;
		}



//Permutations
//[6, 7, 8, 5, 0, 1, 2, 3, 4]
//[6, 7, 8, 0, 5, 1, 2, 3, 4]
//[6, 7, 8, 0, 1, 5, 2, 3, 4]
//[6, 7, 8, 0, 1, 2, 5, 3, 4]
//[6, 7, 8, 0, 1, 2, 3, 5, 4]
//[6, 7, 8, 0, 1, 2, 3, 4, 5]
//[7, 6, 8, 0, 1, 2, 3, 4, 5]
//[7, 8, 6, 0, 1, 2, 3, 4, 5]
//[7, 8, 0, 6, 1, 2, 3, 4, 5]
//[7, 8, 0, 1, 6, 2, 3, 4, 5]
//[7, 8, 0, 1, 2, 6, 3, 4, 5]
//[7, 8, 0, 1, 2, 3, 6, 4, 5]
//[7, 8, 0, 1, 2, 3, 4, 6, 5]
//[7, 8, 0, 1, 2, 3, 4, 5, 6]
//[8, 7, 0, 1, 2, 3, 4, 5, 6]
//[8, 0, 7, 1, 2, 3, 4, 5, 6]
//[8, 0, 1, 7, 2, 3, 4, 5, 6]
//[8, 0, 1, 2, 7, 3, 4, 5, 6]
//[8, 0, 1, 2, 3, 7, 4, 5, 6]
//[8, 0, 1, 2, 3, 4, 7, 5, 6]
//[8, 0, 1, 2, 3, 4, 5, 7, 6]
//[8, 0, 1, 2, 3, 4, 5, 6, 7]
//[0, 8, 1, 2, 3, 4, 5, 6, 7]
//[0, 1, 8, 2, 3, 4, 5, 6, 7]
//[0, 1, 2, 8, 3, 4, 5, 6, 7]
//[0, 1, 2, 3, 8, 4, 5, 6, 7]
//[0, 1, 2, 3, 4, 8, 5, 6, 7]
//[0, 1, 2, 3, 4, 5, 8, 6, 7]
//[0, 1, 2, 3, 4, 5, 6, 8, 7]
//[0, 1, 2, 3, 4, 5, 6, 7, 8]
//[1, 0, 2, 3, 4, 5, 6, 7, 8]
//[1, 2, 0, 3, 4, 5, 6, 7, 8]
//[1, 2, 3, 0, 4, 5, 6, 7, 8]
//[1, 2, 3, 4, 0, 5, 6, 7, 8]
//[1, 2, 3, 4, 5, 0, 6, 7, 8]
//[1, 2, 3, 4, 5, 6, 0, 7, 8]
//[1, 2, 3, 4, 5, 6, 7, 0, 8]
//[1, 2, 3, 4, 5, 6, 7, 8, 0]
//[2, 1, 3, 4, 5, 6, 7, 8, 0]
//[2, 3, 1, 4, 5, 6, 7, 8, 0]
//[2, 3, 4, 1, 5, 6, 7, 8, 0]
//[2, 3, 4, 5, 1, 6, 7, 8, 0]
//[2, 3, 4, 5, 6, 1, 7, 8, 0]
//[2, 3, 4, 5, 6, 7, 1, 8, 0]
//[2, 3, 4, 5, 6, 7, 8, 1, 0]
//[3, 2, 4, 5, 6, 7, 8, 0, 1]
//[2, 3, 4, 5, 6, 7, 8, 0, 1]
//[2, 4, 3, 5, 6, 7, 8, 0, 1]
//[2, 4, 5, 3, 6, 7, 8, 0, 1]
//[2, 4, 5, 6, 3, 7, 8, 0, 1]
//[2, 4, 5, 6, 7, 3, 8, 0, 1]
//[2, 4, 5, 6, 7, 8, 3, 0, 1]
//[2, 4, 5, 6, 7, 8, 0, 3, 1]
//[2, 4, 5, 6, 7, 8, 0, 1, 3]
//[4, 2, 5, 6, 7, 8, 0, 1, 3]
//[4, 5, 2, 6, 7, 8, 0, 1, 3]
//[4, 5, 6, 2, 7, 8, 0, 1, 3]
//[4, 5, 6, 7, 2, 8, 0, 1, 3]
//[4, 5, 6, 7, 8, 2, 0, 1, 3]
//[4, 5, 6, 7, 8, 0, 2, 1, 3]
//[4, 5, 6, 7, 8, 0, 1, 2, 3]
//[4, 5, 6, 7, 8, 0, 1, 3, 2]
//[5, 4, 6, 7, 8, 0, 1, 3, 2]
//[5, 6, 4, 7, 8, 0, 1, 3, 2]
//[5, 6, 7, 4, 8, 0, 1, 3, 2]
//[5, 6, 7, 8, 4, 0, 1, 3, 2]
//[5, 6, 7, 8, 0, 4, 1, 3, 2]
//[5, 6, 7, 8, 0, 1, 4, 3, 2]
//[5, 6, 7, 8, 0, 1, 3, 4, 2]
//[5, 6, 7, 8, 0, 1, 3, 2, 4]
//[6, 5, 7, 8, 0, 1, 3, 2, 4]
//[6, 7, 5, 8, 0, 1, 3, 2, 4]
//[6, 7, 8, 5, 0, 1, 3, 2, 4]
//[6, 7, 8, 0, 5, 1, 3, 2, 4]
//[6, 7, 8, 0, 1, 5, 3, 2, 4]
//[6, 7, 8, 0, 1, 3, 5, 2, 4]
//[6, 7, 8, 0, 1, 3, 2, 5, 4]
//[6, 7, 8, 0, 1, 3, 2, 4, 5]
//[7, 6, 8, 0, 1, 3, 2, 4, 5]
//[7, 8, 6, 0, 1, 3, 2, 4, 5]
//[7, 8, 0, 6, 1, 3, 2, 4, 5]
//[7, 8, 0, 1, 6, 3, 2, 4, 5]
//[7, 8, 0, 1, 3, 6, 2, 4, 5]
//[7, 8, 0, 1, 3, 2, 6, 4, 5]
//[7, 8, 0, 1, 3, 2, 4, 6, 5]
//[7, 8, 0, 1, 3, 2, 4, 5, 6]
//[8, 7, 0, 1, 3, 2, 4, 5, 6]
//[8, 0, 7, 1, 3, 2, 4, 5, 6]
//[8, 0, 1, 7, 3, 2, 4, 5, 6]
//[8, 0, 1, 3, 7, 2, 4, 5, 6]
//[8, 0, 1, 3, 2, 7, 4, 5, 6]
//[8, 0, 1, 3, 2, 4, 7, 5, 6]
//[8, 0, 1, 3, 2, 4, 5, 7, 6]
//[8, 0, 1, 3, 2, 4, 5, 6, 7]
//[0, 8, 1, 3, 2, 4, 5, 6, 7]
//[0, 1, 8, 3, 2, 4, 5, 6, 7]
//[0, 1, 3, 8, 2, 4, 5, 6, 7]
//[0, 1, 3, 2, 8, 4, 5, 6, 7]
//[0, 1, 3, 2, 4, 8, 5, 6, 7]
//[0, 1, 3, 2, 4, 5, 8, 6, 7]
//[0, 1, 3, 2, 4, 5, 6, 8, 7]
//[0, 1, 3, 2, 4, 5, 6, 7, 8]
//[1, 0, 3, 2, 4, 5, 6, 7, 8]
//[1, 3, 0, 2, 4, 5, 6, 7, 8]
//[1, 3, 2, 0, 4, 5, 6, 7, 8]
//[1, 3, 2, 4, 0, 5, 6, 7, 8]
//[1, 3, 2, 4, 5, 0, 6, 7, 8]
//[1, 3, 2, 4, 5, 6, 0, 7, 8]
//[1, 3, 2, 4, 5, 6, 7, 0, 8]
//[1, 3, 2, 4, 5, 6, 7, 8, 0]
//[3, 1, 2, 4, 5, 6, 7, 8, 0]
//[3, 2, 1, 4, 5, 6, 7, 8, 0]
//[3, 2, 4, 1, 5, 6, 7, 8, 0]
//[3, 2, 4, 5, 1, 6, 7, 8, 0]
//[3, 2, 4, 5, 6, 1, 7, 8, 0]
//[3, 2, 4, 5, 6, 7, 1, 8, 0]
//[3, 2, 4, 5, 6, 7, 8, 1, 0]
//[3, 2, 4, 5, 6, 7, 8, 0, 1]
//[2, 3, 4, 5, 6, 7, 8, 0, 1]
//[2, 4, 3, 5, 6, 7, 8, 0, 1]
//[2, 4, 5, 3, 6, 7, 8, 0, 1]
//[2, 4, 5, 6, 3, 7, 8, 0, 1]
//[2, 4, 5, 6, 7, 3, 8, 0, 1]
//[2, 4, 5, 6, 7, 8, 3, 0, 1]
//[2, 4, 5, 6, 7, 8, 0, 3, 1]
//[2, 4, 5, 6, 7, 8, 0, 1, 3]
//[4, 2, 5, 6, 7, 8, 0, 1, 3]
//[4, 5, 2, 6, 7, 8, 0, 1, 3]
//[4, 5, 6, 2, 7, 8, 0, 1, 3]
//[4, 5, 6, 7, 2, 8, 0, 1, 3]
//[4, 5, 6, 7, 8, 2, 0, 1, 3]
//[4, 5, 6, 7, 8, 0, 2, 1, 3]
//[4, 5, 6, 7, 8, 0, 1, 2, 3]
//[6, 5, 4, 7, 8, 0, 1, 3, 2]
//[5, 6, 4, 7, 8, 0, 1, 3, 2]
//[5, 4, 6, 7, 8, 0, 1, 3, 2]
//[5, 4, 7, 6, 8, 0, 1, 3, 2]
//[5, 4, 7, 8, 6, 0, 1, 3, 2]
//[5, 4, 7, 8, 0, 6, 1, 3, 2]
//[5, 4, 7, 8, 0, 1, 6, 3, 2]
//[5, 4, 7, 8, 0, 1, 3, 6, 2]
//[5, 4, 7, 8, 0, 1, 3, 2, 6]
//[4, 5, 7, 8, 0, 1, 3, 2, 6]
//[4, 7, 5, 8, 0, 1, 3, 2, 6]
//[4, 7, 8, 5, 0, 1, 3, 2, 6]
//[4, 7, 8, 0, 5, 1, 3, 2, 6]
//[4, 7, 8, 0, 1, 5, 3, 2, 6]
//[4, 7, 8, 0, 1, 3, 5, 2, 6]
//[4, 7, 8, 0, 1, 3, 2, 5, 6]
//[4, 7, 8, 0, 1, 3, 2, 6, 5]
//[7, 4, 8, 0, 1, 3, 2, 6, 5]
//[7, 8, 4, 0, 1, 3, 2, 6, 5]
//[7, 8, 0, 4, 1, 3, 2, 6, 5]
//[7, 8, 0, 1, 4, 3, 2, 6, 5]
//[7, 8, 0, 1, 3, 4, 2, 6, 5]
//[7, 8, 0, 1, 3, 2, 4, 6, 5]
//[7, 8, 0, 1, 3, 2, 6, 4, 5]
//[7, 8, 0, 1, 3, 2, 6, 5, 4]
//[8, 7, 0, 1, 3, 2, 6, 5, 4]
//[8, 0, 7, 1, 3, 2, 6, 5, 4]
//[8, 0, 1, 7, 3, 2, 6, 5, 4]
//[8, 0, 1, 3, 7, 2, 6, 5, 4]
//[8, 0, 1, 3, 2, 7, 6, 5, 4]
//[8, 0, 1, 3, 2, 6, 7, 5, 4]
//[8, 0, 1, 3, 2, 6, 5, 7, 4]
//[8, 0, 1, 3, 2, 6, 5, 4, 7]
//[0, 8, 1, 3, 2, 6, 5, 4, 7]
//[0, 1, 8, 3, 2, 6, 5, 4, 7]
//[0, 1, 3, 8, 2, 6, 5, 4, 7]
//[0, 1, 3, 2, 8, 6, 5, 4, 7]
//[0, 1, 3, 2, 6, 8, 5, 4, 7]
//[0, 1, 3, 2, 6, 5, 8, 4, 7]
//[0, 1, 3, 2, 6, 5, 4, 8, 7]
//[0, 1, 3, 2, 6, 5, 4, 7, 8]
//[1, 0, 3, 2, 6, 5, 4, 7, 8]
//[1, 3, 0, 2, 6, 5, 4, 7, 8]
//[1, 3, 2, 0, 6, 5, 4, 7, 8]
//[1, 3, 2, 6, 0, 5, 4, 7, 8]
//[1, 3, 2, 6, 5, 0, 4, 7, 8]
//[1, 3, 2, 6, 5, 4, 0, 7, 8]
//[1, 3, 2, 6, 5, 4, 7, 0, 8]
//[1, 3, 2, 6, 5, 4, 7, 8, 0]
//[3, 1, 2, 6, 5, 4, 7, 8, 0]
//[3, 2, 1, 6, 5, 4, 7, 8, 0]
//[3, 2, 6, 1, 5, 4, 7, 8, 0]
//[3, 2, 6, 5, 1, 4, 7, 8, 0]
//[3, 2, 6, 5, 4, 1, 7, 8, 0]
//[3, 2, 6, 5, 4, 7, 1, 8, 0]
//[3, 2, 6, 5, 4, 7, 8, 1, 0]
//[3, 2, 6, 5, 4, 7, 8, 0, 1]
//[2, 3, 6, 5, 4, 7, 8, 0, 1]
//[2, 6, 3, 5, 4, 7, 8, 0, 1]
//[2, 6, 5, 3, 4, 7, 8, 0, 1]
//[2, 6, 5, 4, 3, 7, 8, 0, 1]
//[2, 6, 5, 4, 7, 3, 8, 0, 1]
//[2, 6, 5, 4, 7, 8, 3, 0, 1]
//[2, 6, 5, 4, 7, 8, 0, 3, 1]
//[2, 6, 5, 4, 7, 8, 0, 1, 3]
//[6, 2, 5, 4, 7, 8, 0, 1, 3]
//[6, 5, 2, 4, 7, 8, 0, 1, 3]
//[6, 5, 4, 2, 7, 8, 0, 1, 3]
//[6, 5, 4, 7, 2, 8, 0, 1, 3]
//[6, 5, 4, 7, 8, 2, 0, 1, 3]
//[6, 5, 4, 7, 8, 0, 2, 1, 3]
//[6, 5, 4, 7, 8, 0, 1, 2, 3]
//[6, 5, 4, 7, 8, 0, 1, 3, 2]
//[5, 6, 4, 7, 8, 0, 1, 3, 2]
//[5, 4, 6, 7, 8, 0, 1, 3, 2]
//[5, 4, 7, 6, 8, 0, 1, 3, 2]
//[5, 4, 7, 8, 6, 0, 1, 3, 2]
//[5, 4, 7, 8, 0, 6, 1, 3, 2]
//[5, 4, 7, 8, 0, 1, 6, 3, 2]
//[5, 4, 7, 8, 0, 1, 3, 6, 2]
//[5, 4, 7, 8, 0, 1, 3, 2, 6]
//[4, 5, 7, 8, 0, 1, 3, 2, 6]
//[4, 7, 5, 8, 0, 1, 3, 2, 6]
//[4, 7, 8, 5, 0, 1, 3, 2, 6]
//[4, 7, 8, 0, 5, 1, 3, 2, 6]
//[4, 7, 8, 0, 1, 5, 3, 2, 6]
//[4, 7, 8, 0, 1, 3, 5, 2, 6]
//[4, 7, 8, 0, 1, 3, 2, 5, 6]
//[0, 7, 8, 4, 1, 3, 2, 6, 5]
//[7, 0, 8, 4, 1, 3, 2, 6, 5]
//[7, 8, 0, 4, 1, 3, 2, 6, 5]
//[7, 8, 4, 0, 1, 3, 2, 6, 5]
//[7, 8, 4, 1, 0, 3, 2, 6, 5]
//[7, 8, 4, 1, 3, 0, 2, 6, 5]
//[7, 8, 4, 1, 3, 2, 0, 6, 5]
//[7, 8, 4, 1, 3, 2, 6, 0, 5]
//[7, 8, 4, 1, 3, 2, 6, 5, 0]
//[8, 7, 4, 1, 3, 2, 6, 5, 0]
//[8, 4, 7, 1, 3, 2, 6, 5, 0]
//[8, 4, 1, 7, 3, 2, 6, 5, 0]
//[8, 4, 1, 3, 7, 2, 6, 5, 0]
//[8, 4, 1, 3, 2, 7, 6, 5, 0]
//[8, 4, 1, 3, 2, 6, 7, 5, 0]
//[8, 4, 1, 3, 2, 6, 5, 7, 0]
//[8, 4, 1, 3, 2, 6, 5, 0, 7]
//[4, 8, 1, 3, 2, 6, 5, 0, 7]
//[4, 1, 8, 3, 2, 6, 5, 0, 7]
//[4, 1, 3, 8, 2, 6, 5, 0, 7]
//[4, 1, 3, 2, 8, 6, 5, 0, 7]
//[4, 1, 3, 2, 6, 8, 5, 0, 7]
//[4, 1, 3, 2, 6, 5, 8, 0, 7]
//[4, 1, 3, 2, 6, 5, 0, 8, 7]
//[4, 1, 3, 2, 6, 5, 0, 7, 8]
//[1, 4, 3, 2, 6, 5, 0, 7, 8]
//[1, 3, 4, 2, 6, 5, 0, 7, 8]
//[1, 3, 2, 4, 6, 5, 0, 7, 8]
//[1, 3, 2, 6, 4, 5, 0, 7, 8]
//[1, 3, 2, 6, 5, 4, 0, 7, 8]
//[1, 3, 2, 6, 5, 0, 4, 7, 8]
//[1, 3, 2, 6, 5, 0, 7, 4, 8]
//[1, 3, 2, 6, 5, 0, 7, 8, 4]
//[3, 1, 2, 6, 5, 0, 7, 8, 4]
//[3, 2, 1, 6, 5, 0, 7, 8, 4]
//[3, 2, 6, 1, 5, 0, 7, 8, 4]
//[3, 2, 6, 5, 1, 0, 7, 8, 4]
//[3, 2, 6, 5, 0, 1, 7, 8, 4]
//[3, 2, 6, 5, 0, 7, 1, 8, 4]
//[3, 2, 6, 5, 0, 7, 8, 1, 4]
//[3, 2, 6, 5, 0, 7, 8, 4, 1]
//[2, 3, 6, 5, 0, 7, 8, 4, 1]
//[2, 6, 3, 5, 0, 7, 8, 4, 1]
//[2, 6, 5, 3, 0, 7, 8, 4, 1]
//[2, 6, 5, 0, 3, 7, 8, 4, 1]
//[2, 6, 5, 0, 7, 3, 8, 4, 1]
//[2, 6, 5, 0, 7, 8, 3, 4, 1]
//[2, 6, 5, 0, 7, 8, 4, 3, 1]
//[2, 6, 5, 0, 7, 8, 4, 1, 3]
//[6, 2, 5, 0, 7, 8, 4, 1, 3]
//[6, 5, 2, 0, 7, 8, 4, 1, 3]
//[6, 5, 0, 2, 7, 8, 4, 1, 3]
//[6, 5, 0, 7, 2, 8, 4, 1, 3]
//[6, 5, 0, 7, 8, 2, 4, 1, 3]
//[6, 5, 0, 7, 8, 4, 2, 1, 3]
//[6, 5, 0, 7, 8, 4, 1, 2, 3]
//[6, 5, 0, 7, 8, 4, 1, 3, 2]
//[5, 6, 0, 7, 8, 4, 1, 3, 2]
//[5, 0, 6, 7, 8, 4, 1, 3, 2]
//[5, 0, 7, 6, 8, 4, 1, 3, 2]
//[5, 0, 7, 8, 6, 4, 1, 3, 2]
//[5, 0, 7, 8, 4, 6, 1, 3, 2]
//[5, 0, 7, 8, 4, 1, 6, 3, 2]
//[5, 0, 7, 8, 4, 1, 3, 6, 2]
//[5, 0, 7, 8, 4, 1, 3, 2, 6]
//[0, 5, 7, 8, 4, 1, 3, 2, 6]
//[0, 7, 5, 8, 4, 1, 3, 2, 6]
//[0, 7, 8, 5, 4, 1, 3, 2, 6]
//[0, 7, 8, 4, 5, 1, 3, 2, 6]
//[0, 7, 8, 4, 1, 5, 3, 2, 6]
//[0, 7, 8, 4, 1, 3, 5, 2, 6]
//[0, 7, 8, 4, 1, 3, 2, 5, 6]
//[0, 7, 8, 4, 1, 3, 2, 6, 5]
//[7, 0, 8, 4, 1, 3, 2, 6, 5]
//[7, 8, 0, 4, 1, 3, 2, 6, 5]
//[7, 8, 4, 0, 1, 3, 2, 6, 5]
//[7, 8, 4, 1, 0, 3, 2, 6, 5]
//[7, 8, 4, 1, 3, 0, 2, 6, 5]
//[7, 8, 4, 1, 3, 2, 0, 6, 5]
//[7, 8, 4, 1, 3, 2, 6, 0, 5]
//[7, 8, 4, 1, 3, 2, 6, 5, 0]
//[8, 7, 4, 1, 3, 2, 6, 5, 0]
//[8, 4, 7, 1, 3, 2, 6, 5, 0]
//[8, 4, 1, 7, 3, 2, 6, 5, 0]
//[8, 4, 1, 3, 7, 2, 6, 5, 0]
//[8, 4, 1, 3, 2, 7, 6, 5, 0]
//[8, 4, 1, 3, 2, 6, 7, 5, 0]
//[8, 4, 1, 3, 2, 6, 5, 7, 0]
//[2, 4, 1, 3, 8, 6, 5, 0, 7]
//[4, 2, 1, 3, 8, 6, 5, 0, 7]
//[4, 1, 2, 3, 8, 6, 5, 0, 7]
//[4, 1, 3, 2, 8, 6, 5, 0, 7]
//[4, 1, 3, 8, 2, 6, 5, 0, 7]
//[4, 1, 3, 8, 6, 2, 5, 0, 7]
//[4, 1, 3, 8, 6, 5, 2, 0, 7]
//[4, 1, 3, 8, 6, 5, 0, 2, 7]
//[4, 1, 3, 8, 6, 5, 0, 7, 2]
//[1, 4, 3, 8, 6, 5, 0, 7, 2]
//[1, 3, 4, 8, 6, 5, 0, 7, 2]
//[1, 3, 8, 4, 6, 5, 0, 7, 2]
//[1, 3, 8, 6, 4, 5, 0, 7, 2]
//[1, 3, 8, 6, 5, 4, 0, 7, 2]
//[1, 3, 8, 6, 5, 0, 4, 7, 2]
//[1, 3, 8, 6, 5, 0, 7, 4, 2]
//[1, 3, 8, 6, 5, 0, 7, 2, 4]
//[3, 1, 8, 6, 5, 0, 7, 2, 4]
//[3, 8, 1, 6, 5, 0, 7, 2, 4]
//[3, 8, 6, 1, 5, 0, 7, 2, 4]
//[3, 8, 6, 5, 1, 0, 7, 2, 4]
//[3, 8, 6, 5, 0, 1, 7, 2, 4]
//[3, 8, 6, 5, 0, 7, 1, 2, 4]
//[3, 8, 6, 5, 0, 7, 2, 1, 4]
//[3, 8, 6, 5, 0, 7, 2, 4, 1]
//[8, 3, 6, 5, 0, 7, 2, 4, 1]
//[8, 6, 3, 5, 0, 7, 2, 4, 1]
//[8, 6, 5, 3, 0, 7, 2, 4, 1]
//[8, 6, 5, 0, 3, 7, 2, 4, 1]
//[8, 6, 5, 0, 7, 3, 2, 4, 1]
//[8, 6, 5, 0, 7, 2, 3, 4, 1]
//[8, 6, 5, 0, 7, 2, 4, 3, 1]
//[8, 6, 5, 0, 7, 2, 4, 1, 3]
//[6, 8, 5, 0, 7, 2, 4, 1, 3]
//[6, 5, 8, 0, 7, 2, 4, 1, 3]
//[6, 5, 0, 8, 7, 2, 4, 1, 3]
//[6, 5, 0, 7, 8, 2, 4, 1, 3]
//[6, 5, 0, 7, 2, 8, 4, 1, 3]
//[6, 5, 0, 7, 2, 4, 8, 1, 3]
//[6, 5, 0, 7, 2, 4, 1, 8, 3]
//[6, 5, 0, 7, 2, 4, 1, 3, 8]
//[5, 6, 0, 7, 2, 4, 1, 3, 8]
//[5, 0, 6, 7, 2, 4, 1, 3, 8]
//[5, 0, 7, 6, 2, 4, 1, 3, 8]
//[5, 0, 7, 2, 6, 4, 1, 3, 8]
//[5, 0, 7, 2, 4, 6, 1, 3, 8]
//[5, 0, 7, 2, 4, 1, 6, 3, 8]
//[5, 0, 7, 2, 4, 1, 3, 6, 8]
//[5, 0, 7, 2, 4, 1, 3, 8, 6]
//[0, 5, 7, 2, 4, 1, 3, 8, 6]
//[0, 7, 5, 2, 4, 1, 3, 8, 6]
//[0, 7, 2, 5, 4, 1, 3, 8, 6]
//[0, 7, 2, 4, 5, 1, 3, 8, 6]
//[0, 7, 2, 4, 1, 5, 3, 8, 6]
//[0, 7, 2, 4, 1, 3, 5, 8, 6]
//[0, 7, 2, 4, 1, 3, 8, 5, 6]
//[0, 7, 2, 4, 1, 3, 8, 6, 5]
//[7, 0, 2, 4, 1, 3, 8, 6, 5]
//[7, 2, 0, 4, 1, 3, 8, 6, 5]
//[7, 2, 4, 0, 1, 3, 8, 6, 5]
//[7, 2, 4, 1, 0, 3, 8, 6, 5]
//[7, 2, 4, 1, 3, 0, 8, 6, 5]
//[7, 2, 4, 1, 3, 8, 0, 6, 5]
//[7, 2, 4, 1, 3, 8, 6, 0, 5]
//[7, 2, 4, 1, 3, 8, 6, 5, 0]
//[2, 7, 4, 1, 3, 8, 6, 5, 0]
//[2, 4, 7, 1, 3, 8, 6, 5, 0]
//[2, 4, 1, 7, 3, 8, 6, 5, 0]
//[2, 4, 1, 3, 7, 8, 6, 5, 0]
//[2, 4, 1, 3, 8, 7, 6, 5, 0]
//[2, 4, 1, 3, 8, 6, 7, 5, 0]
//[2, 4, 1, 3, 8, 6, 5, 7, 0]
//[2, 4, 1, 3, 8, 6, 5, 0, 7]
//[4, 2, 1, 3, 8, 6, 5, 0, 7]
//[4, 1, 2, 3, 8, 6, 5, 0, 7]
//[4, 1, 3, 2, 8, 6, 5, 0, 7]
//[4, 1, 3, 8, 2, 6, 5, 0, 7]
//[4, 1, 3, 8, 6, 2, 5, 0, 7]
//[4, 1, 3, 8, 6, 5, 2, 0, 7]
//[4, 1, 3, 8, 6, 5, 0, 2, 7]
//[4, 1, 3, 8, 6, 5, 0, 7, 2]
//[1, 4, 3, 8, 6, 5, 0, 7, 2]
//[1, 3, 4, 8, 6, 5, 0, 7, 2]
//[1, 3, 8, 4, 6, 5, 0, 7, 2]
//[1, 3, 8, 6, 4, 5, 0, 7, 2]
//[1, 3, 8, 6, 5, 4, 0, 7, 2]
//[1, 3, 8, 6, 5, 0, 4, 7, 2]
//[1, 3, 8, 6, 5, 0, 7, 4, 2]
//[0, 3, 8, 6, 5, 1, 7, 2, 4]
//[3, 0, 8, 6, 5, 1, 7, 2, 4]
//[3, 8, 0, 6, 5, 1, 7, 2, 4]
//[3, 8, 6, 0, 5, 1, 7, 2, 4]
//[3, 8, 6, 5, 0, 1, 7, 2, 4]
//[3, 8, 6, 5, 1, 0, 7, 2, 4]
//[3, 8, 6, 5, 1, 7, 0, 2, 4]
//[3, 8, 6, 5, 1, 7, 2, 0, 4]
//[3, 8, 6, 5, 1, 7, 2, 4, 0]
//[8, 3, 6, 5, 1, 7, 2, 4, 0]
//[8, 6, 3, 5, 1, 7, 2, 4, 0]
//[8, 6, 5, 3, 1, 7, 2, 4, 0]
//[8, 6, 5, 1, 3, 7, 2, 4, 0]
//[8, 6, 5, 1, 7, 3, 2, 4, 0]
//[8, 6, 5, 1, 7, 2, 3, 4, 0]
//[8, 6, 5, 1, 7, 2, 4, 3, 0]
//[8, 6, 5, 1, 7, 2, 4, 0, 3]
//[6, 8, 5, 1, 7, 2, 4, 0, 3]
//[6, 5, 8, 1, 7, 2, 4, 0, 3]
//[6, 5, 1, 8, 7, 2, 4, 0, 3]
//[6, 5, 1, 7, 8, 2, 4, 0, 3]
//[6, 5, 1, 7, 2, 8, 4, 0, 3]
//[6, 5, 1, 7, 2, 4, 8, 0, 3]
//[6, 5, 1, 7, 2, 4, 0, 8, 3]
//[6, 5, 1, 7, 2, 4, 0, 3, 8]
//[5, 6, 1, 7, 2, 4, 0, 3, 8]
//[5, 1, 6, 7, 2, 4, 0, 3, 8]
//[5, 1, 7, 6, 2, 4, 0, 3, 8]
//[5, 1, 7, 2, 6, 4, 0, 3, 8]
//[5, 1, 7, 2, 4, 6, 0, 3, 8]
//[5, 1, 7, 2, 4, 0, 6, 3, 8]
//[5, 1, 7, 2, 4, 0, 3, 6, 8]
//[5, 1, 7, 2, 4, 0, 3, 8, 6]
//[1, 5, 7, 2, 4, 0, 3, 8, 6]
//[1, 7, 5, 2, 4, 0, 3, 8, 6]
//[1, 7, 2, 5, 4, 0, 3, 8, 6]
//[1, 7, 2, 4, 5, 0, 3, 8, 6]
//[1, 7, 2, 4, 0, 5, 3, 8, 6]
//[1, 7, 2, 4, 0, 3, 5, 8, 6]
//[1, 7, 2, 4, 0, 3, 8, 5, 6]
//[1, 7, 2, 4, 0, 3, 8, 6, 5]
//[7, 1, 2, 4, 0, 3, 8, 6, 5]
//[7, 2, 1, 4, 0, 3, 8, 6, 5]
//[7, 2, 4, 1, 0, 3, 8, 6, 5]
//[7, 2, 4, 0, 1, 3, 8, 6, 5]
//[7, 2, 4, 0, 3, 1, 8, 6, 5]
//[7, 2, 4, 0, 3, 8, 1, 6, 5]
//[7, 2, 4, 0, 3, 8, 6, 1, 5]
//[7, 2, 4, 0, 3, 8, 6, 5, 1]
//[2, 7, 4, 0, 3, 8, 6, 5, 1]
//[2, 4, 7, 0, 3, 8, 6, 5, 1]
//[2, 4, 0, 7, 3, 8, 6, 5, 1]
//[2, 4, 0, 3, 7, 8, 6, 5, 1]
//[2, 4, 0, 3, 8, 7, 6, 5, 1]
//[2, 4, 0, 3, 8, 6, 7, 5, 1]
//[2, 4, 0, 3, 8, 6, 5, 7, 1]
//[2, 4, 0, 3, 8, 6, 5, 1, 7]
//[4, 2, 0, 3, 8, 6, 5, 1, 7]
//[4, 0, 2, 3, 8, 6, 5, 1, 7]
//[4, 0, 3, 2, 8, 6, 5, 1, 7]
//[4, 0, 3, 8, 2, 6, 5, 1, 7]
//[4, 0, 3, 8, 6, 2, 5, 1, 7]
//[4, 0, 3, 8, 6, 5, 2, 1, 7]
//[4, 0, 3, 8, 6, 5, 1, 2, 7]
//[4, 0, 3, 8, 6, 5, 1, 7, 2]
//[0, 4, 3, 8, 6, 5, 1, 7, 2]
//[0, 3, 4, 8, 6, 5, 1, 7, 2]
//[0, 3, 8, 4, 6, 5, 1, 7, 2]
//[0, 3, 8, 6, 4, 5, 1, 7, 2]
//[0, 3, 8, 6, 5, 4, 1, 7, 2]
//[0, 3, 8, 6, 5, 1, 4, 7, 2]
//[0, 3, 8, 6, 5, 1, 7, 4, 2]
//[0, 3, 8, 6, 5, 1, 7, 2, 4]
//[3, 0, 8, 6, 5, 1, 7, 2, 4]
//[3, 8, 0, 6, 5, 1, 7, 2, 4]
//[3, 8, 6, 0, 5, 1, 7, 2, 4]
//[3, 8, 6, 5, 0, 1, 7, 2, 4]
//[3, 8, 6, 5, 1, 0, 7, 2, 4]
//[3, 8, 6, 5, 1, 7, 0, 2, 4]
//[3, 8, 6, 5, 1, 7, 2, 0, 4]
//[3, 8, 6, 5, 1, 7, 2, 4, 0]
//[8, 3, 6, 5, 1, 7, 2, 4, 0]
//[8, 6, 3, 5, 1, 7, 2, 4, 0]
//[8, 6, 5, 3, 1, 7, 2, 4, 0]
//[8, 6, 5, 1, 3, 7, 2, 4, 0]
//[8, 6, 5, 1, 7, 3, 2, 4, 0]
//[8, 6, 5, 1, 7, 2, 3, 4, 0]
//[8, 6, 5, 1, 7, 2, 4, 3, 0]
//[4, 6, 5, 1, 7, 2, 8, 0, 3]
//[6, 4, 5, 1, 7, 2, 8, 0, 3]
//[6, 5, 4, 1, 7, 2, 8, 0, 3]
//[6, 5, 1, 4, 7, 2, 8, 0, 3]
//[6, 5, 1, 7, 4, 2, 8, 0, 3]
//[6, 5, 1, 7, 2, 4, 8, 0, 3]
//[6, 5, 1, 7, 2, 8, 4, 0, 3]
//[6, 5, 1, 7, 2, 8, 0, 4, 3]
//[6, 5, 1, 7, 2, 8, 0, 3, 4]
//[5, 6, 1, 7, 2, 8, 0, 3, 4]
//[5, 1, 6, 7, 2, 8, 0, 3, 4]
//[5, 1, 7, 6, 2, 8, 0, 3, 4]
//[5, 1, 7, 2, 6, 8, 0, 3, 4]
//[5, 1, 7, 2, 8, 6, 0, 3, 4]
//[5, 1, 7, 2, 8, 0, 6, 3, 4]
//[5, 1, 7, 2, 8, 0, 3, 6, 4]
//[5, 1, 7, 2, 8, 0, 3, 4, 6]
//[1, 5, 7, 2, 8, 0, 3, 4, 6]
//[1, 7, 5, 2, 8, 0, 3, 4, 6]
//[1, 7, 2, 5, 8, 0, 3, 4, 6]
//[1, 7, 2, 8, 5, 0, 3, 4, 6]
//[1, 7, 2, 8, 0, 5, 3, 4, 6]
//[1, 7, 2, 8, 0, 3, 5, 4, 6]
//[1, 7, 2, 8, 0, 3, 4, 5, 6]
//[1, 7, 2, 8, 0, 3, 4, 6, 5]
//[7, 1, 2, 8, 0, 3, 4, 6, 5]
//[7, 2, 1, 8, 0, 3, 4, 6, 5]
//[7, 2, 8, 1, 0, 3, 4, 6, 5]
//[7, 2, 8, 0, 1, 3, 4, 6, 5]
//[7, 2, 8, 0, 3, 1, 4, 6, 5]
//[7, 2, 8, 0, 3, 4, 1, 6, 5]
//[7, 2, 8, 0, 3, 4, 6, 1, 5]
//[7, 2, 8, 0, 3, 4, 6, 5, 1]
//[2, 7, 8, 0, 3, 4, 6, 5, 1]
//[2, 8, 7, 0, 3, 4, 6, 5, 1]
//[2, 8, 0, 7, 3, 4, 6, 5, 1]
//[2, 8, 0, 3, 7, 4, 6, 5, 1]
//[2, 8, 0, 3, 4, 7, 6, 5, 1]
//[2, 8, 0, 3, 4, 6, 7, 5, 1]
//[2, 8, 0, 3, 4, 6, 5, 7, 1]
//[2, 8, 0, 3, 4, 6, 5, 1, 7]
//[8, 2, 0, 3, 4, 6, 5, 1, 7]
//[8, 0, 2, 3, 4, 6, 5, 1, 7]
//[8, 0, 3, 2, 4, 6, 5, 1, 7]
//[8, 0, 3, 4, 2, 6, 5, 1, 7]
//[8, 0, 3, 4, 6, 2, 5, 1, 7]
//[8, 0, 3, 4, 6, 5, 2, 1, 7]
//[8, 0, 3, 4, 6, 5, 1, 2, 7]
//[8, 0, 3, 4, 6, 5, 1, 7, 2]
//[0, 8, 3, 4, 6, 5, 1, 7, 2]
//[0, 3, 8, 4, 6, 5, 1, 7, 2]
//[0, 3, 4, 8, 6, 5, 1, 7, 2]
//[0, 3, 4, 6, 8, 5, 1, 7, 2]
//[0, 3, 4, 6, 5, 8, 1, 7, 2]
//[0, 3, 4, 6, 5, 1, 8, 7, 2]
//[0, 3, 4, 6, 5, 1, 7, 8, 2]
//[0, 3, 4, 6, 5, 1, 7, 2, 8]
//[3, 0, 4, 6, 5, 1, 7, 2, 8]
//[3, 4, 0, 6, 5, 1, 7, 2, 8]
//[3, 4, 6, 0, 5, 1, 7, 2, 8]
//[3, 4, 6, 5, 0, 1, 7, 2, 8]
//[3, 4, 6, 5, 1, 0, 7, 2, 8]
//[3, 4, 6, 5, 1, 7, 0, 2, 8]
//[3, 4, 6, 5, 1, 7, 2, 0, 8]
//[3, 4, 6, 5, 1, 7, 2, 8, 0]
//[4, 3, 6, 5, 1, 7, 2, 8, 0]
//[4, 6, 3, 5, 1, 7, 2, 8, 0]
//[4, 6, 5, 3, 1, 7, 2, 8, 0]
//[4, 6, 5, 1, 3, 7, 2, 8, 0]
//[4, 6, 5, 1, 7, 3, 2, 8, 0]
//[4, 6, 5, 1, 7, 2, 3, 8, 0]
//[4, 6, 5, 1, 7, 2, 8, 3, 0]
//[4, 6, 5, 1, 7, 2, 8, 0, 3]
//[6, 4, 5, 1, 7, 2, 8, 0, 3]
//[6, 5, 4, 1, 7, 2, 8, 0, 3]
//[6, 5, 1, 4, 7, 2, 8, 0, 3]
//[6, 5, 1, 7, 4, 2, 8, 0, 3]
//[6, 5, 1, 7, 2, 4, 8, 0, 3]
//[6, 5, 1, 7, 2, 8, 4, 0, 3]
//[6, 5, 1, 7, 2, 8, 0, 4, 3]
//[6, 5, 1, 7, 2, 8, 0, 3, 4]
//[5, 6, 1, 7, 2, 8, 0, 3, 4]
//[5, 1, 6, 7, 2, 8, 0, 3, 4]
//[5, 1, 7, 6, 2, 8, 0, 3, 4]
//[5, 1, 7, 2, 6, 8, 0, 3, 4]
//[5, 1, 7, 2, 8, 6, 0, 3, 4]
//[5, 1, 7, 2, 8, 0, 6, 3, 4]
//[5, 1, 7, 2, 8, 0, 3, 6, 4]
//[4, 1, 7, 2, 8, 0, 3, 5, 6]
//[1, 4, 7, 2, 8, 0, 3, 5, 6]
//[1, 7, 4, 2, 8, 0, 3, 5, 6]
//[1, 7, 2, 4, 8, 0, 3, 5, 6]
//[1, 7, 2, 8, 4, 0, 3, 5, 6]
//[1, 7, 2, 8, 0, 4, 3, 5, 6]
//[1, 7, 2, 8, 0, 3, 4, 5, 6]
//[1, 7, 2, 8, 0, 3, 5, 4, 6]
//[1, 7, 2, 8, 0, 3, 5, 6, 4]
//[7, 1, 2, 8, 0, 3, 5, 6, 4]
//[7, 2, 1, 8, 0, 3, 5, 6, 4]
//[7, 2, 8, 1, 0, 3, 5, 6, 4]
//[7, 2, 8, 0, 1, 3, 5, 6, 4]
//[7, 2, 8, 0, 3, 1, 5, 6, 4]
//[7, 2, 8, 0, 3, 5, 1, 6, 4]
//[7, 2, 8, 0, 3, 5, 6, 1, 4]
//[7, 2, 8, 0, 3, 5, 6, 4, 1]
//[2, 7, 8, 0, 3, 5, 6, 4, 1]
//[2, 8, 7, 0, 3, 5, 6, 4, 1]
//[2, 8, 0, 7, 3, 5, 6, 4, 1]
//[2, 8, 0, 3, 7, 5, 6, 4, 1]
//[2, 8, 0, 3, 5, 7, 6, 4, 1]
//[2, 8, 0, 3, 5, 6, 7, 4, 1]
//[2, 8, 0, 3, 5, 6, 4, 7, 1]
//[2, 8, 0, 3, 5, 6, 4, 1, 7]
//[8, 2, 0, 3, 5, 6, 4, 1, 7]
//[8, 0, 2, 3, 5, 6, 4, 1, 7]
//[8, 0, 3, 2, 5, 6, 4, 1, 7]
//[8, 0, 3, 5, 2, 6, 4, 1, 7]
//[8, 0, 3, 5, 6, 2, 4, 1, 7]
//[8, 0, 3, 5, 6, 4, 2, 1, 7]
//[8, 0, 3, 5, 6, 4, 1, 2, 7]
//[8, 0, 3, 5, 6, 4, 1, 7, 2]
//[0, 8, 3, 5, 6, 4, 1, 7, 2]
//[0, 3, 8, 5, 6, 4, 1, 7, 2]
//[0, 3, 5, 8, 6, 4, 1, 7, 2]
//[0, 3, 5, 6, 8, 4, 1, 7, 2]
//[0, 3, 5, 6, 4, 8, 1, 7, 2]
//[0, 3, 5, 6, 4, 1, 8, 7, 2]
//[0, 3, 5, 6, 4, 1, 7, 8, 2]
//[0, 3, 5, 6, 4, 1, 7, 2, 8]
//[3, 0, 5, 6, 4, 1, 7, 2, 8]
//[3, 5, 0, 6, 4, 1, 7, 2, 8]
//[3, 5, 6, 0, 4, 1, 7, 2, 8]
//[3, 5, 6, 4, 0, 1, 7, 2, 8]
//[3, 5, 6, 4, 1, 0, 7, 2, 8]
//[3, 5, 6, 4, 1, 7, 0, 2, 8]
//[3, 5, 6, 4, 1, 7, 2, 0, 8]
//[3, 5, 6, 4, 1, 7, 2, 8, 0]
//[5, 3, 6, 4, 1, 7, 2, 8, 0]
//[5, 6, 3, 4, 1, 7, 2, 8, 0]
//[5, 6, 4, 3, 1, 7, 2, 8, 0]
//[5, 6, 4, 1, 3, 7, 2, 8, 0]
//[5, 6, 4, 1, 7, 3, 2, 8, 0]
//[5, 6, 4, 1, 7, 2, 3, 8, 0]
//[5, 6, 4, 1, 7, 2, 8, 3, 0]
//[5, 6, 4, 1, 7, 2, 8, 0, 3]
//[6, 5, 4, 1, 7, 2, 8, 0, 3]
//[6, 4, 5, 1, 7, 2, 8, 0, 3]
//[6, 4, 1, 5, 7, 2, 8, 0, 3]
//[6, 4, 1, 7, 5, 2, 8, 0, 3]
//[6, 4, 1, 7, 2, 5, 8, 0, 3]
//[6, 4, 1, 7, 2, 8, 5, 0, 3]
//[6, 4, 1, 7, 2, 8, 0, 5, 3]
//[6, 4, 1, 7, 2, 8, 0, 3, 5]
//[4, 6, 1, 7, 2, 8, 0, 3, 5]
//[4, 1, 6, 7, 2, 8, 0, 3, 5]
//[4, 1, 7, 6, 2, 8, 0, 3, 5]
//[4, 1, 7, 2, 6, 8, 0, 3, 5]
//[4, 1, 7, 2, 8, 6, 0, 3, 5]
//[4, 1, 7, 2, 8, 0, 6, 3, 5]
//[4, 1, 7, 2, 8, 0, 3, 6, 5]
//[4, 1, 7, 2, 8, 0, 3, 5, 6]
//[1, 4, 7, 2, 8, 0, 3, 5, 6]
//[1, 7, 4, 2, 8, 0, 3, 5, 6]
//[1, 7, 2, 4, 8, 0, 3, 5, 6]
//[1, 7, 2, 8, 4, 0, 3, 5, 6]
//[1, 7, 2, 8, 0, 4, 3, 5, 6]
//[1, 7, 2, 8, 0, 3, 4, 5, 6]
//[1, 7, 2, 8, 0, 3, 5, 4, 6]
//[1, 7, 2, 8, 0, 3, 5, 6, 4]
//[7, 1, 2, 8, 0, 3, 5, 6, 4]
//[7, 2, 1, 8, 0, 3, 5, 6, 4]
//[7, 2, 8, 1, 0, 3, 5, 6, 4]
//[7, 2, 8, 0, 1, 3, 5, 6, 4]
//[7, 2, 8, 0, 3, 1, 5, 6, 4]
//[7, 2, 8, 0, 3, 5, 1, 6, 4]
//[7, 2, 8, 0, 3, 5, 6, 1, 4]
//[1, 2, 8, 0, 3, 5, 6, 4, 7]
//[2, 1, 8, 0, 3, 5, 6, 4, 7]
//[2, 8, 1, 0, 3, 5, 6, 4, 7]
//[2, 8, 0, 1, 3, 5, 6, 4, 7]
//[2, 8, 0, 3, 1, 5, 6, 4, 7]
//[2, 8, 0, 3, 5, 1, 6, 4, 7]
//[2, 8, 0, 3, 5, 6, 1, 4, 7]
//[2, 8, 0, 3, 5, 6, 4, 1, 7]
//[2, 8, 0, 3, 5, 6, 4, 7, 1]
//[8, 2, 0, 3, 5, 6, 4, 7, 1]
//[8, 0, 2, 3, 5, 6, 4, 7, 1]
//[8, 0, 3, 2, 5, 6, 4, 7, 1]
//[8, 0, 3, 5, 2, 6, 4, 7, 1]
//[8, 0, 3, 5, 6, 2, 4, 7, 1]
//[8, 0, 3, 5, 6, 4, 2, 7, 1]
//[8, 0, 3, 5, 6, 4, 7, 2, 1]
//[8, 0, 3, 5, 6, 4, 7, 1, 2]
//[0, 8, 3, 5, 6, 4, 7, 1, 2]
//[0, 3, 8, 5, 6, 4, 7, 1, 2]
//[0, 3, 5, 8, 6, 4, 7, 1, 2]
//[0, 3, 5, 6, 8, 4, 7, 1, 2]
//[0, 3, 5, 6, 4, 8, 7, 1, 2]
//[0, 3, 5, 6, 4, 7, 8, 1, 2]
//[0, 3, 5, 6, 4, 7, 1, 8, 2]
//[0, 3, 5, 6, 4, 7, 1, 2, 8]
//[3, 0, 5, 6, 4, 7, 1, 2, 8]
//[3, 5, 0, 6, 4, 7, 1, 2, 8]
//[3, 5, 6, 0, 4, 7, 1, 2, 8]
//[3, 5, 6, 4, 0, 7, 1, 2, 8]
//[3, 5, 6, 4, 7, 0, 1, 2, 8]
//[3, 5, 6, 4, 7, 1, 0, 2, 8]
//[3, 5, 6, 4, 7, 1, 2, 0, 8]
//[3, 5, 6, 4, 7, 1, 2, 8, 0]
//[5, 3, 6, 4, 7, 1, 2, 8, 0]
//[5, 6, 3, 4, 7, 1, 2, 8, 0]
//[5, 6, 4, 3, 7, 1, 2, 8, 0]
//[5, 6, 4, 7, 3, 1, 2, 8, 0]
//[5, 6, 4, 7, 1, 3, 2, 8, 0]
//[5, 6, 4, 7, 1, 2, 3, 8, 0]
//[5, 6, 4, 7, 1, 2, 8, 3, 0]
//[5, 6, 4, 7, 1, 2, 8, 0, 3]
//[6, 5, 4, 7, 1, 2, 8, 0, 3]
//[6, 4, 5, 7, 1, 2, 8, 0, 3]
//[6, 4, 7, 5, 1, 2, 8, 0, 3]
//[6, 4, 7, 1, 5, 2, 8, 0, 3]
//[6, 4, 7, 1, 2, 5, 8, 0, 3]
//[6, 4, 7, 1, 2, 8, 5, 0, 3]
//[6, 4, 7, 1, 2, 8, 0, 5, 3]
//[6, 4, 7, 1, 2, 8, 0, 3, 5]
//[4, 6, 7, 1, 2, 8, 0, 3, 5]
//[4, 7, 6, 1, 2, 8, 0, 3, 5]
//[4, 7, 1, 6, 2, 8, 0, 3, 5]
//[4, 7, 1, 2, 6, 8, 0, 3, 5]
//[4, 7, 1, 2, 8, 6, 0, 3, 5]
//[4, 7, 1, 2, 8, 0, 6, 3, 5]
//[4, 7, 1, 2, 8, 0, 3, 6, 5]
//[4, 7, 1, 2, 8, 0, 3, 5, 6]
//[7, 4, 1, 2, 8, 0, 3, 5, 6]
//[7, 1, 4, 2, 8, 0, 3, 5, 6]
//[7, 1, 2, 4, 8, 0, 3, 5, 6]
//[7, 1, 2, 8, 4, 0, 3, 5, 6]
//[7, 1, 2, 8, 0, 4, 3, 5, 6]
//[7, 1, 2, 8, 0, 3, 4, 5, 6]
//[7, 1, 2, 8, 0, 3, 5, 4, 6]
//[7, 1, 2, 8, 0, 3, 5, 6, 4]
//[1, 7, 2, 8, 0, 3, 5, 6, 4]
//[1, 2, 7, 8, 0, 3, 5, 6, 4]
//[1, 2, 8, 7, 0, 3, 5, 6, 4]
//[1, 2, 8, 0, 7, 3, 5, 6, 4]
//[1, 2, 8, 0, 3, 7, 5, 6, 4]
//[1, 2, 8, 0, 3, 5, 7, 6, 4]
//[1, 2, 8, 0, 3, 5, 6, 7, 4]
//[1, 2, 8, 0, 3, 5, 6, 4, 7]
//[2, 1, 8, 0, 3, 5, 6, 4, 7]
//[2, 8, 1, 0, 3, 5, 6, 4, 7]
//[2, 8, 0, 1, 3, 5, 6, 4, 7]
//[2, 8, 0, 3, 1, 5, 6, 4, 7]
//[2, 8, 0, 3, 5, 1, 6, 4, 7]
//[2, 8, 0, 3, 5, 6, 1, 4, 7]
//[2, 8, 0, 3, 5, 6, 4, 1, 7]
//[2, 8, 0, 3, 5, 6, 4, 7, 1]
//[8, 2, 0, 3, 5, 6, 4, 7, 1]
//[8, 0, 2, 3, 5, 6, 4, 7, 1]
//[8, 0, 3, 2, 5, 6, 4, 7, 1]
//[8, 0, 3, 5, 2, 6, 4, 7, 1]
//[8, 0, 3, 5, 6, 2, 4, 7, 1]
//[8, 0, 3, 5, 6, 4, 2, 7, 1]
//[8, 0, 3, 5, 6, 4, 7, 2, 1]

	}

}

