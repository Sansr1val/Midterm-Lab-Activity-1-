import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static int size;


	public static void main(String[] args) throws NumberFormatException, IOException {
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
		

	}
}
