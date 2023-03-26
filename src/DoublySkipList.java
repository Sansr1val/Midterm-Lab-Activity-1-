
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
	* Method for searching a value from head. 
	* If the value is found, displays the number of traversed nodes and skip nodes.
	* Displays a prompt if not.
	*/
	public String searchFromHead(int value) {
		String str = "Skip List:";
		SkipNode current = head;
		Node bottom = null;
		//traverses the skip list as long as the data are <= value
		while (current != null) {
			if (current.getData() == value) {
				str += (" " + current.getData());
				return str;
			} else if (current.getNext() != null && current.getNext().getData() <= value) {
				str += (" " + current.getData());
				current = current.getNext();
			} else {
				str += (" " + current.getData());
				bottom = current.getBottom();//goes down if it reaches the end
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
		//when it reaches the end, it means that the value is not found, it will return a prompt
		//if the value is not found in the Lists.
		return "Number does not exist in the list.";
	}
	
	/*
	* Method for searching a value from tail. 
	* If the value is found, displays the number of traversed nodes and skip nodes.
	* Displays a prompt if not.
	*/
	public String searchFromTail(int value) {
		String str = "Skip List:";
		SkipNode current = tail;
		Node bottom = null;
		/*
		 * It checks first if value is >= or <= the tail's data.
		 * If the value is > tail data, the algorithm will go down and search the Linked list going to the right.
		 * If the value is < tail data, the algorithm will traverse the skip list and then the linked list.
		 */
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
			//Traverses the Skip list first from tail
			while (current != null) {
				if (current.getData() == value) {
					str += (" " + current.getData());
					return str;
				} else if (current.getPrevious() != null && current.getPrevious().getData() >= value) {
					str += (" " + current.getData());
					current = current.getPrevious();
				} else {
					str += (" " + current.getData());
					bottom = current.getBottom();// goes down if it reaches the end
					break;
				}
			}
			str += "\nLinked List:";
			//traverses the linked list going to the left.
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
		//when it reaches the end, it means that the value is not found, it will return a prompt
		//if the value is not found in the Lists.
		return "Number does not exist in the list.";
	}
}
