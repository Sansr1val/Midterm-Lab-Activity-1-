
public class DoublyLinkedList {

	// The head and tail nodes
	private Node head;
	private Node tail;

	// Getters and setters for the head and tail nodes
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

	// Adds a new node to the end of the linked list
	public void add(Node node) {
		if(head == null) { 
			
			 // if the list is empty, set head and tail to the new node
			head = node;
			tail = node;

		}else { 
			// otherwise, set the tail's next node to the new node and update tail to the new node
			tail.setNext(node);
			node.setPrevious(tail);
			tail = node;

		}
	}

	// Returns a string representation of the linked list from head to tail
	public String display() {
		Node currentNode = head;
		String str = "";
		while(currentNode != null) { 
			
			// traverse the list and concatenate the data of each node to the string
			str += String.valueOf(currentNode.getData()) +", ";
			currentNode = currentNode.getNext();
		}
		if(str !="") { 
			
			// if the list is not empty, remove the last comma and space from the string
			str = str.substring(0,str.length() -2);
		}
		return str;
	}

	// Returns a string representation of the linked list from tail to head
	public String displayReverse() {
		Node currentNode = tail;
		String str = "";
		while(currentNode != null) { 
			
			// traverse the list backwards and concatenate the data of each node to the string
			str += String.valueOf(currentNode.getData()) +", ";
			currentNode = currentNode.getPrevious();
		}
		if(str !="") { 
			
			str = str.substring(0,str.length() -2);
		}
		return str;
	}

	// Sorts the linked list in ascending order using the bubble sort algorithm
	public void bubbleSort() { 
		
		// flag to check if any swaps were made
		boolean noChanges = true; 
		int temp;

		Node currentNode = head; 
		while(currentNode.getNext()!= null) { 
			
			// traverse the list until the second last node
			if(currentNode.getData() > currentNode.getNext().getData()) { 
				
				// if the current node's data is greater than the next node's data, swap them
				temp = currentNode.getData();
				currentNode.setData(currentNode.getNext().getData());
				currentNode.getNext().setData(temp);
				noChanges = false; 
				// set flag to false as a swap was made
			}
			currentNode = currentNode.getNext(); 
		} 
		// move to the next node
		if(noChanges==false)
			bubbleSort();
	}
	
	public int getLength() {
		int counter = 0;
		Node currentNode = head;
		
		// Traverse the linked list and count the number of nodes
		while(currentNode!=null){
			counter++;
			currentNode = currentNode.getNext();
		}
		return counter; 
	}


}
