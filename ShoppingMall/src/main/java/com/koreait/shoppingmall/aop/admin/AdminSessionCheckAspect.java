package com.koreait.shoppingmall.aop.admin;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;

//관리자기능을 이루는 모든 페이지마다 , 또는 컨트롤러의 모든 메서드 마다 세션을 검증하는 코드를 일일이 작성하지 말고,
//공통로직으로 두고, AOP를 적용하여 개발의 효율성을 높이자..

//아까 예제에서의 Bell과 같은 녀석임..
public class AdminSessionCheckAspect {

	public void sessionCheck(ProceedingJoinPoint joinPoint) {
		System.out.println("원래 호출하려고 했던 메서드는 " + joinPoint.getSignature().getName());

		// 뭘 검사하고 싶나?
		// 세션?

		HttpSession session = null;

		// 증명 : 하위 컨트롤러들에게는 이미 HttpServletRequest가 전달되고 있다는 것을 증명하겟다!!
		Object[] args = joinPoint.getArgs(); // 컨트롤러 메서드 호출시 넘어오는 모든 매개변수를 잡아내자!!
		for (Object obj : args) { //
			if (obj instanceof HttpSession) { // obj가 HttpSession의 자료형일때만...담겠다..
				session = (HttpSession) obj;
			}
		}
	}
}
