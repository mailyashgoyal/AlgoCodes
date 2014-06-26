
public class foobar {

	public foobar() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for(int i=1; i <= 75;i++){
			if(i %5 == 0 && i %7 ==0)
			{
				System.out.println(i + "foobar");
			}
			else if(i%5 ==0)
			{	
				System.out.println(i+"foo");
			}
			else if(i%7 ==0)
			{
				System.out.println(i+"bar");
			}
			else 
			{
				System.out.println(i);
			}
			
		}
	}

}
