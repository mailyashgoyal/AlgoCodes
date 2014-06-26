import java.util.ArrayList;

//  Definition for binary tree
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class ZigZagTraversal {

	public static void main(String args[])
	{
		
	}
	
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
       
        ArrayList<TreeNode> tempList = new ArrayList<TreeNode>();
        if( root != null )
        {
            tempList.add(root);
        }
       
        boolean forward = true;
        while( !tempList.isEmpty() )
        {
           
            ArrayList<TreeNode> tempQ = new ArrayList<TreeNode>();
           
            ArrayList<Integer> tempResult = new ArrayList<Integer>();
           
            while(!tempList.isEmpty())
            {
                TreeNode node = tempList.remove(tempList.size()-1);
               
                tempResult.add(node.val);
               
                if( forward )
                {
                    if( node.left != null )
                    {
                        tempQ.add(node.left);   
                    }
                    if( node.right != null )
                    {
                        tempQ.add(node.right);   
                    }
                }
                else
                {
                    if( node.right != null )
                    {
                        tempQ.add(node.right);   
                    }
                    if( node.left != null )
                    {
                        tempQ.add(node.left);   
                    }
                }
            }              
            result.add(tempResult);
           
            forward = !forward;
           
            tempList = tempQ;           
        }
       
        return result;
    }
}
