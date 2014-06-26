
public class reverse1 {

	public static void main(String[] s)
	{
		char[] aa  = {'h','i',' ','t','h','i','s',' ','i','s',' ','m','e','\0'};
		wordReverse(aa);
		
	}
	static void reverse(char str[], int start, int end)
	{
	    for(int i=start, j= end; i<j; ++i,--j)
	    {
	        char temp = str[i];
	        str[i] = str[j];
	        str[j] = temp;
	    }
	}

	static void wordReverse(char[] str)
	{
	    int len = str.length;
	    reverse(str,0,len-1);
	    for(int i=0,j=0;;)
	    {
	        while(str[j] != '\0' && str[j++] != ' ');
	        if(str[j] == '\0')
	        {
	            reverse(str, i, j-1);
	            break;
	        }
	        reverse(str,i,j-2);
	        i=j;
	    }
	    
	    for(int k = 0; k< str.length;k++)
	    {
	    	System.out.print(str[k]);
	    
	    }
	}
}
