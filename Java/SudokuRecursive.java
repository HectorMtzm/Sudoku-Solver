/*
 * https://www.geeksforgeeks.org/backtracking-introduction/
 */

import javafx.util.Pair;

public class SudokuRecursive {

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
		if(solve(board, bLength))
			printBoard3x3(board, bLength);
		else {
			System.out.println("azucar");
		}
	}

	public static boolean solve(int[][] board, int bLength) {
		int i = 0, j = 0;
		Pair<Integer, Integer> coord = findEmptySpace(board, bLength);	
		if(coord != null) {
			i = coord.getKey();
			j = coord.getValue();
		} 
		else 
			return true;
		
		for(int val = 1; val <= bLength; val++) {
			if(valid(board, i, j, val, bLength)) {
				board[i][j] = val;
				if (solve(board, bLength))  
					return true;  
				else
					board[i][j] = 0; 
			}
		}
			

		return false;

	}
	
	//find an empty space (0)
	public static Pair<Integer, Integer> findEmptySpace(int[][] board, int bLength) {
		
		for(int i = 0; i < bLength; i++) {
			for(int j = 0; j < bLength; j++) {
				if(board[i][j] == 0 ) {
					return new Pair<Integer, Integer> (i,j);
				}
			}
		}
		return null;
		
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
					System.out.print("| ");
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
		