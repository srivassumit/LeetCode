package com.leetcode.accepted;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>412. Fizz Buzz (E)</h1>
 * <p>
 * Write a program that outputs the string representation of numbers from 1 to
 * n. <br>
 * But for multiples of three it should output “Fizz” instead of the number and
 * for the multiples of five output “Buzz”. For numbers which are multiples of
 * both three and five output “FizzBuzz”.
 * </p>
 * <p>
 * <b> Example: </b>
 * </p>
 * 
 * <pre>
 * n = 15,<br>
 * Return:<br>
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 * </pre>
 * 
 * @author Sumit
 *
 */
public class FizzBuzz {

	private static final String EMPTY = "";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FizzBuzz fb = new FizzBuzz();
		List<String> output = fb.fizzBuzz(150000);
		for (String s : output) {
			System.out.println(s);
		}
	}

	/**
	 * LeetCode accepted solution for FizzBuzz
	 * 
	 * @param n
	 *            the size
	 * @return list of strings
	 */
	public List<String> fizzBuzz(int n) {
		if (n < 1) {
			return new ArrayList<String>();
		}
		List<String> output = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			String s = EMPTY;
			if (i % 3 == 0) {
				s = s.concat("Fizz");
			}
			if (i % 5 == 0) {
				s = s.concat("Buzz");
			}
			if (EMPTY.equalsIgnoreCase(s)) {
				s = s.concat(String.valueOf(i));
			}
			output.add(s);
		}
		return output;
	}

}
