package com.training.exilant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadWriteEx05 {
	public static void main(String[] args) throws IOException {
//		Files.writeString(Path.of("Sample.txt"	), "Welcome to Java11 "); 

		
		System.out.println(Files.readString(Path.of("Sample.txt"))); 
	}
}
