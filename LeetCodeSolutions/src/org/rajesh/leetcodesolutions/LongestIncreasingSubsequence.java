package org.rajesh.leetcodesolutions;

import java.util.Arrays;

// Problem : https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] input = new int[] { 100, 4, 200, 1, 3, 2 };
		Arrays.sort(input);
		int maxSequenceLength = 0, currentSequenceLength = 0;
		for (int i = 0; i < input.length; i++) {
			if (i > 0 && i < input.length - 1) {
				if ((input[i] - input[i - 1] == 1) && (input[i + 1] - input[i] == 1)) {
					currentSequenceLength++;
				} else if ((input[i] - input[i - 1] == 1) && (input[i + 1] - input[i] != 1)) {
					currentSequenceLength++;
					if (currentSequenceLength > maxSequenceLength) {
						maxSequenceLength = currentSequenceLength;
					}
					currentSequenceLength = 0;
				}
			} else if (i == 0) {
				if ((input[i + 1] - input[i] == 1)) {
					currentSequenceLength++;
				} else {
					if (currentSequenceLength > maxSequenceLength) {
						maxSequenceLength = currentSequenceLength;
					}
					currentSequenceLength = 0;
				}

			} else {
				if ((input[i] - input[i - 1] == 1)) {
					currentSequenceLength++;
				} else {
					if (currentSequenceLength > maxSequenceLength) {
						maxSequenceLength = currentSequenceLength;
					}
					currentSequenceLength = 0;
				}
			}
		}
		System.out.println(maxSequenceLength);
	}
}
