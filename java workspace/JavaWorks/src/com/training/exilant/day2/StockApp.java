package com.training.exilant.day2;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class StockApp {
	public static void main(String[] args) {
		SubmissionPublisher<Stock> publisher = 
					new SubmissionPublisher<>(); 
		
		// invoke the subscriber 
		publisher.subscribe(new StockExchange());
		publisher.subscribe(new StockExchange());
		publisher.subscribe(new StockExchange());
		
		// get the data 
		List<Stock> stocks = LoadData.getStocks(); 
		
		stocks.stream().forEach(item -> {
			publisher.submit(item); 
			sleep(400); 
		});
		
		System.out.println("Exiting Main... ");
		publisher.close(); 
	}

	private static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
