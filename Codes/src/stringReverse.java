import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class stringReverse {

	public stringReverse() {

	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		
		String str1  = "";
		StringBuilder strb = new StringBuilder() ;
		for(int i=0; i < str.length(); i++)
		{
			strb.append(str.charAt(str.length()-1-i));
			str1 = str1 + str.charAt(str.length()-1-i);
		}

		System.out.println(strb);
		System.out.println(str1);
	}
	
	public static void recursive()
	{
		
	}

}
