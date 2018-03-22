package FinalProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClosedHashing<AnyType extends Comparable<? super AnyType>> {
	private ArrayList<AnyType> hashList = new ArrayList<AnyType>();
	private int arrayListSize = hashList.hashCapacity;

	public ClosedHashing(){
		int hashListSize = hashList.getHashCapacity();
		for(int i=0; i < hashListSize; i++){
			Node node = new Node(null);
			hashList.add(node);

		}

	}
	public void delete(String searchString){
		/**
		 * Searches based on key and deletes match if found
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
		//Hash is key
		Node myNode = new Node(searchString);
		Node preNode = hashList.get(hash);
		int compareValue = myNode.compareTo(preNode);
		//Match found, perform lazy delete
		if(compareValue==0){
			preNode.setData(-1000);

		}
		//No match but different value found
		if(compareValue==1||compareValue==-1){
			for(int i=hash; i<arrayListSize; i++ ){
				Node testNode = hashList.get(i);
				int compareValueNew = myNode.compareTo(testNode);
				//Probing results in a match, lazy delete
				if (compareValueNew==0){
					testNode.setData(-1000);
					break;
				}
			}
			for(int i=0;i<hash;i++){
				Node testNode = hashList.get(i);
				int compareValueNew = myNode.compareTo(testNode);
				//Probing results in match, lazy delete
				if (compareValueNew==0){
					testNode.setData(-1000);
					break;
				}

			}
		}
	}

	public boolean search(String searchString){
		/**
		 * Search Closed Hashing based on key and returns true or false if match is found or not
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
		Node myNode = new Node(searchString);
		Node preNode = hashList.get(hash);
		if(preNode.getData()==null){
			return false;
		}
		int compareValue = myNode.compareTo(preNode);
		if(compareValue == 0){
			return true;
		}
		if(compareValue==-1||compareValue==1){
			for(int i=hash; i<arrayListSize; i++ ){
				Node testNode = hashList.get(i);
				int compareValueNew = myNode.compareTo(testNode);
				//				System.out.println("MOVED VALUE"+i);
				if(compareValueNew == 0){
					return true;

				}
				if(testNode.getData()==null){
					return false;
				}


			}
			for(int i=0; i<hash;i++){
				Node testNode = hashList.get(i);
				int compareValueNew = myNode.compareTo(testNode);
				//				System.out.println("MOVED VALUE"+i);
				if(compareValueNew == 0){
					return true;
				}
			}

		}
		return false;

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
		int hash = 7;
		for (int i = 0; i < hashString.length(); i++) {
			hash = hash*31 + hashString.charAt(i);
			hash = hash%4007;
		}

		Node myNode = new Node(hashString);

		Node preNode = hashList.get(hash);

		if(preNode.getData()==null){

			Node newNode = hashList.get(hash);
			newNode.setData(hashString);
		}
		else{
			boolean spotFound = false;

			for(int i=hash; i<arrayListSize; i++ ){
				Node testNode = hashList.get(i);

				if(testNode.getData() == null){
					hashList.set(i, myNode);
					spotFound = true;
					break;

				}
				int compareval = testNode.compareTo(myNode);
				if(compareval==0){
					break;
				}
			}
			if (spotFound == false){
				for(int i=0; i<hash;i++){
					Node testNode = hashList.get(i);
					if(testNode == null){
						hashList.set(i, myNode);
						spotFound = true;
						break;
					}

				}


			}

		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClosedHashing myClosedHash = new ClosedHashing();
		//		myClosedHash.insert("HI");
		//		String testString = "hello3";
		//		String testString2 = "hello5";
		//		String testString3 = "hello5";
		//		myClosedHash.insert(testString);
		//		myClosedHash.insert(testString2);
		//		myClosedHash.insert(testString3);
		//		System.out.println(myClosedHash.search("HI"));
		//		myClosedHash.delete("hello5");
		//		
		//
		//		System.out.println("fin");
		Scanner myScanner;
		int textLength = 0;
		long timePre = System.currentTimeMillis();
		try {
			myScanner = new Scanner(new File("asp5202.txt"));
			while(myScanner.hasNextLine()){
				String line = myScanner.nextLine();
				String[] words = line.split("\\s+");

				for(int i=0; i < words.length;i++){
					if(words[i].length() < 2){

					}
					else{
						char lastChar = words[i].charAt(words[i].length()-1);
						if (lastChar == '.' || lastChar == ',' || lastChar == '!' || lastChar == '?' || lastChar == '"' || lastChar == ':'){
							words[i] = words[i].substring(0, words[i].length()-1);
						}
						char firstChar = words[i].charAt(0);
						if (firstChar == '"'){
							words[i] = words[i].substring(1,words[i].length()-1);
						}

					}
					textLength++;
					//					myOpenHash.insert(words[i]);




					//					System.out.println(words[i]);
					myClosedHash.insert(words[i]);

				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long timePost = System.currentTimeMillis();
		System.out.println(textLength);
		//		System.out.println("fin");


		long timeCalc = timePost-timePre;
		System.out.println("Insertion Time: "+timeCalc);
		timePre = System.currentTimeMillis();
		System.out.println(myClosedHash.search("Everyone"));
		System.out.println(myClosedHash.search("randomsrefd"));
		System.out.println(myClosedHash.search("Queries"));
		timePost = System.currentTimeMillis();
		timeCalc = timePost-timePre;

		System.out.println("Search for Everyone Time: "+timeCalc);
		timePre = System.currentTimeMillis();
		myClosedHash.delete("Everyone");
		myClosedHash.delete("randomsrefd");
		myClosedHash.delete("Queries");
		timePost = System.currentTimeMillis();
		timeCalc = timePost-timePre;


		System.out.println("Delete Time: "+timeCalc);

	}

}
