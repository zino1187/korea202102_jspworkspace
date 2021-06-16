package site0616.test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

//현재 클래스는 그냥 클래스이므로, 웹컨테이너에서 해석 및 실행되기 위해서는 서블릿으로 정의해야 한다
public class MyServlet extends HttpServlet{
	//아래의 메서드는 서블릿의 인스턴스가 생성되자 마자, 웹컨테이너인 톰켓에 의해 초기화 되기 위한 용도도 사용된다 
	//그리고 init메서드의 매개변수로 전달되는 ServletConfig 객체는, 말 그대로 서블릿의 환경정보를 담고있는 객체이다!
	//그리고 이 ServletConfig 객체는, 톰켓에 의해 생성되어 서블릿에게 전달되어 진다 
	public void init(ServletConfig config) throws ServletException {

	}
}
