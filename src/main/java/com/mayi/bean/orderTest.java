package com.mayi.bean;

import com.mayi.annotation.Autowired;
import com.mayi.annotation.Component;

@Component(value = "xiaoguangchun")
public class orderTest {
	
	@Autowired
	private Order order;

	@Override
	public String toString() {
		return "orderTest [order=" + order + "]";
	}
	
	
	
}
