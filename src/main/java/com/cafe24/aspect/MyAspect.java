package com.cafe24.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyAspect {
	
	@Before("execution(ProductVo com.cafe24.aspect.ProductService.find(String))")
	public void beforeAdvice() {
		System.out.println("---before advice---");
	}
	
	@After("execution(* ProductService.find(String))")
	public void afterAdvice() {
		System.out.println("---after advice---");
	}
	
	@AfterReturning("execution(* ProductService.find(String))")
	public void afterReturningAdvice() {
		System.out.println("---after returning advice---");
	}
	
	@AfterThrowing(value="execution(* ProductService.find(String))", throwing = "ex")
	public void afterThrowingAdvice(Throwable ex) {
		System.out.println("---after throwing advice---" + ex);
	}
	@Around(value="execution(* ProductService.find(String))")
	public Object roundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		// before advice
		System.out.println("around before advice");
		
		// PointCut 되는 메소드 호출
		// parameter를 넣어주면 TV가 안나오고 Camera가 나온다. 흐름 자체를 조작하는것.
		Object[] parameters = {"Camera"};
		Object result = pjp.proceed(parameters);
		
		// after advice
		System.out.println("around after advice");
		
		return result;
	}
	
	
}
