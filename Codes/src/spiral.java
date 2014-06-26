
public class spiral {
static void spiral1(int a[][],int x,int y){

    //If the x and y co-ordinate collide, break off from the function

    if(x==y)
        return;
    int i;

    //Top-left to top-right

    for(i=x;i<y;i++)
        System.out.println(a[x][i]);

    //Top-right to bottom-right 

    for(i=x+1;i<y;i++)
        System.out.println(a[i][y-1]);

    //Bottom-right to bottom-left

    for(i=y-2;i>=x;i--)
        System.out.println(a[y-1][i]);

    //Bottom left to top-left

    for(i=y-2;i>x;i--)
        System.out.println(a[i][x]);

    //Recursively call spiral

    spiral1(a,x+1,y-1);

}

public static void main(String[] args) {

    int a[][]={{1,2,3,4,22},{5,6,7,8,33},{9,10,11,12,44},{13,14,15,16,55}};
    spiral1(a,0,5);
    /*Might be implemented without the 0 on an afterthought, all arrays will start at 0 anyways. The second parameter will be the dimension of the array*/ 

    }

}