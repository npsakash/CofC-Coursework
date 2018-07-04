package FinalProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OpenHashing <AnyType extends Comparable<? super AnyType>> {
	
	//Instance Variables
        public final int SIZE;
        private SinglyLinkedList<AnyType> hashTable = new SinglyLinkedList<AnyType>();
	private int hashElements;
	
	/**
         *Constructor for hash table
         * 
         * 
         */
        
	public OpenHashing(){
            
            SIZE = hashTable.size();
            //this.hashTable = new ArrayList[SIZE];
            //Create Singly Linked Lists within the Array List
            for(int i=0; i < SIZE-1; i++){
		SinglyLinkedList sLL = new SinglyLinkedList();
		hashTable.add((AnyType) sLL);
			
		}
	}
	
	public void delete(String v) throws IllegalArgumentException{
		
	/**
	 * Searches based on key and deletes match if found
	 * 
	 * Hash function below researched and used from: 
	 * http://stackoverflow.com/questions/2624192/good-hash-function-for-strings/2624210#2624210
	 * Author: jonathanasdf
	 * Date: April 12, 2010
	 * 
	 */
		
		//Hash Function
		//Variable hash is what the key will be
		int hash = 9;
		for (int i = 0; i < v.length(); i++) {
		    hash = hash*31 + v.charAt(i);
		    hash = hash%4007;
		}
		
		
		Node tempNode = new Node(v);
		SinglyLinkedList hashedSLL = (SinglyLinkedList) hashTable.get(hash);
		int sLLSize = hashedSLL.size();
		boolean match = false;
		//Checking if string is found
		//If found, delete
		//If not found, search Singly Linked List, if found delete
		//If still not found, do nothing
		for(int i=0; i < sLLSize-1;i++){
			Node temp = (Node) hashedSLL.get(i);
			int compareVal = temp.compareTo(tempNode);
			if(compareVal == 0){
				hashedSLL.remove(i);
			}
		}
	
	}
	
	public boolean search(String searchString){
		/**
		 * 
		 * Search Open Hashing based on key and returns true or false if match is found or not
		 * 
		 * Hash function below researched and used from: 
		 * http://stackoverflow.com/questions/2624192/good-hash-function-for-strings/2624210#2624210
		 * Author: jonathanasdf
		 * Date: April 12, 2010
		 * 
		 */
		int hash = 7;
		for (int i = 0; i < searchString.length(); i++) {
		    hash = hash*31 + searchString.charAt(i);
		    hash = hash%4007;
		}
		//Variable hash is the key
		Node myNode = new Node(searchString);
		SinglyLinkedList hashedSLL = (SinglyLinkedList) hashTable.get(hash);
		int sLLSize = hashedSLL.size();
		boolean match = false;
		//Search for string
		for(int i=0; i < sLLSize;i++){
			Node temp = (Node) hashedSLL.get(i);
			int compareVal = temp.compareTo(myNode);
			if(compareVal == 0){
				//Found, return true
				match = true;
			}
		}
		if(match == true){
			//Return is here
			return true;
		}
		else{
			//Not found, return false
			return false;
		}
	}
	
	public void insert(String hashString){
		/**
		 * 
		 * Inserts a value based on key
		 * 
		 * Hash function below researched and used from: 
		 * http://stackoverflow.com/questions/2624192/good-hash-function-for-strings/2624210#2624210
		 * Author: jonathanasdf
		 * Date: April 12, 2010
		 * 
		 */
		//Hash Function
		int hash = 7;
		for (int i = 0; i < hashString.length()-1; i++) {
		    hash = hash*31 + hashString.charAt(i);
		    hash = hash%4007;
		}
		//Variable hash is key
		Node tempNode = new Node(hashString);
		
		SinglyLinkedList hashedSLL = (SinglyLinkedList) hashTable.get(hash);
		int sLLSize = hashedSLL.size();
		boolean match = false;
		//Perform insert or check for an already occupied cell
		for(int i=0; i < sLLSize;i++){
			Node temp = (Node) hashedSLL.get(i);
			int compareVal = temp.compareTo(tempNode);
			if(compareVal == 0){
				match = true;
			}
		}
		//Perform insert due to no match or empty cell
		if(match == false){
			hashedSLL.add((Comparable) tempNode);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OpenHashing myOpenHash = new OpenHashing();
		String testString = "hello3";
		String testString2 = "hello5";
		String testString3 = "hello5";
		myOpenHash.insert(testString);
		myOpenHash.insert(testString2);
		myOpenHash.insert(testString3);
		
		boolean test = myOpenHash.search("hello5");
		boolean test2 = myOpenHash.search("hel");
		System.out.println(test);
		System.out.println(test2);
		
		myOpenHash.delete("hello5");
		
		System.out.println("fin");
		
//		Scanner myScanner;
//		int textLength = 0;
//		long timePre = System.currentTimeMillis();
//		try {
//			myScanner = new Scanner(new File("asp5202.txt"));
//			while(myScanner.hasNextLine()){
//				String line = myScanner.nextLine();
//				String[] words = line.split("\\s+");
//				
//				for(int i=0; i < words.length;i++){
//					if(words[i].length() < 2){
//						
//					}
//					else{
//						char lastChar = words[i].charAt(words[i].length()-1);
//						if (lastChar == '.' || lastChar == ',' || lastChar == '!' || lastChar == '?' || lastChar == '"' || lastChar == ':'){
//							words[i] = words[i].substring(0, words[i].length()-1);
//						}
//						char firstChar = words[i].charAt(0);
//						if (firstChar == '"'){
//							words[i] = words[i].substring(1,words[i].length()-1);
//						}
//						
//					}
//					textLength++;
////					myOpenHash.insert(words[i]);
//					
//						
//					
//					
////					System.out.println(words[i]);
//					myOpenHash.insert(words[i]);
//					
//				}
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		long timePost = System.currentTimeMillis();
//		System.out.println(textLength);
//		System.out.println("fin");
//		
//		
//		long timeCalc = timePost-timePre;
//		System.out.println("Insertion Time: "+timeCalc);
//		timePre = System.currentTimeMillis();
//		System.out.println(myOpenHash.search("Everyone"));
//		System.out.println(myOpenHash.search("randomsrefd"));
//		System.out.println(myOpenHash.search("Queries"));
//		timePost = System.currentTimeMillis();
//		timeCalc = timePost-timePre;
//		
//		
//		System.out.println("Search for 'Everyone' Time: "+timeCalc);
//		timePre = System.currentTimeMillis();
//		myOpenHash.delete("Everyone");
//		myOpenHash.delete("randomsrefd");
//		myOpenHash.delete("Queries");
//		timePost = System.currentTimeMillis();
//		timeCalc = timePost-timePre;
//		
//		
//		System.out.println("Delete Time: "+timeCalc);
		
		
		
		
		

	}

}