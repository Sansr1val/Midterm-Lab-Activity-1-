
public class DoublySkipList {

	private SkipNode head;
	private SkipNode tail;

	// setters and getters
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

	public String searchFromHead(int num) {
		SkipNode tempSkipNode = this.head;
		Node tempNode = new Node();
		String res = "Skip List:";

		while (tempSkipNode != null && tempSkipNode != tail && tempSkipNode.getNext().getData() <= num) {
			res += (" " + tempSkipNode.getData());
			tempSkipNode = tempSkipNode.getNext();
		}

		res += (" " + tempSkipNode.getData());

		if (num == tempSkipNode.getData()) {
			return res;
		} else {
			tempNode = tempSkipNode.getBottom();
			res += "\nLinked List:";
			while (tempNode != null && num != tempNode.getData()) {
				res += " " + tempNode.getData();
				tempNode = tempNode.getNext();
			}

		}

		res = tempNode != null && tempNode.getData() == num ? res += " " + tempNode.getData()
				: "Number does not exist in the list.";
		return res;

	}

	public String searchFromTail(int num) {
		SkipNode tempSkipNode = this.tail;
		Node tempNode = new Node();
		String res = "Skip List:";

		if (tempSkipNode.getData() == num)
			return res + " " + tempSkipNode;

		if (num > tempSkipNode.getData()) {
			tempNode = tempSkipNode.getBottom();
			res += "\nLinked List:";
			while (tempNode != null && num != tempNode.getData()) {
				res += " " + tempNode.getData();
				tempNode = tempNode.getNext();
			}
		} else {

			while (tempSkipNode != null && tempSkipNode != head && tempSkipNode.getPrevious().getData() >= num) {
				res += (" " + tempSkipNode.getData());
				tempSkipNode = tempSkipNode.getPrevious();
			}

			res += (" " + tempSkipNode.getData());

			if (num == tempSkipNode.getData()) {
				return res;
			} else {
				tempNode = tempSkipNode.getBottom();
				res += "\nLinked List:";
				while (tempNode != null && num != tempNode.getData()) {
					res += " " + tempNode.getData();
					tempNode = tempNode.getPrevious();
				}

			}

		}

		res = tempNode != null && tempNode.getData() == num ? res += " " + tempNode.getData()
				: "Number does not exist in the list.";
		return res;
	}
}
