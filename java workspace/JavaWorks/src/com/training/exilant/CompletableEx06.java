package com.training.exilant;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.util.concurrent.CompletableFuture.supplyAsync; 


public class CompletableEx06 {
	private int x; 
	private static String job1 =  "Job-01";
	private static String job2 =  "Job-02";
	private static String job3 =  "Job-03";
	
	public static void main(String[] args) 
				throws InterruptedException, ExecutionException {

		System.out.println("I'm in " + Thread.currentThread());
		
		CompletableFuture<String> cf = supplyAsync(() -> {
			return "Hi All";  
		}); 
		
		cf.defaultExecutor().execute(() ->{
			System.out.println("hey i'm in execute");
		});
		
		System.out.println(cf.toCompletableFuture().get());
		
//		work();
		throwsException(); 
	}
	
	public static void work() throws InterruptedException, ExecutionException {
		CompletableFuture<String> req1 = supplyAsync(() ->{
			// simulate some processing is happening 
			sleep(1000); 
			System.out.println("I'm in Req1 " + Thread.currentThread());
			return job1 +" completed"; 
		}); 
		
		CompletableFuture<String> req2 = supplyAsync(() ->{
			sleep(1000); 
			System.out.println("I'm in Req2 " + Thread.currentThread());
			return job2 +" completed"; 
		}); 
		
		CompletableFuture<String> req3 = supplyAsync(() ->{
			sleep(1000); 
			System.out.println("I'm in Req3 " + Thread.currentThread());
			return job3 +" completed"; 
		}); 
		
//		System.out.println(req1.get());
//		System.out.println(req2.get());
//		System.out.println(req3.get());

//		
//		CompletableFuture<Object> anyCompletableFuture = 
//				CompletableFuture.anyOf(req1, req2, req3); 
//		
//		System.out.println(anyCompletableFuture.get());
		
		CompletableFuture<Void> allCompletableFuture =
				CompletableFuture.allOf(req1, req2, req3); 
	
		System.out.println(allCompletableFuture.get());
		
		System.out.println("Last line of the method");
	}

	private static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void throwsException() {
		CompletableFuture<String> completableFuture = supplyAsync(() -> {
			int x = 10; 
			if(x ==10) {
				throw new RuntimeException("Hey i'm explicitly thrown"); 
			}
			return "Hello"; 
		}); 
		
		System.out.println(completableFuture.join()); 
		
		completableFuture.completeExceptionally(
				new RuntimeException("Wow i'm from RunTimeException")); 
		
		
	}
	
	
	
	
	
	
	
	
}
