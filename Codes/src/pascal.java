
public class pascal {
	 
	   public static void main(String[] args) {
	       
	      int n = 10;
	       
	      int[] row = new int[0];
	       
	      for (int i=0; i<n; i++) {
	          
	         // Calculate next row
	          
	         row = pascalRow(row);
	 
	         // Output row
	         // First add some padding so triangle is centered
	          
	         for (int j=0; j< n - i; j++) {
	            System.out.print(" ");
	         }
	          
	         // Now output the row values
	          
	         for (int j=0; j< row.length; j++) {
	            System.out.print(row[j]+" ");
	         }
	         System.out.println();
	          
	      }
	   }
	 
	   public static int[] pascalRow(int[] previous) {
	       
	      // Row is 1 element longer than previous row
	       
	      int[] row = new int[previous.length + 1];
	       
	      // First and last numbers in row are always 1
	       
	      row[0] = 1;
	      row[row.length - 1] = 1;
	       
	      // The rest of the row can be 
	      // calculated based on previous row
	       
	      for (int i = 1; i< row.length-1; i++) {
	         row[i] = previous[i-1] + previous[i];
	      }
	       
	      return row;
	   }
	}