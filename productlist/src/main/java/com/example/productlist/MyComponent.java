package com.example.productlist;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {
	public MyComponent() {
		System.out.println("Result from MyComponent ctor");
	}
	
	public void getMessage() {
		System.out.println("Result from getMessage");
	}

}
