package com.training.exilant.day2;

import java.util.List;

/// simulate the data from external resource/s
public class LoadData {
	
	public static List<Stock> getStocks(){
		return List.of(
				new Stock("Quest", 444), 
				new Stock("Amazon", 19), 
				new Stock("Microsoft", 332), 
				new Stock("Infosys", 56), 
				new Stock("Exilant", 65) 
			);
	}
}
