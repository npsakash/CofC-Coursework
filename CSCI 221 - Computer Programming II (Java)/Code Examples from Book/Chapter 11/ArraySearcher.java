
/**
 Class for searching an already sorted array of integers.
*/
public class ArraySearcher
{
    private int[] a;
    
    /**
     Precondition: theArray is full and is sorted
     from lowest to highest.
    */
    public ArraySearcher(int[] theArray)
    {
        a = theArray;//a is now another name for theArray.
    }
    
    /**
     If target is in the array, returns the index of an occurrence
     of target. Returns -1 if target is not in the array.
    */
    public int find(int target)
    {
        return binarySearch(target, 0, a.length - 1);
    }
    
    //Uses binary search to search for target in a[first] through
    //a[last] inclusive. Returns the index of target if target
    //is found. Returns -1 if target is not found. 
    private int binarySearch(int target, int first, int last)
    {
        int result;
        if (first > last)
            result = -1;
        else
        {
            int mid = (first + last) / 2;
            if (target == a[mid]) 
                result = mid; 
            else if (target < a[mid])
                result = binarySearch(target, first, mid - 1);
            else //(target > a[mid])
                result = binarySearch(target, mid + 1, last);
        }
        return result;
    }
}
