package com.koreait.shoppingmall.aop.admin;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;

//관리자기능을 이루는 모든 페이지마다 , 또는 컨트롤러의 모든 메서드 마다 세션을 검증하는 코드를 일일이 작성하지 말고,
//공통로직으로 두고, AOP를 적용하여 개발의 효율성을 높이자..

//아까 예제에서의 Bell과 같은 녀석임..
public class AdminSessionCheckAspect2 {
	//관리자와 즉 admin으로 시작하는 모든  요청 URI를 세션의 검증대상으로 보지말고, 로그인이 필요치 않는 요청에 대해서는 
	//그냥 가던길 가게 해주자!! 
	public void sessionCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		
		Object[] args=joinPoint.getArgs(); //타겟 객체의 메서드 요청시 넘어오는 매개변수들을 잡아냄
		HttpServletRequest request=null;
		
		for(Object obj : args) {
			if(obj instanceof HttpServletRequest) {
				request =(HttpServletRequest)obj;
			}
		}
		
		String uri = request.getRequestURI();
		
		
		if(uri.equals("/admin/loginform") || uri.equals("/admin/xxxx") || uri.equals("/admin/kkkk")){
			//검증이 필요하지 않은 경우
			joinPoint.proceed();
		}else {
			//검증이 필요한 경우	
			
		}
		 
	}
}
