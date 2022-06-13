package com.xoraint.emp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.xoraint.emp.model.Employee;

@Component
@Aspect
public class MyAspect {

//	@Before("execution(* com.xoraint.emp.service.EmployeeService.*(*))")
//	public void f1(JoinPoint jp) {
//		System.out.println("----> Before " + jp.getSignature());
//	}
//
//	@After("execution(* com.xoraint.emp.service.EmployeeService.*(*))")
//	public void f2(JoinPoint jp) {
//		System.out.println("<---- After " + jp.getSignature());
//	}

	@Around("execution(* com.xoraint.emp.service.EmployeeService.*(*))")
	public Employee f3(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("<---- AROUND ----> " + pjp.getSignature());
		
		Employee emp = (Employee) pjp.proceed();
		
		//System.out.println(emp);
		return emp;

	}

}
