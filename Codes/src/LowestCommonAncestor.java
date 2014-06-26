
class node3 {
    int data;
     node3 left;
     node3 right;
}
public class LowestCommonAncestor {

	
	public LowestCommonAncestor() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static node3 LCA(node3 root,node3 a,node3 b){
		   node3 left=null,right=null;
		   
		   if(root==null) return root;
		   
		   if(root==a || root==b) return root;
		   
		   left=LCA(root.left,a,b);
		   right=LCA(root.right,a,b);
		   
		   if(left!=null && right!=null)return root;
		   return (left!=null)?left:right; 
		}
}
