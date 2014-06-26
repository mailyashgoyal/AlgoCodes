import java.util.Random;


public class Quicksort {

	public static void sort(int[] b)
	{
		for(int i=0 ; i < b.length; i ++)
		{
			System.out.print(" "+ b[i]);
		}
		int a[] = shuffle(b);
		for(int i=0 ; i < a.length; i ++)
		{
			System.out.print(" "+ a[i]);
		}
		System.out.println("");
		quick(a,0,a.length-1);
		for(int i=0 ; i < a.length; i ++)
		{
			System.out.println("Final Array " + a[i]);
		}
	}
	public static void quick(int[]a ,int lo, int hi)
	{
		if(hi<= lo) return;
		int j = partition(a,lo,hi);
		System.out.println("j is"+ j);
		quick(a,lo,j-1);
		System.out.println("b");
		quick(a,j+1,hi);
		System.out.println("c");
	}
	public static int partition(int[] b, int lo, int hi)
	{
		int i = lo;
		int j= hi +1;
		int temp = -1;
		
		while(true)	
		{
			//System.out.println("ji");
			while(b[++i]<b[lo])
			{
				if(i == hi){ break;}
			}
			while(b[lo]<b[--j])
			{
				if(j == lo ){break;}
			}
			if(i >= j)
				{break;}
			
			temp = i;
			i=j;
			j=temp;	

		}
		temp = lo;
		lo=j;
		j=temp;
		return j;
	}

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
		sort(a);
	}
	public static int[] shuffle(int[] b)
	{
		Random rand = new Random();
		for(int i = 0 ; i < b.length; i++)
		{
			int r = rand.nextInt(i + 1);
			int temp = -1;
			temp = b[i];
			b[i] = b[r];
			b[r]= temp;
		}
		return b;
	}

}
