
public class bitwisePower {

	public static void main(String[] args) {

		System.out.println(recPower(5,-4));
	}

	public static double recPower(double x, double y)
	{
		if(x == 0) return 0;
		if(y == 0) return 1;
		if(y == 1) return x;
		if(y == 2)  return x*x;
		return recPower(x, y/2) * recPower(x, y - y/2);
	}

	public static int  Power(int x,int y)
	{
		if(x == 0) return 0;
		if(y == 0) return 1;
		//if(y == 1) return x;
		int result = 1;
		while(y >= 1)
		{
			y--;
			result = result*x;
		}
		return result;
	}
}
