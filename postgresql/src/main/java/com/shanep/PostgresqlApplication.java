package com.shanep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostgresqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresqlApplication.class, args);
		
		System.out.println("\n\n==============\n 시작 \n =============="); 
	}

}