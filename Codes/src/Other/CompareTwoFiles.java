import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Problem statement:
    Input file 1 contains names and other strings.
 	Input file 2 contains a list of names, one name per line.
	Take these 2 files as input and print to standard out 
	the line numbers from file 1 where the name in file 2 is found. 
	For example, if file 2 contains the name Alice, expected output would be Alice: 4, 56, 200. 
	This means in file 1, the name Alice appears in the file on line 4, 56, and 200.
	
	Assumptions: File is not too big(Even for big file this code should work).
				 File1 : contains names and string
				 		 can repeat the names 
				 		 names can occur anywhere in the string
				 		 the string in a line are seperated by space
				 File2 : Contains only names (one per each line)
	Created two file input streams
 */
public class CompareTwoFiles {

	/**
	 * PreProcess pattern methof
	 * @param ptrn
	 * @return
	 */
	public int[] preProcessPattern(char[] ptrn) {
		int i = 0, j = -1;
		int ptrnLen = ptrn.length;
		int[] b = new int[ptrnLen + 1];

		b[i] = j;
		while (i < ptrnLen) {
			while (j >= 0 && ptrn[i] != ptrn[j]) {
				// if there is mismatch consider next widest border
				j = b[j];
			}
			i++;
			j++;
			b[i] = j;
		}

		return b;
	}

	/**
	 * Substring search using KMP algorithm
	 * @param text
	 * @param ptrn
	 * @return
	 */
	public boolean searchSubString(char[] text, char[] ptrn) {
		int i = 0, j = 0;
		// pattern and text lengths
		int ptrnLen = ptrn.length;
		int txtLen = text.length;
		boolean found =false;
		// initialize new array and preprocess the pattern
		int[] b = preProcessPattern(ptrn);

		while (i < txtLen) {
			while (j >= 0 && text[i] != ptrn[j]) {
				j = b[j];
			}
			i++;
			j++;

			// a match is found
			if (j == ptrnLen) {
				found = true;;
				j = b[j];
			}
		}
		return found;
	}

	/**
	 * Main function
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		CompareTwoFiles comp = new CompareTwoFiles();
		comp.Compare();
	}

	/**
	 * Compare function to launch the files and read the file
	 * @throws IOException
	 */
	public void Compare() throws IOException
	{
		FileInputStream fstream1 =null;
		FileInputStream fstream2 =null;
		try {
			fstream2 = new FileInputStream("C:\\file2");
		}
		catch (FileNotFoundException e)
		{e.printStackTrace();}

		//reading file2 first
		DataInputStream in2 = new DataInputStream(fstream2);
		BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
		String strLinefile2  = null;
		
		//creating references
		DataInputStream in1 = null;
		BufferedReader br1 = null;
		String strLinefile1  = null;
		
		//read file2 line by line  for every name we have to check a string in file1
		while ((strLinefile2 = br2.readLine()) != null) 
		{
			try {

				fstream1 = new FileInputStream("C:\\file1");
			}
			catch (FileNotFoundException e)
			{e.printStackTrace();}

			//Creating data stream for file1
			//could have created hashtable for storing, but in case of large file "file1" will through  outOfMemory Exception.
			//So there is a tradeoff between memory and speed
			in1 = new DataInputStream(fstream1);
			
			//In case we have a large file, we can use MappedBufferByte 
			// using :
			//java.nio.MappedByteBuffer bytebuf = new FileInputStream("file1").getChannel().map(java.nio.channels.FileChannel.MapMode.READ_ONLY, 0, 100);
			//where 100 is size provided by user and then read the bytebuf by decoding it to chararray(have to import CharSet).
	        br1 = new BufferedReader(new InputStreamReader(in1));
			strLinefile1  = null;

			//Displaying Name
			System.out.print(strLinefile2+":");
			int lineNumber = 0;
			// read file 1 line by line
			// The string per line can be big enough, so didnt create a hash table
			while ((strLinefile1 = br1.readLine()) != null) 
			{  
				//Using Knuth Morris Prat String Search Algorithm, to find a substring in a string
				if(searchSubString(strLinefile1.toCharArray(), strLinefile2.toCharArray()) == true)
				{
					// Displaying line number if match found
					System.out.print(lineNumber +" ");
				}
				lineNumber++;
			}
			System.out.println();
		}	
	}
}