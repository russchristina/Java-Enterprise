package com.example;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class dup {
	public static <T>Object[] findSingles(T[] nums) {
		Set<T> set = new HashSet<T>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				set.remove(nums[i]);
			} else {
				set.add(nums[i]);
			}
		}
		System.out.println(Arrays.toString(set.toArray()));
		return set.toArray();
	}
	/*
	 * 	public static void main (String[] args) {
		dup.findSingles(new Integer[] {1, 1, 2, 3, 4, 4});
		dup.findSingles(new String[] {"abc", "cbd", "def", "def", "fec", "fec"});
		dup.findSingles(new Double[] {1.23, 4.32, 1.23, 5.234, 234.5, 234.5});
	}
	 */

}
