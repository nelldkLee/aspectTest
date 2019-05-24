package com.cafe24.aspect;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	public void hello() {
		System.out.println("hello 호출");
	}
	
	public ProductVo find(String name) {
		System.out.println("finding......");
		if(false) {
			throw new RuntimeException("my Exception");
		}
		return new ProductVo(name);
	}
}
