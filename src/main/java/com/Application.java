package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		  if (args.length != 1) {
		    System.exit(1);
		  }
		  String inputFileName = args[0];
		  SpringApplication.run(Application.class, args);
		}

	
}
