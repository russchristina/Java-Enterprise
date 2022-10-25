package com.revature;

public class Operators {
	
	public static void main(String[] args) {
		
		byte aByte = 80;
		short aShort = 1;
		int anInteger = 3333333;
		long aLong = 3432234L;
		float aFloat = 8.7f;
		double aDouble = 8343324.384d;
		boolean aBoolean = true;
		char aChar = '4';
		
		short short1 = 50;
		short short2 = 98;
//		short short3 = short1 + short2; //DOES NOT COMPILE
		
		//Calling our static method
		Operators.add(2, 6);
		
		/*
		 * There is a built-in class that handles math in Java.
		 */
		Math.abs(87.33);
		Math.pow(3.3, 4.3);
		
		//Additional operators:
		System.out.println(anInteger++);
		anInteger += 8; //anInteger = anInteger + 8;
		
		//Ternary operator
		int answer = (aBoolean == true) ? 100 : 0;
		
	}
	
	static int add(int num1, int num2){
		return num1 + num2;
	}
	
	

}
