package Other;

import java.util.Stack;

/**
 * Write a function that given an input array of integers with 4 entries and a desired
 * target_sum, returns the number of combinations, of any length, that add up to that target_sum.
 * 
 * Complexity O(nt) where n  is size of array and t is targetSum
 * @author Yash
 *
 */
public class SubSetSum {

	
	Stack<Integer> stack = new Stack<Integer>();
	int sumInStack = 0;

	public static void main(String[] args) {
		
		int array[] = {3, 4, 5, 2};
		int sum = 9;
		//Array : this can be of any size : for the bonus question it has been extended
		/*int[] array = { 1, 3, 4, 5, 6, 2, 7, 8, 9, 10, 11, 13, 14, 15 };
		//Sum value
		int sum = 15;*/
		SubSetSum sub = new SubSetSum();
		sub.determineSubset(array, 0, array.length,  sum);
	}

	/**
	 * determineSubset and print all the combinations of the subset which form the target value
	 * @param data
	 * @param start
	 * @param end
	 * @param sum
	 */
	public void determineSubset(int[] data, int start, int end, int sum) {

		//Check if sum of elements stored in Stack is equal to the expected target sum.
		//printing out the values
		if (sumInStack == sum) {
			StringBuilder sb = new StringBuilder();
			sb.append(sum).append(" = ");
			//Just for printing
			for (Integer i : stack) {sb.append(i).append("+"); }
			System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
		}

		// method which checks if the sum in stack has got values more than sum,
		// if not then it will repeat
		for (int i = start; i < end; i++) 
		{
			if (sumInStack + data[i] <= sum) 
			{
				// Stack is used for memoization, 
				// this program could have been used without adding stack, but then
				// the values would not have been displayed
				// Although no difference in time complexity, but memory is being added here.
				stack.push(data[i]);
				sumInStack += data[i];
				// recursively proceeding further
				// new data set now from new i+1 to i
				determineSubset(data, i + 1, end, sum);
				sumInStack -= (Integer) stack.pop();
			}
		}
	}
}