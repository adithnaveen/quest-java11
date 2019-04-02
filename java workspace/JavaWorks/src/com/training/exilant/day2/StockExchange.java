package com.training.exilant.day2;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class StockExchange implements Subscriber<Stock>{

	private Subscription subscription; 
	
	// first method to be invoked is this and one time 
	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription; 
		subscription.request(1); 
	}

	@Override
	public void onNext(Stock item) {
		System.out.println("onNext[Stock] : " + item);
		this.subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		new Exception("something went wrong", throwable); 
	}

	@Override
	public void onComplete() {
		System.out.println("Finished processing all the stocks");
	}

}
