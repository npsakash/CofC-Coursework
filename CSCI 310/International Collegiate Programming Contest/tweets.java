import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class tweets {
		private HashMap<String, ArrayList> structure;
		
		public tweets(){
			this.structure = new HashMap<String, ArrayList>();
		}
		
	
	
	
	public static ArrayList<String> readInput(String line){
		int counter = 0;
		ArrayList<String> result = new ArrayList<String>();
		String[] lineSp = line.split(" ");
		for (int i=0; i<lineSp.length; i++){
			if (lineSp[i].contains("@")){
				result.add(lineSp[i]);
//				System.out.println(result.get(counter));
				counter++;
			}
		}
		return result;
		
	}
	
	public static boolean containsParents (ArrayList<String> data,String main){
		boolean result = false;
	    for (int i=0; i<data.size(); i++){
	      if(data.get(i).equals(main)){
	        result = true;
	      }
	    }
	    return result;
	}
	
	public static ArrayList<String> getParents(ArrayList<String> data, String main){
		while(data.remove(main)) { };
		return data;
	}
	
	public void addChildren(String element, ArrayList<String> data){
				this.structure.put(element, data);
		}
	
	public void addParents (ArrayList<String> data, String main){
			ArrayList<String> result = new ArrayList<String>();
			ArrayList<String> array = getParents(data, main);
			for (int i=0; i<data.size(); i++){
				this.structure.put(array.get(i), result);
		}
	}
	public String toString(){
		return this.structure.toString();
	}
	
	public ArrayList<String> getData(String key){
		return this.structure.get(key);
	}
	
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		System.out.println(number);
		tweets t = new tweets();
		for (int h=0; h<=number; h++){
			ArrayList<String>data = readInput(in.nextLine());
			if (containsParents(data, "@vandeldensa")){
				t.addParents(data, "@vandeldensa");	
			}
//			for (int k=0; k<t.structure.size();k++){
//				if (t.structure.containsKey(data.get(h))){
//					t.addChildren(data.get(h), data);
//			
//			System.out.println(data.get(h));
			
//				}
//		}
		}
		System.out.println(t.toString());
		
		in.close();

	}

}