package com.revature.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomThread extends Thread{

	@Override
	public void run() {
		System.out.println("custom thread is running");
		for(int i = 0; i < 10; i++) {
			Singleton.getInstance();
		}
	}
	
	public static void main(String[] args) {
		
		CustomThread myThread = new CustomThread();
		myThread.start();
		System.out.println(Thread.currentThread().getName());
		
		for(int i = 0; i < 10; i++) {
			Singleton.getInstance();
		}
		
		/*
		 * As a note, this is the old way of making threads in Java. Java 8 introduced an entire
		 * API for creating and managing threads: the Concurrency API. This is the more modern
		 * approach to making threads.
		 */
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(() -> System.out.println("running a task on a separate thread"));
		service.shutdown();
	}
}

/*
 * The Singleton design pattern only allows for a single instance of a class to exist in your application.
 * This is typically achieved by making the constructor private.
 */
class Singleton{
	
	private static Singleton singleton;
	
	private Singleton() {
		System.out.println("an instance has been created");
	}
	
	/*
	 * Technically speaking, you should synchronize your getInstance method because if you don't
	 * when you're working in a multi-threaded environment, your singleton will break. This is
	 * because multiple threads will enter the block that handles instance creation since the
	 * resource won't be locked.
	 */
	public synchronized static Singleton getInstance() {
		
		if(singleton == null) {
			singleton = new Singleton();
		}
		
		return singleton;
	}
	
}
