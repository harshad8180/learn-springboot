package com.example.product.controller;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custome")
public class CustomeEndpoint {
	@ReadOperation
	public String getCustom() {
		return "This us Custome Endpoint";
	}
}
