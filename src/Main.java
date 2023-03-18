import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static DoublyLinkedList list = new DoublyLinkedList();
	static DoublySkipList skipList = new DoublySkipList();
	static int size;


	public static void main(String[] args) throws NumberFormatException, IOException {
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
					list.add(number);
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
				int choice = reader.readLine().charAt(0);
				if(choice < 1 || choice > 9){
					System.out.println("Operation "+ choice+" does not exist! Try again.");
				}else {
					switch(choice) {
					case 1://add
						break;
					case 2://create skip list
						break;
					case 3://display list from head
						break;
					case 4://display list from tail
						break;
					case 5://display skip list from head
						break;
					case 6://display skip list from tail
						break;
					case 7://search from head
						break;
					case 8://search from tail
						break;
					case 9://exit
						break;
					}
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Only integers are allowed as inputs! Try again.");
		}
	}
}
