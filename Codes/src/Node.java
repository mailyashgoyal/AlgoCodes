public class Node {

    // Fields
    private String data;
    private Node next;

    // constructor
    public Node(String data) {
        this(data,null);
    }

    // constructor two with Node2 parameter
    public Node(String data, Node node) {
        this.data = data;
        next = node;
    }

    /**
     * Methods below return information about fields within class
     * */

    // @return the data
    public String getData() {
        return data;
    }

    // @param String data to this.data
    public void setData(String data) {
        this.data = data;
    }

    // @return next
    public Node getNext() {
        return next;
    }
    // @param Node2 next set to this.next
    public void setNext(Node next) {
        this.next = next;
    }
}