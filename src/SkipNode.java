
public class SkipNode {
	
	// storage for the node data
	private int data;
	
	// storage for the address of the previous node
	private SkipNode previous;
	// storage for the address of the next node
	private SkipNode next;
	// storage for the address of the bottom node
	private Node bottom;

	// constructor
	public SkipNode() {
		this.data = 0;
		this.next = null;
		this.previous = null;
		this.bottom = null;
	}
	
	// a no-argument constructor that creates a node with default values
	public SkipNode(int data) {
		this.data = data;
		this.next = null;
		this.previous = null;
		this.bottom = null;
	}

	// setters and getters.
	public int getData() {
		return this.data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public SkipNode getNext() {
		return this.next;
	}

	public void setNext(SkipNode next) {
		this.next = next;
	}

	public SkipNode getPrevious() {
		return this.previous;
	}

	public void setPrevious(SkipNode previous) {
		this.previous = previous;
	}

	public Node getBottom() {
		return this.bottom;
	}

	public void setBottom(Node bottom) {
		this.bottom = bottom;
	}

}
