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
		


	}
}
