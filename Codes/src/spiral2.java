
public class spiral2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int[][] a = new int[][]{ {1,2,3,4},
                                 {5,6,7,8},
                                 {9,10,11,12},
                                 {13,14,15,16}};
        
        printSpiralMatrix(a,4,4);
       
        }

    private static void printSpiralMatrix(int[][] a, int m, int n) {
        
        // m = total number of rows = 4
        // n = total number of columns
        int k = 0; // Row starts
        int l = 0; // column starts
        
        while(k<m && l<n){
            
          //print first row....
            for(int i = l;i<n;i++){
                System.out.println(a[k][i]);
            }
            k++;
            
            for(int i=k;i<m;i++){
                System.out.println(a[i][n-1]);
            }
            
            n--;
            for(int i= n-1; i>=l;--i){
                System.out.println(a[m-1][i]);
            }
            m--;
            
            for(int i=m-1;i>=k;--i){
                System.out.println(a[i][l]);
            }
            l++;
            
            
        }
        
    }

    }