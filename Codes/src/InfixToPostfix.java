import java.util.Stack;


public class InfixToPostfix {

	public static void main(String[] args) {

		Stack ss1 = new Stack();
		Stack ss2 = new Stack();
		String s = "((2+3)+5)*6+8";

		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == '(' || s.charAt(i) ==')' || s.charAt(i) =='-' || 
					s.charAt(i) =='/' || s.charAt(i) =='*' || s.charAt(i) =='+')
			{
				if(ss1.firstElement() != null)
				{
					
				}
				ss1.push(s.charAt(i));
			}
			else
			{
				ss2.push(s.charAt(i));
			}
					
		}

	}
}
