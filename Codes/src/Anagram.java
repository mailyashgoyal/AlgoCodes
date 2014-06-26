import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Anagram extends Animal {

	public static void main(String[] args) throws IOException {
	        // TODO code application logic here
	        System.out.println("Enter the first string");
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String s1 = br.readLine().toLowerCase();
	        System.out.println("Enter the Second string");
	        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
	        String s2 = br2.readLine().toLowerCase();
	        char c1[] = null;
	        char c2[] = null;
	        if (s1.length() == s2.length()) {


	            c1 = s1.toCharArray();
	            c2 = s2.toCharArray();

	            Arrays.sort(c1);
	            Arrays.sort(c2);

	            if (Arrays.equals(c1, c2)) {
	                System.out.println("Both strings are equal and hence they have anagram");
	            } else {
	                System.out.println("Sorry No anagram in the strings entred");
	            }

	        } else {
	            System.out.println("Sorry the string do not have anagram");
	        }
	    }
	
}
