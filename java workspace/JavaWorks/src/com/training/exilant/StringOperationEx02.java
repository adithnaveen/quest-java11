package com.training.exilant;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StringOperationEx02 {
	public static void main(String[] args) {
		// strOpr();
		
		lambdaWork(); 
		
	}

	private static void lambdaWork() {
		String name ="Sowmya"; 
		// from java 8 
		
//		Function<String, String> performOperation = (string) -> {return "Hello " + string;};  
		Function<String, String> performOperation = (string) -> "Hello " + string.toUpperCase();  
	
		System.out.println(performOperation.apply(name));
		
		List<Integer> number = Arrays.asList(1,2,3,4,5); 
		number.forEach(System.out :: println);
		
		System.out.println("-------------------------------");
		// this is an error in IDE 
//		number.forEach(( var temp) -> System.out.println(temp));
	
	}
	
	
	private static void strOpr() {
		var word = "Welcome"; 
		
		System.out.println(word);
		
		System.out.println(word.repeat(5) +"\n");
		
		var word2 ="\tfrom Bengaluru\t";
		
		System.out.println(word + word2);
		
		System.out.println(word2.stripTrailing() + word);
		System.out.println(word + word2.stripLeading() + word);
		
		System.out.println(word + word2.strip() + word); 
		
		var word3 ="   ";
		System.out.println("is word3 empty " + word3.isEmpty());
		System.out.println("is word3 blank " + word3.isBlank());
		
		
		var words="welcome\ntoday\nfor\nlearning\njava11"; 
		
		words.lines().forEach(System.out :: println);
		
		System.out.println("----------------------------------");
		
		words.lines().map(String :: toUpperCase).forEach(System.out :: println);
	}
}















