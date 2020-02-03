# Sudoku-Solver

This project is a Sudoku solver. It uses backtracking to solve the board.
It takes a 2D array where the zeros are empty boxes and start filling them one by one until it finds a solution.
If it reaches a point where no more boxes can be filled, it goes back to a past box and increments the number until it is valid.

I wrote two solutions, which are the hardcoded and the recursive ones.
The hardcoded versions store the coordinates of the zeros into an ArrayList using Pairs.
The recursive versions use recursion to find a solution.
