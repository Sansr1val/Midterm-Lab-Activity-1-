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
		while(true) {
			try {
				System.out.print("Enter List size: ");
				size = Integer.parseInt(reader.readLine());
				if(size<=0) {
					throw new NumberFormatException();
				}else {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Only positive integer inputs are allowed! Try again.\n");
			}
		}

		/*
		 * Places values inside the list depending on the 
		 * size input of the user.
		 */
		int number;
		for(int i = 0; i<size ;i++) {
			while(true) {
				try {
					System.out.print("Enter number #"+i+": ");
					number = Integer.parseInt(reader.readLine());
					Node node = new Node(number);
					list.add(node);
					break;
				} catch (NumberFormatException e) {
					System.out.println("Only integer inputs are allowed! Try again.\n");
				}
			}
		}

		//Sorts the list before operations can be done in the menu
		System.out.println("\nSorting the List...");
		list.bubbleSort();
		list.display();


		try {
			while(true) {
				System.out.println("\n-----Menu-----");
				System.out.println("[1] Add Node");
				System.out.println("[2] Create Skip List");
				System.out.println("[3] Display List From Head");
				System.out.println("[4] Display List From Tail");
				System.out.println("[5] Display Skip List From Head");
				System.out.println("[6] Display Skip List From Tail");
				System.out.println("[7] Search From Head");
				System.out.println("[8] Search From Tail");
				System.out.println("[9] Exit");
				System.out.println("Select an operation: ");
				int choice = Integer.parseInt(reader.readLine());
				if(choice < 1 || choice > 9){
					System.out.println("Operation "+ choice+" does not exist! Try again.");
				}else {
					switch(choice) {
					case 1:
						do {
							// input for the new node's data
							System.out.print("\nEnter a number: ");
							number = Integer.parseInt(reader.readLine());

							// retrieves the last node's value
							Node currentNode = list.getHead();
							while(currentNode.getNext()!=null)
								currentNode = currentNode.getNext();
							lastValue = currentNode.getData();

							// the new node's data must not be lower than the last node's data
							if(lastValue >= number)
								System.out.print("\nNumber must be higher than the last value.");

							// repeat the input if new node's data is lower than last node's data
						} while(lastValue >= number);

						// adds the new node to the linked list
						Node node = new Node(number);
						list.add(node);

						// checks if the existing skip list needs an update
						if(skipList.getHead()!=null) {
							// retrieves the last node of the skip list
							SkipNode currentSkipNode = skipList.getHead();
							while(currentSkipNode.getNext()!=null)

								currentSkipNode = currentSkipNode.getNext();
							// checks if there's a need to create a new node for the skip list
							// based on the calculated number of nodes to be skipped
							Node currentNode = currentSkipNode.getBottom();
							for(int i=1; i<= nodesToSkip + 1; i++)
								if(currentNode!=null)
									currentNode = currentNode.getNext();
							// if number of nodes to be skipped was met then create a
							// new node for the skip list
							if(currentNode!=null) {

								SkipNode skipNode = new SkipNode();
								skipNode.setData(currentNode.getData());
								skipNode.setBottom(currentNode);
								skipList.add(skipNode);
							}

						}
						break;
					case 2:

						break;

					case 3://display list from head
						displayListFromHead();
						break;
					case 4://display list from tail
						displayListFromTail();
						break;
					case 5://display skip list from head
						displaySkipListFromHead();
						break;
					case 6://display skip list from tail
						displaySkipListFromTail();
						break;
					case 7://search from head
						break;
					case 8://search from tail
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
			}
		} catch (NumberFormatException e) {
			System.out.println("Only integers are allowed as inputs! Try again.");
		}
	}

	public static void displayListFromHead() {
		System.out.println("Displaying list from head...");
		System.out.println(list.display());
	}

	public static void displayListFromTail() {
		System.out.println("Displaying list from tail...");
		System.out.println(list.displayReverse());
	}

	public static void displaySkipListFromHead() {
		System.out.println("Displaying skip list from head...");
		System.out.println(skipList.display());
	}

	public static void displaySkipListFromTail() {
		System.out.println("Displaying skip list from tail...");
		System.out.println(skipList.displayReverse());
	}

	
}
