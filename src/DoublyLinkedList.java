
public class DoublyLinkedList {
	
	private Node head;
	private Node tail;
	private int size;

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	public void add(int data) {
		Node node = new Node(data);
		if(head == null) {
			head = node;
			tail = node;
			size++;
		}else {
			tail.setNext(node);
			node.setPrevious(tail);
			tail = node;
			size++;
		}
	}
	
	public String display() {
		Node currentNode = head;
		String str = "";
		while(currentNode != null) {
			str += String.valueOf(currentNode.getData()) +", ";
			currentNode = currentNode.getNext();
		}
		if(str !="") {
			str = str.substring(0,str.length() -2);
		}
		return str;
	}
	
	public String displayReverse() {
		Node currentNode = tail;
		String str = "";
		while(currentNode != null) {
			str += String.valueOf(currentNode.getData()) +", ";
			currentNode = currentNode.getPrevious();
		}
		if(str !="") {
			str = str.substring(0,str.length() -2);
		}
		return str;
	}
}
