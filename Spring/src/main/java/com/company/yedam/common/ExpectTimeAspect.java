package com.company.yedam.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExpectTimeAspect {
	@Pointcut("execution(* com.company.yedam..*Impl.*One(..))") // 메소드명이 ...one 일 때만 pointcut 적용, aspect 실행
	public void getpointcut() {}
	
	@Around("getpointcut()")
	public Object measure(ProceedingJoinPoint pjp) {
		System.out.println("[around] before");
		// 실행시간 체크
		long start = System.nanoTime(); // 현재시간을 나노타임으로 값을 읽어와서 현재시간 저장 후 서비스 호출
		Object result = null;
		try {
			result = pjp.proceed(); // 서비스 호출, 리턴 값을 받아와야함
			return result;
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// 시간 체크
			long finish = System.nanoTime(); 
			// 실행시간 출력
			System.out.println("[around] after 실행시간 : " 
								+ (finish-start) );
		}
		return result;
	}
}
