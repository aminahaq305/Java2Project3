
public class Tester {

	public static void main(String[] args) {
		GenericStack<int[][]> myStack = new GenericStack<>();
		int[][] intArray = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				intArray[i][j] = 9;
			}
		}
		myStack.push(intArray);
		int[][] array = myStack.pop();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(array[i][j]);
			}
		}
		
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				intArray[i][j] = 7;
			}
		}
		myStack.push(intArray);
		array = myStack.pop();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(array[i][j]);
			}
		}
	}

}
