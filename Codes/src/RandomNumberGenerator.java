
public class RandomNumberGenerator {

	public RandomNumberGenerator() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(uni_rv());
		System.out.println(uni_rv());
	}

	 static double Seed= 1234.0;
	// returns a uniform (0,1) random variable 
	static double uni_rv()
	{
		 int k = 16807;
		   double m = 2147483647.0;
		   double RandNum = 0.0; 
		   double Temp = ( (k*Seed)%m); 
		   RandNum = Temp/m;
		   Seed = Temp;
		   return RandNum;
	}

	// returns an exponential r.v.
	static double exp_rv(double lambda)
	{
		 double exp;
		 exp = ((-1) / lambda) * Math.log(uni_rv());
		 return(exp);
		}
	

}
