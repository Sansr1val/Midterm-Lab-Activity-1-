
public class DoublySkipList {

	private SkipNode head;
	private SkipNode tail;

	//setters and getters
	public void setHead(SkipNode head) {
		this.head = head;
	}

	public SkipNode getHead() {
		return this.head;
	}

	public void setTail(SkipNode tail) {
		this.tail = tail;
	}

	public SkipNode getTail() {
		return this.tail;
	}

	public void add (SkipNode skipNode) {
		if(head == null) {
			head = skipNode;
			tail = skipNode;
		}else {
			tail.setNext(skipNode);
			skipNode.setPrevious(tail);
			tail = skipNode;
		}
	}

	public String display() {
		SkipNode currentNode = head;
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
		SkipNode currentNode = tail;
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
