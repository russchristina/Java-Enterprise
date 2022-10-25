package com.revature;

/**
 * 
 * A functional interface is an interface that has one and ONLY one abstract method.
 * 
 * The @FunctionalInterface annotation adds compile-time safety so that we don't accidentally
 * modify our interface in a way that it makes something other than a functional interface.
 * 
 * @author Christina
 *
 */
@FunctionalInterface
public interface MyFunctionalInterface {

	int doMath(int x, int y); //an abstract method
}
