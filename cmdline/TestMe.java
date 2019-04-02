package com.training.jcmd; 

public class TestMe{
	public static void main(String [] args){
		System.out.println("Start of Program");
		for(var i=0; i<1000; i++){
			System.out.println("Value of i " + i); 
			try{
			Thread.sleep(1000); 
			}catch(Exception e){}
		}
		System.out.println("End of Program");
	}
}