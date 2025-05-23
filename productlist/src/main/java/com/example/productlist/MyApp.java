package com.example.productlist;

import org.springframework.stereotype.Component;

@Component
public class MyApp {
	
	private MyComponent myComponent;
	
	public MyApp(MyComponent myComponent) {
		 this.myComponent = myComponent;
	}
	
	public void run() {
		myComponent.getMessage();
	}
}
