
public class MinDist {

	
	/*a is array, n is size of array,
	b and c are the 2 numbers
	between which we have to find min distance.*/
	static int minDist(int a[], int n, int b, int c) {

	    int  ret = 100, cur = -1;

	    while(n != 0) 
	    {
	     
	    	n--;
	    	if(a[n] == b || a[n] == c) {
	            if(cur != -1 && a[cur] != a[n]) 
	            {
	            	if(ret < (cur-n))
	            	{
	            	}
	            	else
	            	{
	            		ret = cur-n;
	            	}
	            }
	            cur = n;
	        }
	    }
	    return ret;
	}

	static int minDistance ( int arr[], int n, int x, int y) {

	    if(x == y) return 0;
	    int index1 = -1;
	    int index2 = -1;
	    int minvalue = n;

	    for(int i = 0 ; i < n; i++){
	        if((arr[i] == x) && ((i-index2) < minvalue)){
	              index1 = i;                                    
	              if( index2 != -1)minvalue = i-index2;
	        }else if((arr[i] == y) && ((i-index1) < minvalue)){
	              index2 = i;                                    
	              if( index1 != -1)minvalue = i-index1;
	        }     
	    }
	    return minvalue;
	}

	public static void main(String[] s) {

	    int a[] = {1, 2, 10, 2, 3, 5, 2, 1, 5};
	    System.out.println( minDist(a, a.length, 10, 5));
	    System.out.println( minDistance(a, a.length, 10, 5));
	}
}
