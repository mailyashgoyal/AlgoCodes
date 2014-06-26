
public class RotateMatrix {
    final int ROW = 5;
    final int COL = 5;
	public static void main(String[] args) {
		int mat[][] = {{2,1,5,3,4},{5,8,6,4,4},{9,12,6,9,4},{8,7,6,5,2},{1,2,3,4,5}};
		RotateMatrix rm = new RotateMatrix();
		System.out.println("Original Matrix:");
		rm.displayMat(mat);
		//Get transpose of matrix
        int temp;
		for(int i=0, j=0; i<rm.ROW; i++){
			j=i;
			for(; j<rm.COL; j++){
				if(i!=j){
					temp = mat[i][j];
					mat[i][j] = mat[j][i];
					mat[j][i] = temp;					
				}				
			}
		}
		System.out.println("Matrix after transpose:");
		rm.displayMat(mat);
		int c = 0;
		while(c<rm.COL/2){
			for(int i=0; i<rm.ROW; i++){
				temp = mat[i][c];
				mat[i][c] = mat[i][rm.COL-c-1];
				mat[i][rm.COL-c-1] = temp;
			}
			c++;
		}
		System.out.println("Matrix after rotation:");
		rm.displayMat(mat);
	}
	void displayMat(int mat[][]){

		for(int i=0; i<ROW; i++){
			for(int j=0; j<COL; j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}