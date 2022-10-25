package com.revature;

/*
 * VarArgs is short for "Variable Arguments". It allows us to create a method that takes an indefinite
 * number of arguments when called.
 */
public class VarArgs {
	
	public static void main(String...args) {
		
		VarArgs varArgs = new VarArgs();
		int answer = varArgs.add(3, 2);
		int answer2 = varArgs.add(4, 5, 665, 2, 2, 5, 3);
		
	}
	
	public int add(int a, int b) {
		System.out.println("Java always chooses the most specific method, so even with the var "
				+ "args, this method will be called if there are 2 args passed in.");
		return a + b;
	}
	
	public int add(int a, int b, int c) {
		return a + b + c;
	}
	
	/*
	 * This is a variable argument. It indicates that when this method is called, the caller can
	 * pass any number of arguments. Note that it is treated like an array, so you have the
	 * option to iterate over it.
	 * 
	 * You're only allowed to have one variable argument. If you have a variable argument, it has
	 * to be the last argument.
	 */
	public int add(int...a) {
		int sum = 0;
		for(int i : a) {
			sum += i;
		}
		return sum;
	}
	

}
