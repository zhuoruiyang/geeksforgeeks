import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/
 * Still unsure if this program is entirely correct since the running time is too long.
 * Different from https://en.wikipedia.org/wiki/Knight%27s_tour
 */
public class KnightTour {
	static int counter = 0;
	public static void main(String[] args) {
		List<int[][]> res = new ArrayList<>();
		int[][] board = new int[5][5];
		for(int[] row : board)
			Arrays.fill(row, -1);
		board[0][0] = 0;
		int n = board.length*board[0].length;
		solveKT(res, board, n, 0, 0, 1);
		printResult(res);
	}
	
	private static void solveKT(List<int[][]> res, int[][] board, int n, int row, int col, int count) {
		if(count == n) {
			// deep copy of 2d array
			int[][] copy = new int[board.length][board[0].length];
			for (int i = 0; i < copy.length; i++)
				copy[i] = Arrays.copyOf(board[i], board[i].length);
			res.add(copy);
			System.out.println(++counter);
			return;
		}
		
		int[][] spots = {{row-2, col-1}, {row-2, col+1}, {row-1, col-2}, {row-1, col+2},
				{row+1, col-2}, {row+1, col+2}, {row+2, col-1}, {row+2, col+1}};
		// loop through the available spots to travel
		for(int[] spot : spots) {
			if(spot[0] >= 0 && spot[0] < board.length && 
					spot[1] >= 0 && spot[1] < board[0].length && board[spot[0]][spot[1]] == -1) {
				board[spot[0]][spot[1]] = count;
				solveKT(res, board, n, spot[0], spot[1], count+1);
				board[spot[0]][spot[1]] = -1;
			}
		}
	}
	
	private static void printResult(List<int[][]> res) {
		for(int[][] array : res) {
			System.out.println("--------");
			for(int[] row : array) {
				for(int e : row)
					System.out.print(e + ", ");
				System.out.print("\n");
			}
		}
	}
	
	private static void printLocal(int[][] res) {
		System.out.print("------------------");
		System.out.print("\n");
		for(int[] row : res) {
			for(int e : row)
				System.out.print(e + ", ");
			System.out.print("\n");
		}
	}
}
