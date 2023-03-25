
public class DoublyLinkedList {

	private Node head;
	private Node tail;

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

	public void add(Node node) {
		if(head == null) {
			head = node;
			tail = node;

		}else {
			tail.setNext(node);
			node.setPrevious(tail);
			tail = node;

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

	public void bubbleSort() { 

		boolean noChanges = true;
		int temp;

		Node currentNode = head; 
		while(currentNode.getNext()!= null) {
			if(currentNode.getData() > currentNode.getNext().getData()) {
				temp = currentNode.getData();
				currentNode.setData(currentNode.getNext().getData());
				currentNode.getNext().setData(temp);
				noChanges = false;
			}
			currentNode = currentNode.getNext();
		} 
		if(noChanges==false)
			bubbleSort();
	}

	public int getLength() {
		int counter = 0;
		Node currentNode = head;
		while(currentNode!=null){
			counter++;
			currentNode = currentNode.getNext();
		}
		return counter; 
	}


}
