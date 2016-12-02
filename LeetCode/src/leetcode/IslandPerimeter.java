package com.leetcode.accepted;

/**
 * <h1>Island Perimeter</h1>
 * <p>
 * You are given a map in form of a two-dimensional integer grid where 1
 * represents land and 0 represents water. Grid cells are connected
 * horizontally/vertically (not diagonally). The grid is completely surrounded
 * by water, and there is exactly one island (i.e., one or more connected land
 * cells). The island doesn't have "lakes" (water inside that isn't connected to
 * the water around the island). One cell is a square with side length 1. The
 * grid is rectangular, width and height don't exceed 100. Determine the
 * perimeter of the island.
 * </p>
 * <p>
 * <b> Example:</b>
 * </p>
 * 
 * <pre>
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 * </pre>
 * <p>
 * Answer: 16<br>
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 * </p>
 * 
 * @author Sumit
 *
 */
public class IslandPerimeter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		IslandPerimeter ip = new IslandPerimeter();
		System.out.println(ip.islandPerimeter(grid));
	}

	/**
	 * LeetCode accepted solution for Island Perimeter.
	 * 
	 * @param grid
	 *            the grid containing the island
	 * @return the perimeter of the island
	 */
	public int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					int edges = 4;
					if (i != 0 && grid[i - 1][j] == 1) {
						edges--;
					}
					if (i != grid.length - 1 && grid[i + 1][j] == 1) {
						edges--;
					}
					if (j != 0 && grid[i][j - 1] == 1) {
						edges--;
					}
					if (j != grid[i].length - 1 && grid[i][j + 1] == 1) {
						edges--;
					}
					perimeter += edges;
				}
			}
		}
		return perimeter;
	}

}
