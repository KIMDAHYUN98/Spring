package com.company.yedam.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect // aop:aspect
public class LogAdvice {
	@Pointcut("execution(* com.company.yedam..*Impl.*(..))") // Point(expression)
	public void allpointcut() {}
	
	@Before("allpointcut()") // 포인트와 ref 작성 == aop:before
 	public void printLog(JoinPoint jp) {
		// 호출해야 하는 메서드 명
		String name = jp.getSignature().getName();
		// 매개변수
		Object[] args = jp.getArgs();				
		System.out.println("[공통로그] before 적용 "
				 			+ name + "---"
							+ (args !=null && args.length > 0 ? args[0] : ""));
		// 매개변수가 있으면 첫번째 매개변수 출력, 없으면 "" 출력
	}
}
