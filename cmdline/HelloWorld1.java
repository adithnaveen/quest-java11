package com.training.day2;
import jdk.jfr.Description;
import jdk.jfr.Event;
import jdk.jfr.Label;

@Label("Hello World")
@Description("Helps the programmer getting started")
class HelloWorld1 extends Event {
   @Label("Message")
   String message;
}