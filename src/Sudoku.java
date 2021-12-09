import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sudoku {

	public static void main(String[] args) throws Exception {
		GenericStack<Move> myMoveStack = new GenericStack<Move>();
		File puzzles = new File("puzzles.txt");
		File solvedPuzzles = new File("solvedPuzzle.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(solvedPuzzles));
		Scanner scan = new Scanner(puzzles);
		int puzzlenum = 0;
		int[][] intArray = new int[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				intArray[i][j] = 0;
			}
		}

		while (scan.hasNext()) {
			puzzlenum = readPuzzle(scan, intArray, puzzlenum);
			outputunSolvedPuzzletoFile(writer, intArray, puzzlenum);
			solvePuzzle(intArray, myMoveStack);
			System.out.println();
			outputSolvedPuzzle(intArray, puzzlenum);
			System.out.println();
			System.out.println();
			outputSolvedPuzzletoFile(writer, intArray, puzzlenum);
		}
		writer.close();
	}

	static void outputSolvedPuzzle(int[][] intArray, int puzzlenum) {
		System.out.println("Solved Puzzle: " + puzzlenum);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(intArray[i][j] + " ");
				if (j == 8) {
					System.out.println();
				}
				if (i == 2 && j == 8) {
					System.out.println("---------------------");
				}
				if (i == 5 && j == 8) {
					System.out.println("---------------------");
				}
				if (j == 2) {
					System.out.print("| ");
				}
				if (j == 5) {
					System.out.print("| ");
				}
			}
		}
	}

	static void outputunSolvedPuzzletoFile(BufferedWriter writer, int[][] intArray, int puzzlenum) throws IOException {
		writer.write("Unsolved Puzzle: " + puzzlenum);
		writer.newLine();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				writer.write(intArray[i][j] + " ");
				if (j == 8) {
					writer.newLine();
				}
				if (i == 2 && j == 8) {
					writer.write("---------------------");
					writer.newLine();
				}
				if (i == 5 && j == 8) {
					writer.write("---------------------");
					writer.newLine();
				}
				if (j == 2) {
					writer.write("| ");
				}
				if (j == 5) {
					writer.write("| ");
				}

			}
		}
		writer.newLine();
	}

	static void outputSolvedPuzzletoFile(BufferedWriter writer, int[][] intArray, int puzzlenum) throws IOException {
		writer.write("Solved Puzzle: " + puzzlenum);
		writer.newLine();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				writer.write(intArray[i][j] + " ");
				if (j == 8) {
					writer.newLine();
				}
				if (i == 2 && j == 8) {
					writer.write("---------------------");
					writer.newLine();
				}
				if (i == 5 && j == 8) {
					writer.write("---------------------");
					writer.newLine();
				}
				if (j == 2) {
					writer.write("| ");
				}
				if (j == 5) {
					writer.write("| ");
				}

			}
		}
		writer.newLine();
	}

	static int readPuzzle(Scanner scan, int[][] intArray, int puzzlenum) throws Exception {
		puzzlenum = readInteger(scan);
		System.out.println("Unsolved Puzzle: " + puzzlenum);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				intArray[i][j] = readInteger(scan);
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(intArray[i][j] + " ");
				if (j == 8) {
					System.out.println();
				}
				if (i == 2 && j == 8) {
					System.out.println("---------------------");
				}
				if (i == 5 && j == 8) {
					System.out.println("---------------------");
				}
				if (j == 2) {
					System.out.print("| ");
				}
				if (j == 5) {
					System.out.print("| ");
				}
			}
		}
		return puzzlenum;
	}

	static void solvePuzzle(int[][] intArray, GenericStack<Move> myMoveStack) {
		int num = 1;
		int i = 0;
		int j = 0;
		Move move;
		for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				while (intArray[i][j] == 0) {
					if (isPossible(intArray, i, j, num) == true && num < 10) {
						intArray[i][j] = num;
						move = new Move(num, i, j);
						myMoveStack.push(move);
					} else if (isPossible(intArray, i, j, num) == false && num < 10) {
						num++;
					} else {
						Move removedMove = myMoveStack.pop();
						i = removedMove.getMoverow();
						j = removedMove.getMovecolumn();
						intArray[i][j] = 0;
						num = removedMove.getMovenum() + 1;
					}
				}
				num = 1;
			}
		}
	}

	public static boolean isPossible(int[][] intArray, int row, int col, int num) {
		for (int d = 0; d < 9; d++) {
			if (intArray[row][d] == num) {
				return false;
			}
		}
		for (int r = 0; r < 9; r++) {
			if (intArray[r][col] == num) {
				return false;
			}
		}
		int sqrt = 3;
		int boxRowStart = row - (row % sqrt);
		int boxColStart = col - (col % sqrt);
		for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
			for (int d = boxColStart; d < boxColStart + sqrt; d++) {
				if (intArray[r][d] == num) {
					return false;
				}
			}
		}
		return true;
	}

	static int readInteger(Scanner in) throws Exception {
		int result = 0;
		boolean success = false;
		while (!success) {
			String number = in.next();
			try {
				result = Integer.parseInt(number);
				success = true;
			} catch (Exception e) {
			}
		}
		return result;
	}
}