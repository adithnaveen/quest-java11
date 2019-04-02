package com.training.day2;

import java.io.IOException;

public class FlightRecorderEx1 {
	public static void main(String... args) throws IOException {
	    HelloWorld1 event = new HelloWorld1();
	    event.message = "hello, world!";
	    event.commit();
	}
}
