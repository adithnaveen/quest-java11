package com.training; 


public class HelloWorld{
	public static void main(String [] args){
		System.out.println("Welcome to java 11"); 
		for(var i=0; i<1000; i++){
			System.out.println("i value is " + i ); 
			try{
				Thread.sleep(1000); 
			}catch(Exception e){}
		}
	}
}