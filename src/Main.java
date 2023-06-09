import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static DoublyLinkedList list = new DoublyLinkedList();
	static DoublySkipList skipList = new DoublySkipList();
	static int size;
	static int lastValue;
	static int nodesToSkip;

	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		/*
		 * List size initialization
		 */
		while (true) {
			try {
				System.out.print("Enter List size: ");
				size = Integer.parseInt(reader.readLine());
				if (size <= 0) {
					throw new NumberFormatException();
				} else {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Only positive integer inputs are allowed! Try again.\n");
			}
		}

		/*
		 * Places values inside the list depending on the size input of the user.
		 */
		int number;
		for (int i = 0; i < size; i++) {
			while (true) {
				try {
					System.out.print("Enter number #" + (i+1) + ": ");
					number = Integer.parseInt(reader.readLine());
					Node node = new Node(number);
					list.add(node);
					break;
				} catch (NumberFormatException e) {
					System.out.println("Only integer inputs are allowed! Try again.\n");
				}
			}
		}

		// Sorts the list before operations can be done in the menu
		System.out.println("\nSorting the List...");
		list.bubbleSort();
		System.out.println("Linked List: "+ list.display());
		
		/*
		 * The main menu of the program.
		 * If an error occurs while using the operations, the user will be brought back to the main
		 * Menu.
		 * Has input checks.
		 * Disables the usage of operations that uses the Skip List when the skip list is not yet made.
		 */
		while (true) {
			try {
				System.out.println("\n-----Menu-----");
				System.out.println("[1] Create Skip List");
				System.out.println("[2] Add Node");
				System.out.println("[3] Display List From Head");
				System.out.println("[4] Display Skip List From Head");
				System.out.println("[5] Display List From Tail");
				System.out.println("[6] Display Skip List From Tail");
				System.out.println("[7] Search From Head");
				System.out.println("[8] Search From Tail");
				System.out.println("[9] Exit");
				System.out.print("Select an operation: ");
				int choice = Integer.parseInt(reader.readLine());
				if (choice < 1 || choice > 9) {
					System.out.println("Operation " + choice + " does not exist! Try again.");
				} else {
					switch (choice) {
					case 1:
						createSkipList();
						break;
					case 2:
						addNode();
						break;
					case 3:
						displayListFromHead();
						break;
					case 4: 
						displaySkipListFromHead();
						break;
					case 5:
						displayListFromTail();
						break;
					case 6:
						displaySkipListFromTail();
						break;
					case 7:
						searchFromHead();
						break;
					case 8:
						searchFromTail();
						break;
					case 9:
						System.out.print("\n--Exit--" + "\nProgram will be terminated");
						for (int i = 0; i < 3; i++) {
							Thread.sleep(1000);
							System.out.print(".");
						}
						System.out.print("\nProgram terminated.");
						System.exit(0);
						
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("Only integers are allowed as inputs! Try again.");
			}			
		}
	}
	/*
	 * Adds a node in the Linked list.
	 * Input must be greater than the last input.
	 * Every input, checks if there is a need to add a new Skip Node.
	 */
	public static void addNode() throws NumberFormatException, IOException {
		int number = 0;
		do {
			try {
				// input for the new node's data
				System.out.print("\nEnter a number: ");
				number = Integer.parseInt(reader.readLine());

				// retrieves the last node's value
				Node currentNode = list.getHead();
				while (currentNode.getNext() != null)
					currentNode = currentNode.getNext();
				lastValue = currentNode.getData();

				// the new node's data must not be lower than the last node's data
				if (lastValue >= number)
					System.out.print("\nNumber must be higher than the last value.");
			} catch (NumberFormatException e) {
				System.out.println("Integers only! Please try again.");
			}

			// repeat the input if new node's data is lower than last node's data
		} while (lastValue >= number);

		// adds the new node to the linked list
		Node node = new Node(number);
		list.add(node);

		// checks if the existing skip list needs an update
		if (skipList.getHead() != null) {
			// retrieves the last node of the skip list
			SkipNode currentSkipNode = skipList.getHead();
			while (currentSkipNode.getNext() != null)

				currentSkipNode = currentSkipNode.getNext();
			/*
			 * Checks if there's a need to create a new skip node
			 * based on the calculated number of nodes to be skipped
			 */
			Node currentNode = currentSkipNode.getBottom();
			for (int i = 1; i <= nodesToSkip + 1; i++)
				if (currentNode != null)
					currentNode = currentNode.getNext();
			/*
			 * If number of nodes to be skipped was met then create a
			 * new node for the skip list
			 */
			if (currentNode != null) {

				SkipNode skipNode = new SkipNode();
				skipNode.setData(currentNode.getData());
				skipNode.setBottom(currentNode);
				skipList.add(skipNode);
			}

		}
	}
	
	/*
	 * Creates a skip list, operation can only be done once.
	 */
	public static void createSkipList() {
		if (skipList.getHead() != null)
			System.out.print("\nAlready created a skip list.");
		else {
			// computes the number of nodes to be skipped
			nodesToSkip = (int) Math.sqrt(list.getLength());

			// creates the first node of the skip list
			SkipNode skipNode = new SkipNode();
			skipNode.setData(list.getHead().getData());
			skipNode.setBottom(list.getHead());
			skipList.add(skipNode);
			// creates the remaining nodes of the skip list
			Node currentNode = list.getHead();
			while (currentNode != null) {
				for (int i = 1; i <= nodesToSkip + 1; i++) {
					if (currentNode != null)
						currentNode = currentNode.getNext();
					else
						break;
				}
				if (currentNode != null) {
					skipNode = new SkipNode();

					skipNode.setData(currentNode.getData());
					skipNode.setBottom(currentNode);
					skipList.add(skipNode);
				}
			}
			System.out.print("\nSkip list created!");
		}
	}
	
	// Display the linked list from head to tail
	public static void displayListFromHead() {
		System.out.println("Displaying list from head...");
		System.out.println(list.display());
	}
	// Display the linked list from tail to head
	public static void displayListFromTail() {
		System.out.println("Displaying list from tail...");
		System.out.println(list.displayReverse());
	}

	// Display the skip list from head to tail.
	// Cannot be performed if the Skip list is empty.
	public static void displaySkipListFromHead() {
		if(skipList.getHead() != null) {
			System.out.println("Displaying skip list from head...");
			System.out.println(skipList.display());
		}else {
			System.out.println("Operation unavailable as Skip List is empty!");
		}
	}

	// Display the skip list from tail to head.
	// Cannot be performed if the Skip List is empty.
	public static void displaySkipListFromTail() {
		if(skipList.getHead() != null) {
			System.out.println("Displaying skip list from tail...");
			System.out.println(skipList.displayReverse());
		}else {
			System.out.println("Operation unavailable as Skip List is empty!");
		}
	}
	
	/*
	 * Searches the value from Skip List head, displays each value that is passed.
	 * Cannot be performed if Skip List is empty.
	 */
	public static void searchFromHead() throws NumberFormatException, IOException {
		if(skipList.getHead() != null) {
			try {
				// Prompt user to enter a number to search for
				int number = 0;
				System.out.print("\nEnter a number: ");
				number = Integer.parseInt(reader.readLine());
				
				// Search for the number in the skip list from head to tail
				System.out.println(skipList.searchFromHead(number));
			} catch (NumberFormatException e) {
				System.out.println("Integer only! Please try again.");
			}
		}else {
			System.out.println("Operation unavailable as Skip List is empty!");
		}
	}
	
	/*
	 * Searches the value from Skip List tail, displays each value that is passed.
	 * Cannot be performed if Skip List is empty.
	 */
	public static void searchFromTail() throws NumberFormatException, IOException {
		if(skipList.getHead() != null) {
			try {
				 // Prompt user to enter a number to search for
				int number = 0;
				System.out.print("\nEnter a number: ");
				number = Integer.parseInt(reader.readLine());
				
				// Search for the number in the skip list from tail to head
				System.out.println(skipList.searchFromTail(number));
			} catch (NumberFormatException e) {
				System.out.println("Integer only! Please try again.");
			}
		}else {
			System.out.println("Operation unavailable as Skip List is empty!");
		}
	}

}
