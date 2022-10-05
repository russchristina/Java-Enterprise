package com.revature;

public class ArraysInJava {

	public static void main(String[] args) {
		
		/*
		 * Like many languages, Java supports basic arrays. These are arguably the simplest container
		 * available to us. An array allows to store multiple objects while accessing them via a single
		 * reference. Arrays are of a fixed size. When they are created, the size must be known.
		 */
		
		int[] nums = {3, 4, 32, 1, 6}; //initialize an array with 5 values
		int[] nums2 = new int[100]; //creates an array of size 100
		int[] nums3 = new int[] {3, 4, 5, 66, 21, 3};
		
		System.out.println(nums[4]);
		
		for(int num : nums) {
			System.out.println(num);
		}
	}
}
