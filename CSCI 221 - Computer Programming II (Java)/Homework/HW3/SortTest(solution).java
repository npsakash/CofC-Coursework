import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author Program 3 - Sort Test Cases
 * @date 16 Oct 2016
 * 
 * Used to test implemented selection sort 
 * methods in the Utils class.
 *
 */
public class SortTest {
	
	/**
	 * 
	 * @param slist
	 * @param tlist
	 * @return
	 */
	public static boolean compare( int[] slist, List<Integer> tlist ) {
		
		Collections.sort( tlist );
		
		if ( tlist.size() != slist.length ) return false;
		
		for ( int i=0; i<slist.length; i++ ) {
			
				if ( tlist.get( i ) != slist[i] ) return false;
			
		}
		
		return true;
		
	} // compare() method
	
	
	/**
	 * 
	 * @param slist
	 * @param tlist
	 * @return
	 */
	public static boolean compare( double[] slist, List<Double> tlist ) {
		
		Collections.sort( tlist );
		
		if ( tlist.size() != slist.length ) return false;
		
		for ( int i=0; i<slist.length; i++ ) {
			
				if ( tlist.get( i ) != slist[i] ) return false;
			
		}
		
		return true;
		
	} // compare() method
	
	
	/**
	 * 
	 * @param sortAlgo
	 * @return
	 */
	public static int testSortAlgorithm( String sortAlgo ) {
		
		Random numGen = new Random();
		
		int high = 100;
		int low = -100;
		
		int pass = 0;
		int N = 100;
		
		if ( sortAlgo.equalsIgnoreCase( "integer") ) {
			
			List<Integer> tList = new ArrayList<Integer>();
			
			int[] list = null;
			
			for ( int r=0; r<N; r++ ) {
			
				int n = numGen.nextInt( 100 );
				
				list = new int[n];
				tList.clear();
				
				for ( int i=0; i<n; i++ ) {
					
					int r_num = ( numGen.nextInt( high-low ) + low );
					
					list[i] = r_num;
					tList.add( r_num );
					
				}
				
				Utils.selectionSort( list );
				
				if ( compare( list, tList ) ) pass++;
			
			}
			
			
		} else {
			
			List<Double> tList = new ArrayList<Double>();
			
			double[] list = null;
			
			for ( int r=0; r<N; r++ ) {
			
				int n = numGen.nextInt( 100 );
				
				list = new double[n];
				tList.clear();
				
				for ( int i=0; i<n; i++ ) {
					
					double r_num = ( numGen.nextDouble()*((double)(high-low)) ) + ( (double)low );
					
					list[i] = r_num;
					tList.add( r_num );
					
				}
				
				Utils.selectionSort( list );
				
				if ( compare( list, tList ) ) pass++;
				
			}
			
			
		}
		
		System.out.printf( "[%s] %d of %d Sort Tests Passed [%.2f %%]\n", sortAlgo, pass, N, (((double)pass)/((double)N))*100 );
		
		return pass;
		
		
	} // end testSelectionSort() 


	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] P = new int[2];
		
		System.out.println("----------------------------");
		P[0] = testSortAlgorithm( "integer" );
		P[1] = testSortAlgorithm( "double" );
		
		double sum = (double)(P[0]+P[1]);
		double max = 200.0;
		
		System.out.println("----------------------------");
		System.out.printf("Total Score = %.2f %%\n", (sum/max)*100.0);
		System.out.println("----------------------------");

	} // end main() method

} // end SortTest class definition
