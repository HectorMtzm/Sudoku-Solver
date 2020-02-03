import java.util.ArrayList;

import javafx.util.Pair;

public class SudokuHardcode {

	public static void main(String[] args) {
		int[][] board = 
		{
			{0,0,0,2,6,0,7,0,1},
			{6,8,0,0,7,0,0,9,0},
			{1,9,0,0,0,4,5,0,0},
			{8,2,0,1,0,0,0,4,0},
			{0,0,4,6,0,2,9,0,0},
			{0,5,0,0,0,3,0,2,8},
			{0,0,9,3,0,0,0,7,4},
			{0,4,0,0,5,0,0,3,6},
			{7,0,3,0,1,8,0,0,0}
		};
		
		int bLength = board.length;
		int[][] solvedBoard = solve(board, bLength);
		
		printBoard3x3(solvedBoard, bLength);
	}

	public static int[][] solve(int[][] board, int bLength) {
		ArrayList<Pair<Integer, Integer>> pastZeroLocation = new ArrayList<Pair<Integer,Integer>>(81);
		boolean backtracking = false;
		
		for(int i = 0; i < bLength; i++) {
			for(int j = 0; j < bLength; j++) {
				printBoard3x3(board, bLength);
				if(board[i][j] == 0 || backtracking) {
					int val = board[i][j];
					backtracking = false;
					for(++val; val < 10; val++) {
						if(valid(board, i, j, val, bLength)) {
							pastZeroLocation.add(new Pair<Integer, Integer>(i, j));
							board[i][j] = val;
							break;
						}
					}
					
					//backtrack 
					if(board[i][j] == 0 || val == 10) {
						backtracking = true;
						board[i][j] = 0;
						printBoard3x3(board, bLength);

						try {
							Pair<Integer, Integer> returnTo = pastZeroLocation.remove(pastZeroLocation.size()-1);
							i = returnTo.getKey();
							j = returnTo.getValue()-1;	//-1 because the for loop will add 1
						} catch (Exception e) {
							System.out.println("There is no possible solution for this Sudoku board.");
							System.exit(44);
						}
					}
				}
			}
		}
		return board;
	}
	
public static boolean valid(int[][] board, int cordH, int cordV, int value, int bLength) {
		
		//check Horizontal
		for(int i = 0; i < bLength; i++) {	
			if(board[i][cordV] == value) {
				return false;
			}	
		}
		
		//check Vertical
		for(int j = 0; j < bLength; j++) {
			if(board[cordH][j] == value) {
				return false;
			}
		}

		//check box
		int boxStartH = (cordH - cordH % 3);	//Points to the beginning of the box. i
		int boxStartV = (cordV - cordV % 3);	//Points to the beginning of the box. j
		
		for(int i = boxStartH; i < boxStartH + 3; i++) {
			for(int j = boxStartV; j < boxStartV + 3; j++) {
				if(board[i][j] == value)
					return false;
			}
		}
	    
	    return true; 
	}
	
	public static void printBoard3x3(int[][] board, int bLength) 
	{ 
		try {
			Thread.sleep(120);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		for(int i = 0; i < bLength; i++) {
			if(i == 3 || i == 6) 
				System.out.println("-----------------------");
			for(int j = 0; j < bLength; j++) {
				if(j == 3 || j == 6)
					System.out.print(" | ");
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
			if(i == bLength-1)
				System.out.println();

		}
	}
	
	public static void printBoard(int[][] board, int bLength) 
	{ 
		
		try {
			Thread.sleep(120);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		for(int i = 0; i < bLength; i++) {
			for(int j = 0; j < bLength; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
			if(i == bLength-1)
				System.out.println();

		}
	}

}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
