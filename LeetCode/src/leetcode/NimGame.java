package com.leetcode.accepted;

/**
 * <h1>Nim Game</h1>
 * <p>
 * You are playing the following Nim Game with your friend: There is a heap of
 * stones on the table, each time one of you take turns to remove 1 to 3 stones.
 * The one who removes the last stone will be the winner. You will take the
 * first turn to remove the stones.
 * </p>
 * <p>
 * Both of you are very clever and have optimal strategies for the game. Write a
 * function to determine whether you can win the game given the number of stones
 * in the heap.
 * </p>
 * <p>
 * For example, if there are 4 stones in the heap, then you will never win the
 * game: no matter 1, 2, or 3 stones you remove, the last stone will always be
 * removed by your friend.
 * </p>
 * <p>
 * <b> Hint:</b>
 * </p>
 * <p>
 * If there are 5 stones in the heap, could you figure out a way to remove the
 * stones such that you will always be the winner?
 * </p>
 * 
 * @author Sumit
 */
public class NimGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NimGame ng = new NimGame();
		for (int i = 0; i < 25; i++) {
			System.out.println(i + " : " + ng.canWinNim(i));
		}
	}

	/**
	 * LeetCode accepted code for Nim Game
	 * 
	 * @param n
	 * @return
	 */
	public boolean canWinNim(int n) {
		if (n < 0) {
			return false;
		}
		if (n <= 3) {
			return true;
		}
		if (n == 4) {
			return false;
		} else {
			return !(n % 4 == 0);
		}
	}

}
