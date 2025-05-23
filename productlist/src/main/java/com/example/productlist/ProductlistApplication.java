package com.example.productlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProductlistApplication {

	public static void main(String[] args) {
		 ApplicationContext context = SpringApplication.run(ProductlistApplication.class, args);
		 MyApp myApp = context.getBean(MyApp.class);
		 myApp.run();
	}

}
