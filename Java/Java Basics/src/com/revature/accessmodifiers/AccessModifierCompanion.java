package com.revature.accessmodifiers;

import com.revature.AccessModifiersAndScope;

public class AccessModifierCompanion extends AccessModifiersAndScope{

	public static void main(String[] args) {
		AccessModifiersAndScope amas = new AccessModifiersAndScope();
		amas.field4 = 4; //field4 is public and therefore directly accessible everywhere
		amas.method1();
	}
	
	public void someMethod() {
		this.field3 = 'c';
	}
}
