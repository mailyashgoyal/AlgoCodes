
public class Wildcard {

	public Wildcard() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 test("g*ks", "geeks"); // Yes
		    test("ge?ks*", "geeksforgeeks"); // Yes
		    test("g*k", "gee");  // No because 'k' is not in second
		    test("*pqrs", "pqrst"); // No because 't' is not in first
		    test("abc*bcd", "abcdhghgbcd"); // Yes
		    test("abc*c?d", "abcd"); // No because second must have 2 instances of 'c'
		    test("*c*d", "abcd"); // Yes
		    test("*?c*d", "abcd"); // Yes

	}

	// The main function that checks if two given strings match. The first
	// string may contain wildcard characters
	static boolean match(String first, String second)
	{
	    // If we reach at the end of both strings, we are done
	    if (first == null && second == null)
	        return true;
	 
	    // Make sure that the characters after '*' are present in second string.
	    // This function assumes that the first string will not contain two
	    // consecutive '*' 
	    if (first.charAt(0) == '*' && (first+1) != null && second == null)
	        return false;
	 
	    // If the first string contains '?', or current characters of both 
	    // strings match
	    if (first.charAt(0) == '?' || first.charAt(0) == second.charAt(0))
	        return match(first+1, second+1);
	 
	    // If there is *, then there are two possibilities
	    // a) We consider current character of second string
	    // b) We ignore current character of second string.
	    if (first.charAt(0) == '*')
	        return match(first+1, second) || match(first, second+1);
	    return false;
	}
	 
	static // A function to run test cases
	void test(String first, String second)
	{  
		boolean check = match(first, second); 
		if(check == true)
			{System.out.println("Yes");}
		else
			{System.out.println("No"); }
	}

}
