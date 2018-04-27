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
 * Main.java
 * Code has been modified from Professors's Main class
 */

public class Main {

	public static void main(String[] args) {

//		//Enqueue data
//		PriorityQueueLinkedList ll = new PriorityQueueLinkedList();
//		ll.PriorityEnqueue(2);
//		System.out.println(ll.getData());
//		ll.PriorityEnqueue(4);
//		System.out.println(ll.getData());
//		ll.PriorityEnqueue(6);
//		System.out.println(ll.getData());
//		ll.PriorityEnqueue(1);
//		System.out.println(ll.getData());
//		ll.PriorityEnqueue(3);
//		System.out.println(ll.getData());
//		ll.PriorityEnqueue(5);
//		System.out.println(ll.getData());
//		System.out.println(ll.getData().get(ll.getData().size()-1));
//		System.out.println(ll.getData().size());
//
//
//		//Dequeue data
//		ll.PriorityDequeue();
//		System.out.println(ll.getData());
//
//		//Re-Enqueue test
//		ll.PriorityEnqueue(1);
//		System.out.println(ll.getData());
//		ll.PriorityEnqueue(10);
//		System.out.println(ll.getData());
//		ll.PriorityEnqueue(8);
//		System.out.println(ll.getData());
//		ll.PriorityEnqueue(7);
//		System.out.println(ll.getData());
//		ll.PriorityEnqueue(9);
//		System.out.println(ll.getData());

/****************************************************************************************************************/

//		PriorityQueueHeap heap = new PriorityQueueHeap();
//
//		//Test Enqueue
//		heap.PriorityEnqueue(10);
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		heap.PriorityEnqueue(7);
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		heap.PriorityEnqueue(8);
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		heap.PriorityEnqueue(5);
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		heap.PriorityEnqueue(6);
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		heap.PriorityEnqueue(4);
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//
//		System.out.println();
//
//		//Dequeue
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		System.out.println();
//
//		heap.PriorityDequeue();
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		System.out.println();
//
//		heap.PriorityDequeue();
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		System.out.println();
//
//		heap.PriorityDequeue();
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		System.out.println();
//
//		heap.PriorityDequeue();
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		System.out.println();
//
//		heap.PriorityDequeue();
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//
//		heap.PriorityDequeue();
//		heap.PriorityDequeue();
//
//		heap.PriorityDequeue();
//		heap.PriorityEnqueue(4);
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//
//		heap.PriorityEnqueue(3);
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//
//		heap.PriorityEnqueue(1);
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		heap.PriorityDequeue();
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		heap.PriorityDequeue();
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));

//		PriorityQueueLinkedList board = new PriorityQueueLinkedList();
//		for (int i=0; i<9; i++){
//			board.PriorityEnqueue(i);
//		}
//		System.out.println(board.getData());
//		System.out.println();

		System.out.println("Heap");
		// To use a heap:
		EightPuzzle gameH = new EightPuzzle(new PriorityQueueHeap(), new int[]{0,1,2,3,4,5,6,7,8});
		//EightPuzzle testHeap = new EightPuzzle(new PriorityQueueHeap(), new int[]{0,1,2,3,4,5,6,7,8});
		System.out.println();
		System.out.println("################################################################");
		System.out.println();
		System.out.println("Linked List");
		// To use a linked list:
		//EightPuzzle gameL = new EightPuzzle(new PriorityQueueLinkedList(), new int[]{0,1,2,3,4,5,6,7,8});
		//EightPuzzle testLinkedList = new EightPuzzle(new PriorityQueueLinkedList<>(), new int[]{0,1,2,3,4,5,6,7,8});

		//EightPuzzle testLinkedList = new EightPuzzle(new PriorityQueueLinkedList<>(), new int[]{0,1,2,3,4,5,6,7,8});
//		EightPuzzle test = new EightPuzzle(new PriorityQueueHeap(), new int[]{0,1,2,3,4,5,6,7,8});
//		test.checkReachable(stateOne,stateTwo);
//		System.out.println("CheckReachable: "+test.checkReachable(stateOne,stateTwo));
//
//		int stateOne[] = {0,1,2,3,4,5,6,7,8};
//		int stateTwo[] = {1,2,0,3,4,5,8,7,6};

//		int stateThree[] = {7,8,0,6,1,2,5,4,3};
//		int stateFour[] = {6,7,8,5,4,3,2,1,0};
//		test.checkReachable(stateThree,stateFour);
//		System.out.println(test.checkReachable(stateThree,stateFour));
//		System.out.println(test.checkReachable(stateTwo,stateFour));
//
//		int stateFive[] = {0,1,2,3,4,5,6,7,8};
//		int stateSix[] = {0,1,2,3,4,5,6,8,7};
//		int stateSeven[] = {1,3,6,5,0,7,2,8,4};
//		System.out.println("Manhattan: " + test.manhattan(stateFive,stateSix));
//		System.out.println("Manhattan: " + test.manhattan(stateFive,stateSeven));

//		BoardState state2 = new BoardState(stateTwo);
//		String test = makeKey(state2);
//		System.out.println(state2.toString());
//		test.move(state2,0,0);
//		test.move(state2,0,1);
//		test.move(state2,0,-1);
//		test.move(state2,1,0);
//		test.move(state2,-1,0);


		//test.move(state1,1,1);


//		heap.PriorityEnqueue(3);
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		heap.PriorityEnqueue(5);
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		heap.PriorityEnqueue(7);
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		heap.PriorityEnqueue(9);
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		heap.PriorityEnqueue(4);
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		heap.PriorityEnqueue(6);
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		heap.PriorityEnqueue(8);
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		heap.PriorityEnqueue(1);
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));
//		heap.PriorityEnqueue(2);
//		System.out.println("heap: " + heap.getData());
//		System.out.println("parent: " + heap.getData().get(0));







	}

}
