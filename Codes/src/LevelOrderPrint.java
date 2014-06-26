import java.util.Queue;

class Node4
{
	Node4 Left;
	Node4 Right;
	int data;
	boolean visisted;

	Node4 parent;

	Node4 (int data)
	{
		Left = null;
		Right = null;
		this.data = data;
	}
}

public class LevelOrderPrint {

	public static void main(String[] args) {
		
		Node4 n1 = new Node4(0);
		Node4 n2 = new Node4(2);
		
		Node4 r3 = new Node4(3);
		r3.Left = n1;
		r3.Right = n2;
		
		Node4 r4 = new Node4(3);
		r4.Left = n1;
		r4.Right = n2;
		
		Node4 r5 = new Node4(3);
		r5.Left = r3;
		r5.Right = r4;
		
		printLevelOrder(r5);

	}
	
	static void printLevelOrder(Node4 root) {
		
		if (root == null ) return;
		@SuppressWarnings("unchecked")
		
		Queue<Node4> nodesQueue =  (Queue<Node4>) new LinkedList();
		int nodesInCurrentLevel = 1;
		int nodesInNextLevel = 0;
		nodesQueue.add(root);
	
		while (!nodesQueue.isEmpty()) 
		{
			Node4 currNode = nodesQueue.peek();
			nodesQueue.poll();
			nodesInCurrentLevel--;
		
			if (currNode != null) {
				System.out.println(currNode.data + " ");
				nodesQueue.add(currNode.Left);
				nodesQueue.add(currNode.Right);
				nodesInNextLevel += 2;
			}
			
			if (nodesInCurrentLevel == 0) {
				System.out.println("");
				nodesInCurrentLevel = nodesInNextLevel;
				nodesInNextLevel = 0;
			}
		}
	}
}
