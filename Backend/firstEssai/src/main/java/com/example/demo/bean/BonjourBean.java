package com.example.demo.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component("eng")
public class BonjourBean implements IHello {

	@Override
	public String getMessage(String msg) {
		return "Bonjour"+msg;
	}
	

}
