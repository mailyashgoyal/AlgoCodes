import java.util.Queue;

public class BST
{
	public static void main(String args[])
	{

		int a[] = new int[10];
		int numberToSearch = 23;

		a[1] = 34;a[3] = 11;a[4]=5;a[6]=20;a[7]= 44;a[8]=1;
		a[2] = 65;a[8] = 90;a[0] = 23;

		for(int i =0; i < a.length; i++)
		{
			System.out.println(a[i]);
		}
		System.out.println("Number to be Searched"+ numberToSearch);

		BinaryTree bn= new BinaryTree();
	}

}
class BinaryTree1
{
	int value;
	BinaryTree1 left;
	BinaryTree1 right;

	public BinaryTree1(int[] values,int index) {
		Load(this,values,index);
	}
	void Load(BinaryTree1 tree, int[] values, int index)
	{
		this.value = values[index];
		if (index * 2 + 1 < values.length)
		{
			this.left = new BinaryTree1(values, index * 2 + 1);
		}
		if (index * 2 + 2 < values.length)
		{
			this.right = new BinaryTree1(values, index * 2 + 2);
		}
	}
}

class BinaryTree 
{
	class Node
	{
		Node Left;
		Node Right;
		int data;
		boolean visisted;

		Node parent;

		Node (int data)
		{
			Left = null;
			Right = null;
			this.data = data;
		}
	}

	Node root;

	public BinaryTree()
	{
		root = null;
	}
	public Node getAdjecent(Node node)
	{
		if(node.parent.Left == node  )
			return node.Right;
		else return node.Left;
	}

	public Node insert(Node node , int data)
	{

		if (node==null) { 
			node = new Node(data); 
		} 
		else { 
			if (data <= node.data) { 
				node.Left = insert(node.Left, data); 
			} 
			else { 
				node.Right = insert(node.Right, data); 
			} 
		}
		return(node);
	}

	public int lookup(Node node, int data)
	{
		if(node ==null)
		{
			return -1;
		}
		if(data == node.data)
		{
			return node.data;
		}
		else{
			if (data < node.data)
			{
				return lookup(node.Left, data);
			}
			else 
			{
				return lookup(node.Right,data);
			}
		}
	}

	public boolean isValidBST(Node node,int min, int max)
	{
		if (node == null) return true;
		if(node.data < min && node.data > max && 
				isValidBST(node.Left, min, node.data) &&
				isValidBST(node.Right, node.data, max))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void printInorder(Node node)
	{
		if(node == null)
		{
			return;
		}
		printInorder(node.Left);
		System.out.println(node.data);
		printInorder(node.Right);
	}

	public void createBinaryTreeInArray(Node node, int[] array, int data,int index)
	{
		if(node == null)
		{
			return;
		}
		array[index] = node.data;
		index++;
		createBinaryTreeInArray(node.Left, array, data, index);
		createBinaryTreeInArray(node.Right, array, data, index);
	}


	public Node BFS(Node node)
	{
		Queue<Node> qq =  (Queue<Node>) new LinkedList();
		node.visisted = true;
		qq.add(node);
		while(!qq.isEmpty())
		{
			Node r = (Node) qq.poll();
			//foreach(Node2 n in )
		}
		if(node == null) return null;
		else
		{
			if(node.Left != null && node.Right != null)
			{
				qq.add(node.Left);
				qq.add(node.Right);
			}


		}
		return node;
	}



	/* Returns true if binary tree with root as root is height-balanced */
	public boolean isBalanced(Node root)
	{

		int lh; /* for height of left subtree */
		int rh; /* for height of right subtree */
		/* If tree is empty then return true */
		if(root == null)
			return true; 
		/* Get the height of left and right sub trees */
		lh = height(root.Left);
		rh = height(root.Right);

		if( (Math.abs(lh-rh) <= 1 ) &&  isBalanced(root.Left) && isBalanced(root.Right))
			return true;

		/* If we reach here then tree is not height-balanced */
		return false;
	}

	/* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */

	/* returns maximum of two integers */
	int max(int a, int b)
	{
		return (a >= b)? a: b;
	}

	/*  The function Compute the "height" of a tree. Height is the
	    number of nodes along the longest path from the root node
	    down to the farthest leaf node.*/
	int height(Node node)
	{
		/* base case tree is empty */
		if(node == null)
			return 0;

		/* If tree is not empty then height = 1 + max of left
	      height and right heights */
		return 1 + max(height(node.Left), height(node.Right));
	} 

	/* This is the core function to convert Tree to list. This function follows
	  steps 1 and 2 of the above algorithm */
	Node bintree2listUtil(Node root)
	{
		// Base case
		if (root == null)
			return root;

		// Convert the left subtree and link to root
		if (root.Left != null)
		{
			// Convert the left subtree
			Node left = bintree2listUtil(root.Left);

			// Find inorder predecessor. After this loop, left
			// will point to the inorder predecessor
			for (; left.Right!=null; left=left.Right);

			// Make root as next of the predecessor
			left.Right = root;

			// Make predecssor as previous of root
			root.Left = left;
		}

		// Convert the right subtree and link to root
		if (root.Right!=null)
		{
			// Convert the right subtree
			Node right = bintree2listUtil(root.Right);

			// Find inorder successor. After this loop, right
			// will point to the inorder successor
			for (; right.Left!=null; right = right.Left);

			// Make root as previous of successor
			right.Left = root;

			// Make successor as next of root
			root.Right = right;
		}

		return root;
	}

	// The main function that first calls bintree2listUtil(), then follows step 3 
	//  of the above algorithm
	Node bintree2list(Node root)
	{
		// Base case
		if (root == null)
			return root;

		// Convert to DLL using bintree2listUtil()
		root = bintree2listUtil(root);

		// bintree2listUtil() returns root node of the converted
		// DLL.  We need pointer to the leftmost node which is
		// head of the constructed DLL, so move to the leftmost node
		while (root.Left != null)
			root = root.Left;

		return (root);
	}


	public boolean isCyclic(Node head)
	{ Node fast = head; 
	Node slow = head; 
	while(fast!= null && fast.next != null)
	{ fast = fast.next.next; 
	slow = slow.next; 
	//if fast and slow pointers are meeting
	//then LinkedList is cyclic 
	if(fast == slow )
	{ return true; } }
	return false; }
}
}

Read more: http://javarevisited.blogspot.com/2013/05/find-if-linked-list-contains-loops-cycle-cyclic-circular-check.html#ixzz2sPH2QNbV
}