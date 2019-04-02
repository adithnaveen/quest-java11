package com.training.exilant;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFuture07 {
	public static void main(String[] args) {
		System.out.println("I'm first line of Main " + Thread.currentThread());
		// singleThreadModel();
		completableMethod02();
	}

	public static void singleThreadModel() {
		Transaction transaction = new Transaction();
		System.out.println("I'm in singlethreadmodel " + Thread.currentThread());
		display(transaction.getBalance());
	}

	public static void completableMethod01() {
		Transaction transaction = new Transaction();
		completeableFuture(transaction).thenAccept(balance -> display(balance)).orTimeout(1, TimeUnit.SECONDS);

	}

	public static void completableMethod02() {
		Transaction transaction = new Transaction();
		CompletableFuture<Integer> cf = completeableFuture(transaction);

		sleep(1500);
		cf.thenAccept(balance -> display(balance)).orTimeout(50, TimeUnit.MILLISECONDS);
		cf.completeExceptionally(new RuntimeException("sorry job did not completed with in time"));
		sleep(1500);
	}

	private static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static CompletableFuture<Integer> completeableFuture(Transaction transaction) {
		return CompletableFuture.supplyAsync(() -> transaction.getBalance());
	}

	public static void display(int balance) {
		System.out.println("Balace is " + balance);
		sleep(1500);
		System.out.println("In Display " + Thread.currentThread());
	}

}
