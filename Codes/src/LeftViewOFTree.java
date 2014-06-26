class node5
{
	int data;
	node5 left, right;
}

public class LeftViewOFTree {

	public static void main(String[] args) {

		node5 root = newNode(12);
		root.left = newNode(10);
		root.right = newNode(30);
		root.right.left = newNode(25);
		root.right.right = newNode(40);

		leftView(root);
	}

	// A utility function to create a new Binary Tree node
	static node5 newNode(int item)
	{
		node5 temp =  new node5();
		temp.data = item;
		temp.left = temp.right = null;
		return temp;
	}

	// Recursive function to print left view of a binary tree.
	static void leftViewUtil(node5 root, int level, int max_level)
	{
		// Base Case
		if (root== null)  return;

		// If this is the first node of its level
		if (max_level < level)
		{
			System.out.println(root.data);
			max_level = level;
		}

		// Recur for left and right subtrees
		leftViewUtil(root.left, level+1, max_level);
		leftViewUtil(root.right, level+1, max_level);
	}

	// A wrapper over leftViewUtil()
	static void leftView( node5 root)
	{
		int max_level = 0;
		leftViewUtil(root, 1, max_level);
	}

}
