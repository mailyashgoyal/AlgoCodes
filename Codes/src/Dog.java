import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Dog extends Animal {

	public Dog() {
		System.out.println("Dog Constructor");
	}

	public void Move()
	{
		System.out.println("dogMove");
	}

	public void work()
	{
		
	}
	public static void main(String[] args) {

		Animal ss = new Dog();
		ss.Move();
		try {
			ArrayList<ArrayList<String>> topoArray  = readConfigTopo();
			
			for(int i =0; i < topoArray.size();i++)
			{
				for(int j = 0; j < topoArray.get(i).size() ;j++)
				{
					System.out.println(topoArray.get(i).get(j));
				}
				System.out.println("");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<ArrayList<String>> readConfigTopo() throws IOException
	{
		ArrayList<ArrayList<String>> st = new ArrayList<ArrayList<String>>();
		FileInputStream fstream =null;
		try {fstream = new FileInputStream("C:\\Users\\Yash\\workspace\\Codes\\src\\topology.txt");}
		catch (FileNotFoundException e)
		{e.printStackTrace();}
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine ;
		int k = 0;

		int connections = 0;
		strLine = br.readLine();
		while (strLine != null)   
		{
			if(k == 0)
			{
				// first line tell about number of routers
				connections = Integer.parseInt(strLine);
				k++;
			}
			else
			{
				String ss = null;
				ArrayList<String> string = new ArrayList<String>();
				// get the substring and put in another array
				for (int i =0 ; i <connections ;i ++)
				{
					int spc = 0;
					spc = strLine.indexOf(" ");
					if(spc == -1)
					{
						ss = strLine.substring(0);
						string.add( ss);
					}
					else
					{
						ss = strLine.substring(0,spc);
						string.add( ss);
						strLine = strLine.substring((ss.length()+1));
					}
				}
				st.add(string);
				strLine = br.readLine();
			}
		}
		br.close();
		fstream.close();
		return st;
	}
}
