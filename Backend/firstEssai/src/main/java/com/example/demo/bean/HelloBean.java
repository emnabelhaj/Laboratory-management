package com.example.demo.bean;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {
	public String getMessage(String  msg) {
		return "Hello"+msg ;
	}
}
