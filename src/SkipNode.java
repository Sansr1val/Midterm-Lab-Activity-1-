
public class SkipNode {
	
	private int data;
	private SkipNode previous;
	private SkipNode next;
	private SkipNode bottom;
	
	//constructor
	public SkipNode() {
		this.data = 0;
		this.next = null;
		this.previous = null;
		this.bottom = null;
	}
	public SkipNode(int data) {
		this.data = data;
		this.next = null;
		this.previous = null;
		this.bottom = null;
	}
	
	//setters and getters.
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
	
	public SkipNode getBottom() {
		return this.bottom;
	}
	
	public void setBottom(SkipNode bottom) {
		this.bottom = bottom;
	}
	
}
