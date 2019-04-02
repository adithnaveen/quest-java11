package com.training.exilant;

import java.util.Arrays;
import java.util.regex.Pattern;

public class MatcherEx03 {
	public static void main(String[] args) {
		var companyName= Arrays.asList("Quest",
				"Quest Global", "Quest India", "Quest USA", "Exilant"); 
		
		
		// have a predicate 
		var predicate = Pattern.compile("quest", Pattern.CASE_INSENSITIVE).asPredicate(); 
		
		companyName.forEach((company) -> {
			if(predicate.test(company)) {
				System.out.println("Matches in the list " + company);
			}else {
				System.out.println("Does not match in the list " + company);
			}
		});
	}
}
