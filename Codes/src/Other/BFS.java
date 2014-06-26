package Other;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Node1 {

	public String data; // data element
	public boolean visited=false; // flag to track the already visited node
	
	List<Node1> adjacentNodes  = new LinkedList<Node1>();// adjacency list
	
	public Node1(String data){
		this.data = data;
	}

	public void addAdjacentNode(final Node1 node1){
		adjacentNodes.add(node1);
		node1.adjacentNodes.add(this);
	}

}

public class BFS {

	public static void main(String[] args) {
		Node1 frankfurt = new Node1("frankfurt");
		Node1 mannheim = new Node1("mannheim");
		Node1 wurzburg = new Node1("wurzburg");
		Node1 stuttgard = new Node1("stuttgard");
		Node1 kassel = new Node1("kassel");
		Node1 karlsruhe = new Node1("karlsruhe");
		Node1 erfurt = new Node1("erfurt");
		Node1 numberg = new Node1("numberg");
		Node1 augsburg = new Node1("augsburg");
		Node1 munchen = new Node1("munchen");

		BFS g = new BFS();

		g.nodes.add(frankfurt);
		g.nodes.add(mannheim);
		g.nodes.add(wurzburg);
		g.nodes.add(stuttgard);
		g.nodes.add(kassel);
		g.nodes.add(karlsruhe);
		g.nodes.add(erfurt);
		g.nodes.add(numberg);
		g.nodes.add(augsburg);
		g.nodes.add(munchen);
 
		frankfurt.addAdjacentNode(mannheim);
		frankfurt.addAdjacentNode(wurzburg);
		frankfurt.addAdjacentNode(kassel);

		mannheim.addAdjacentNode(karlsruhe);

		karlsruhe.addAdjacentNode(augsburg);

		augsburg.addAdjacentNode(munchen);

		munchen.addAdjacentNode(kassel);
		munchen.addAdjacentNode(numberg);

		wurzburg.addAdjacentNode(erfurt);
		wurzburg.addAdjacentNode(numberg);

		numberg.addAdjacentNode(stuttgard);

		g.breadthFirstTraversal(frankfurt);
	}
	private List<Node1> nodes = new ArrayList<Node1>();

	public void breadthFirstTraversal(Node1 rootNode){

		Queue<Node1> q  =  new LinkedList<Node1>();
		q.add(rootNode);
		rootNode.visited=true;
		while(!q.isEmpty()){
			Node1 n = q.poll();
			System.out.print(n.data + " ");
			List<Node1> adjNod = n.adjacentNodes;
			for(Node1 adj : adjNod){
				if(!adj.visited){
					adj.visited=true;
					q.add(adj);
				}
			}
		}
	}
/*
	 1) Create a int result and assign a non-zero value.

	 2) For every field tested in the equals-Method, calculate a hash code c by:

	 If the field f is a boolean: calculate (f ? 0 : 1);
	 If the field f is a byte, char, short or int: calculate (int)f;
	 If the field f is a long: calculate (int)(f ^ (f >>> 32));
	 If the field f is a float: calculate Float.floatToIntBits(f);
	 If the field f is a double: calculate Double.doubleToLongBits(f) and handle the return value like every long value;
	 If the field f is an object: Use the result of the hashCode() method or 0 if f == null;
	 If the field f is an array: See every field as separate element and calculate the hash value in a recursive fashion and combine the values as described next.
	 3) Combine the hash value c with result with:

	 result = 37 * result + c*/
	 
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BFS other = (BFS) obj;
		if (nodes == null) {
			if (other.nodes != null)
				return false;
		} else if (!nodes.equals(other.nodes))
			return false;
		return true;
	}
}
