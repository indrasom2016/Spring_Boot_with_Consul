package com.indrasom.ServiceB.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/service2")
public class DemoController {

	@GetMapping("/hello")
	public String hello()
	{
		return "Hello World";
	}
	
}
