
public class Rectangle
{
	/**
	 * instance variables needed to represent one rectangle
	 */
	private int x,y,width,height;
	String name;
	
	public boolean overlaps(Rectangle a)
	{
		if (((a.x>=x) && (a.x<=(x+width))) || ((x>=a.x) && (x<=(a.x+a.width))))
		{
			if (((a.y>=y) && (a.y<=(y+height))) || ((y>=a.y) && (y<=(a.y+a.height))))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public Rectangle intersect(Rectangle a)
	{
		int left,top,right,bottom;
		
		//the intersect is defined by the rectangle whose top left corner is the "maximum" of the two corners, and whose bottom right corner is the "minimum" of the two bottom right corners
		
		//finding the rightmost between the two start points
		if (x>a.x)
			left = x;
		else
			left = a.x;
			
		//finding the bottommost between the two start points
			
		if (y>a.y)
			top = y;
		else
			top = a.y;
			
		//finding the leftmost between the two bottom right points
			
		if ((x+width)<(a.x+a.width))
			right = x+width;
		else
			right = a.x+a.width;
			
		//finding the uppermost between the two bottom right points
		
		if ((y+height)<(a.y+a.height))
			bottom = y+height;
		else
			bottom = a.y+a.height;
			
		//System.out.println("left="+left+" right="+right+" top="+top+" bottom="+bottom);
		return new Rectangle(this.name+"-intersection-"+a.name,left,top,right-left,bottom-top);
	}	
	public static void main(String[] args) {
		int r1 = 4 , r2 = 4, h1 = 10, w1 =10;
		int s1= 5, s2 = 5 , h2 = 12, w2 =  12;
	
	}
	
	public Rectangle(String name,int x,int y,int width, int height)
	{
		this.name = name;
		this.x = x;
		this.y = y;
		if (width>0)
			this.width = width;
		else
			width = 0;
			
		if (height>0)
			this.height = height;
		else
			height = 0;
	}

}
