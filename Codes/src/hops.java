public class hops {
	public static void main(String[] args) {

		int k = calculateHops();
		if(k == -1)
		{
			System.out.println(k);
		}
		else
		{
			System.out.println(k);
		}
	}

	public static int calculateHops()
	{
		Integer array[] = new Integer[7];
		array[0] = 3; array[1] = -1; array[2] = 2; array[3] = 5; array[4]= -1; array[5] = -1; array[6] = 4;

		int j =0;
		int pawn  = 0;
		int hops = -1;
		boolean hasvisted[] = new boolean[7];
		for(int i =0 ; i < array.length ; i ++)
		{
			if(hasvisted[i] == false && i> 0 && i < array.length)
			{
				i = array[i];
				hasvisted[i] = true;
				hops = hops + 1;
			}
			else
			{
				return -1;
			}
		}
		return hops;
	}

}
