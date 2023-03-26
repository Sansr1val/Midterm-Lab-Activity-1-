
public class Node {
	
	// storage for the node data
	private int data;
	
	// storage for the address of the next node
	private Node next;
	// storage for the address of the previous node
	private Node previous;

	//Constructors
	public Node() {
		this.data = 0;
		this.next = null;
		this.previous = null;
	}
	
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
