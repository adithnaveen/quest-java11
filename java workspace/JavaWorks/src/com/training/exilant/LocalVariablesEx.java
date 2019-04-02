package com.training.exilant;

import java.util.HashMap;

public class LocalVariablesEx {

	// program to show working of local variables with var and 
	// knowing pros and cons 
	
	public static void main(String[] args) {
		// old code 
		int oldNum = 100; 
		System.out.println("Number is " + oldNum);
		
		// java 10 
		var newNum = 200; 
		System.out.println("New Number is " + newNum);
		
		// declaring multiple varibles in same line 
		int num1 = 100, num2 = 200;
		// gives error 
//		var nnum1 = 100, nnum2 = 200; 
		
		var var1 = 200; 
//		var1 ="Hello"; 
		 
		for(int i=0; i<10; i++) {
			System.out.println("i value is " +i );
		}
		
		System.out.println("---------------------------");
		
		 
		for(var i=0; i<10; i++) {
			System.out.println("i value is " +i );
		}
		
		// inference from java 9 
		HashMap<String, Integer> oldMap = new HashMap<>(); 
		
		var newMap = new HashMap<String, Integer>(); 
		
		
		var newMap2 = new HashMap<>(); 
		newMap2.put("Harry", 2000); 
		
		System.out.println("value is " + newMap2.get("Harry"));
		
		System.out.println("Addition value is " + addNumber(10, 20));
		testClassTypes(); 
		methodArray(); 
		
	}
	
	public static int addNumber(int num1, int num2) {
		return num1 + num2; 
	}


	public static void testClassTypes() {
		var x ="Hello World"; 
		System.out.println(x.getClass().getName());
		

//		Integer intY = new Integer(10); 
		var intY = Integer.valueOf(10); 
		System.out.println(intY.getClass().getName());
	}
	
	public static void methodArray() {
		int [] arr = {10, 20, 30 ,40}; 
		for(var temp : arr) {
			System.out.println(temp);
		}
	}
	
}













