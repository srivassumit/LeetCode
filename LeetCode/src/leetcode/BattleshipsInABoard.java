package com.leetcode.accepted;

/**
 * <h1>Battleships in a Board</h1>
 * <p>
 * Given an 2D board, count how many different battleships are in it. The
 * battleships are represented with 'X's, empty slots are represented with '.'s.
 * You may assume the following rules:
 * </p>
 * <p>
 * You receive a valid board, made of only battleships or empty slots.<br>
 * Battleships can only be placed horizontally or vertically. In other words,
 * they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1
 * column), where N can be of any size. At least one horizontal or vertical cell
 * separates between two battleships - there are no adjacent battleships.
 * </p>
 * <p>
 * <b> Example: </b>
 * </p>
 * 
 * <pre>
 *	X..X
 *	...X
 *	...X
 * </pre>
 * <p>
 * In the above board there are 2 battleships.
 * </p>
 * <p>
 * <b> Invalid Example: </b>
 * </p>
 * 
 * <pre>
 *	...X
 *	XXXX
 *	...X
 * </pre>
 * <p>
 * This is an invalid board that you will not receive - as battleships will
 * always have a cell separating between them.
 * </p>
 * <p>
 * Follow up:<br>
 * Could you do it in one-pass, using only O(1) extra memory and without
 * modifying the value of the board?
 * </p>
 * 
 * @author Sumit
 *
 */
public class BattleshipsInABoard {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BattleshipsInABoard bib = new BattleshipsInABoard();
		char[][] board = { { '.', 'X' }, { 'X', '.' } };
		System.out.println(bib.countBattleships(board));
	}

	/**
	 * LeetCode Accepted Solution for Battleships in a Board
	 * 
	 * @param board
	 *            the board containing battleships
	 * @return the count of battleships
	 */
	public int countBattleships(char[][] board) {
		int count = 0;
		boolean flg = false;
		for (int i = 0; i < board.length; i++) {
			flg = false;
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'X' && !flg) {
					if (i == 0) {
						count++;
						flg = true;
					} else if (board[i - 1][j] != 'X') {
						count++;
						flg = true;
					}
				}
				if (board[i][j] == '.' && flg) {
					flg = false;
				}
			}
		}
		return count;
	}

}
