
public class DoublyLinkedList {

	/*
	 * Declaration of the head and tail nodes ` * that mark the start and the end of
	 * the list.
	 */
	private Node head;
	private Node tail;

	/*
	 * Getters and setters of the tail and the head of the list that serves as the
	 * accessory and modifiers of the encapsulated properties of this class.
	 */
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

	/*
	 * This method adds a new node at the end of the existing list or set a new node
	 * if a list is not yet initialized. It does its' work by taking in a new node
	 * as its parameter and inserting it at the tail of the list if there is an
	 * existing list or set the new node as the head if the head is null and a list
	 * is not existing.
	 */
	public void add(Node node) {
		if (head == null) {

			head = node;
			tail = node;

		} else {

			tail.setNext(node);
			node.setPrevious(tail);
			tail = node;

		}
	}

	/*
	 * This method displays the data present inside each of the nodes in the list.
	 * It uses a loop to access all the nodes from the head down to the tail and
	 * extract the data that it holds and uses a conditional statement to further
	 * organize its output.
	 */
	public String display() {
		Node currentNode = head;
		String str = "";
		while (currentNode != null) {

			// traverse the list and concatenate the data of each node to the string
			str += String.valueOf(currentNode.getData()) + ", ";
			currentNode = currentNode.getNext();
		}
		if (str != "") {

			// if the list is not empty, remove the last comma and space from the string
			str = str.substring(0, str.length() - 2);
		}
		return str;
	}

	/*
	 * This method displays the data present inside each of the nodes in the list.
	 * It uses a loop to access all the nodes from the tail upto the head and
	 * extract the data that it holds and uses a conditional statement to further
	 * organize its output.
	 */
	public String displayReverse() {
		Node currentNode = tail;
		String str = "";
		while (currentNode != null) {

			// traverse the list backwards and concatenate the data of each node to the
			// string
			str += String.valueOf(currentNode.getData()) + ", ";
			currentNode = currentNode.getPrevious();
		}
		if (str != "") {

			str = str.substring(0, str.length() - 2);
		}
		return str;
	}

	/*
	 * This method sorts the list in an ascending order using bubble sort algorithm
	 * that runs in O(n) time complexity.
	 */
	public void bubbleSort() {
		// flag to check if any swaps were made
		boolean noChanges = true;
		int temp;

		Node currentNode = head;
		while (currentNode.getNext() != null) {

			// traverse the list until the second last node
			if (currentNode.getData() > currentNode.getNext().getData()) {

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
		if (noChanges == false)
			bubbleSort();
	}

	/*
	 * This simple method is used to know the length of the list by traversing the
	 * whole list with a while loop and incrementing an integer variable every
	 * iteration it does.
	 */
	public int getLength() {
		int counter = 0;
		Node currentNode = head;

		// Traverse the linked list and count the number of nodes
		while (currentNode != null) {
			counter++;// adds 1 to counter if the node is not empty
			currentNode = currentNode.getNext();
		}
		return counter;
	}
}
