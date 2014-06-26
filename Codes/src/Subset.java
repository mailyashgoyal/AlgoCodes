
public class Subset {

	static void recursive_calculate_sum(int input[], int target, int remaining[]) {
		int i, j;
		int sum;
		int tmp_array[] = new int[4];
		int tmp_remaining[] = new int[4];

		for(i=0; i < 4; i++)  {
			tmp_remaining[i] = 0;
			tmp_array[i] = 0;
		}


		// do the sum
		sum = 0;
		for(i=0; i < 4; i++) {
			sum += remaining[i];
		}
		System.out.println();
		// if sum meets crieteria the print values
		if (sum == target) {
			System.out.print("Hit Sum:  - "+ sum+ ",");
			for(i=0; i < 4; i++)
				System.out.print(" "+ remaining[i]);
			//System.out.println("\n");
		} 

		// sum is too great, break
		if (sum >= target) {
			return ;
		}

		// build up array for recursive function - bug here with setting up array, initial array is all set to zero
		for (i=0; i < 4 ; i++) {
			for (j = i + 1; j < 4; j++ ) {
				tmp_remaining[i] = input[j];
			}
			tmp_array[i] = input[i];
			recursive_calculate_sum(tmp_remaining, target, tmp_array);
		}

	}


	static void calculate_sum(int input[], int target) {
		int remaining[] = new int[4];
		int i;

		// make sure array is filled with zeros before starting
		for(i=0; i < 4; i++) 
			remaining[i] = 0;

		recursive_calculate_sum(input, target, remaining);
	}


	public static void main(String[] args){

		//int input[] = { argv[2], argv[3] , argv[4], argv[5] };
		int input[] = new int[4];
		int target = 15;

		// pre-sorted list
		input[0] = 5;
		input[1] = 5;
		input[2] = 10;
		input[3] = 15;

		/*
	input[0] = 15;
	input[1] = 10;
	input[2] = 5;
	input[3] = 5;
		 */


		// print inputs
		System.out.println( input[0] + " " +  input[1] + " " + input[2] +" " + input[3]+ " " + target);

		calculate_sum(input, target);

		
	}
}