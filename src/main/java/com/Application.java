package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		  if (args.length != 1) {
		    System.err.println("Usage: java Application <input_file>");
		    System.exit(1);
		  }
		  SpringApplication.run(Application.class, args);
		}

	
}
