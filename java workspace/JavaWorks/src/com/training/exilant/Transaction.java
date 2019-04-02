package com.training.exilant;

public class Transaction {
	public synchronized int getBalance() {
		System.out.println("In Transaction " + Thread.currentThread());
		
		// simulate to kill some time 
		
		for(var i=0 ;i<5000; i++) System.out.print("");
		return (int) (Math.random()*10000); 
	}
}
