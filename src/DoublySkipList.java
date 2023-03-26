
public class DoublySkipList {

	// The head and tail nodes
	private SkipNode head;
	private SkipNode tail;

	// Setters and getters
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

	// Method for adding a new node at the end of the skip list
	public void add(SkipNode skipNode) {
		if (head == null) {
			head = skipNode;
			tail = skipNode;
		} else {
			tail.setNext(skipNode);
			skipNode.setPrevious(tail);
			tail = skipNode;
		}
	}

	// Method for displaying the skip list from head to tail
	public String display() {
		SkipNode currentNode = head;
		String str = "";
		while (currentNode != null) {
			str += String.valueOf(currentNode.getData()) + ", ";
			currentNode = currentNode.getNext();
		}
		if (str != "") {
			str = str.substring(0, str.length() - 2);
		}
		return str;
	}

	// Method for displaying the skip list from tail to head
	public String displayReverse() {
		SkipNode currentNode = tail;
		String str = "";
		while (currentNode != null) {
			str += String.valueOf(currentNode.getData()) + ", ";
			currentNode = currentNode.getPrevious();
		}
		if (str != "") {
			str = str.substring(0, str.length() - 2);
		}
		return str;
	}

	/*
	* Method for serching a value from head. 
	* If the value is found, displays the number of traversed nodes and skip nodes.
	* Displays a prompt if not.
	*/
	public String searchFromHead123(int value) {
		String str = "Skip List:";
		SkipNode current = head;
		Node bottom = null;
		while (current != null) {
			if (current.getData() == value) {
				str += (" " + current.getData());
				return str;
			} else if (current.getNext() != null && current.getNext().getData() <= value) {
				str += (" " + current.getData());
				current = current.getNext();
			} else {
				str += (" " + current.getData());
				bottom = current.getBottom();
				break;
			}
		}
		str += "\nLinked List:";
		while (bottom != null) {
			if (bottom.getData() == value) {
				str += (" " + bottom.getData());
				return str;
			} else if (bottom.getNext() != null && bottom.getNext().getData() <= value) {
				str += (" " + bottom.getData());
				bottom = bottom.getNext();
			} else {
				break;
			}
		}

		return "Number does not exist in the list.";
	}
	
	/*
	* Method for serching a value from tail. 
	* If the value is found, displays the number of traversed nodes and skip nodes.
	* Displays a prompt if not.
	*/
	public String searchFromTail123(int value) {
		String str = "Skip List:";
		SkipNode current = tail;
		Node bottom = null;
		if(value>= current.getData()) {
			if(value == current.getData())
				return str += (" " + current.getData());
			str += (" " + current.getData());
			bottom = current.getBottom();
			str += "\nLinked List:";
			while (bottom != null) {
				if (bottom.getData() == value) {
					str += (" " + bottom.getData());
					return str;
				} else if (bottom.getNext() != null && bottom.getNext().getData() <= value) {
					str += (" " + bottom.getData());
					bottom = bottom.getNext();
				} else {
					break;
				}
			}
		}else {
			while (current != null) {
				if (current.getData() == value) {
					str += (" " + current.getData());
					return str;
				} else if (current.getPrevious() != null && current.getPrevious().getData() >= value) {
					str += (" " + current.getData());
					current = current.getPrevious();
				} else {
					str += (" " + current.getData());
					bottom = current.getBottom();
					break;
				}
			}
			str += "\nLinked List:";
			while (bottom != null) {
				if (bottom.getData() == value) {
					str += (" " + bottom.getData());
					return str;
				} else if (bottom.getPrevious() != null && bottom.getPrevious().getData() >= value) {
					str += (" " + bottom.getData());
					bottom = bottom.getPrevious();
				} else {
					break;
				}
			}
		}
		

		return "Number does not exist in the list.";
	}
}
