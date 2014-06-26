
public class MergeSort {

	public static void main(String[] args) {
		int[] a = new int[5];
		a[0] = 7;
		a[1] = 8;
		a[2] = 3;
		a[3] = 1;
		a[4] = 6;
		/*a[5] = 9;
		a[6] = 2;
		a[7] = 10;
		a[8] = 4;
		a[9] = 5;*/
		System.out.println("start");
		int[] aux = new int[a.length];

		sort(a,aux,0,a.length-1);
	}

	public static void sort(int[] a, int []aux,int lo,int hi)
	{
		if(hi <= lo) return;
		int mid = lo+(hi-lo)/2;
		//if (mid == 1) return;
		System.out.println("mid "+ mid);
		sort(a,aux,lo,mid);
		System.out.println("step sort 1 done");
		sort(a,aux,mid+1,hi);
		System.out.println("step sort 2 done");
		merge(a,aux,lo,mid,hi);

		for(int i= 0; i < a.length; i ++)
		{
			System.out.println(a[i]);
		}
	}
	public static void merge(int[]a, int [] aux, int lo,int mid, int hi)
	{
		for(int i= 0; i < a.length; i ++)
		{
			aux[i] = a[i];
		}
		int i = lo, j= mid+1;
		for(int k = lo; k <= hi ;k++)
		{
			if(i > mid) a[k] = aux[j++];
			else if (j > hi) a[k] = aux[i++];
			else if ((aux[j]<aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
	}

}


