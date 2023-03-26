
public class Node {
	
	// storage for the node data
	private int data;
	
	// storage for the address of the next node
	private Node next;
	
	// a no-argument constructor that creates a node with default values
	private Node previous;


	public Node() {
		this.data = 0;
		this.next = null;
		this.previous = null;
	}
	
	// a constructor that creates a node with initial data specified by the parameter
	public Node(int data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}
	
	//getter and setters
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}
}
