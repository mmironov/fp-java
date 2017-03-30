package com.musala.fp;

public class TypeOfLambda {

	static void doSomething() {
		System.out.println("run");
	}
	
	public static void main(String[] args) {
		
		Runnable r = () -> System.out.println("run");
		
		r.run();
		
		//return a lambda
	}
}
