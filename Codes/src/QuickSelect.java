
public class QuickSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int QuickSelect(int[] A, int k)
	{
	  //let r be chosen uniformly at random in the range 1 to length(A)
	 int r=4;
	  int pivot = A[r];//let this avlue
	  //let A1, A2 be new arrays
	  int A1[],A2[];
	  //# split into a pile A1 of small elements and A2 of big elements
	  for (int i = 1 ; i < n ;i++)
	  {
	    if (A[i] < pivot)
	      {A[i].add(A1);}
	    else if (A[i] > pivot)
	      {A[i].add(A2)}
	    else
	      {//# do nothing
	    	}
	  }
	  if (k <= A.length)
	  { 
		  //# it's in the pile of small elements
	      return QuickSelect(A1, k);
	  }
	  else if (k > A.length - A2.length)
	  {
		   //# it's in the pile of big elements
		   return QuickSelect(A2, k - (A.length - A2.length));
	  }
	  else
	  {
		  //# it's equal to the pivot
		  return pivot;
	  }
	}
}
