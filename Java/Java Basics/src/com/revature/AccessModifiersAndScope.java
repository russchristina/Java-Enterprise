package com.revature;

class AnotherClass{
	//field 2 can be directly accessed within this class
}

public class AccessModifiersAndScope {
	
	//Instance scoped variables
	private int field1;
	boolean field2; //default access = package private
	protected char field3;
	public float field4; //directly accessible everywhere
	
	public AccessModifiersAndScope() {
		this.field1 = 1;
	}
	
	public static void main(String[] args) {
		
	}
	
	{
		int anotherNum = 890;
	}
	
	public void method1() {
		//Local scope
		int num = 0;
	}
	
	public void method2() {
		this.field3 = 78;
	}

}
