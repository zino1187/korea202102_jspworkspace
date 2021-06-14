package test;
//import javax.swing.JButton;  //rt.jar  jdk ��ġ�Ҷ� �̹� jar�� ����
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter; //javase
import java.io.IOException;//javase

//jsp ���̵�, ���������� ����� ������ �� �ְ�, �Ʒ��� ���� 
//�������� �ؼ� �� ����Ǵ� Ŭ������ ������ ����(Servlet)�̶� �ϸ�
//javaEE  -- java ee for kit

//���� Ŭ������ ���������� ����Ǹ�, Ŭ�����̾�Ʈ�� ����û�� �ް�, ������ ó���ϴ�
//���� Ŭ�����̴�!! ���� jsp ��� ���������ε� �������� �����ϴ�!!

//������ �����ֱ� �޼���� �Ҹ��� �ֿ� �޼��尡 �����ϸ�, �� �����ֱ� �޼����
//�ϳ��� ���� ��ü�� �¾�� ���ϸ�, �Ҹ��ϴ� ������ ������ �ֿ� �޼����̴�
//���� Ŭ������ ��ġ�� WEB-INF/classes �̹Ƿ�, ���������� url�� ���� 
//ȣ���� �� ����, ���� ����(mapping)�� �̿��Ѵ�
public class MyServlet extends HttpServlet{
	//���� �ν��Ͻ��� �¾ ��, ������ �ʱ�ȭ �۾��� ȣ��Ǵ� �޼��� 
	public void init(){
		System.out.println("�� �¾��, �ʱ�ȭ �Ϸ�Ǿ��");
	}	
	
	//�ʱ�ȭ�� �Ϸ��� ������, ��Ŭ���̾�Ʈ�� ��û�� ó���Ҷ� �����ϴ� �޼���
	public void service(HttpServletRequest request,  HttpServletResponse response){
		System.out.println("Ŭ���̾�Ʈ�� ��û�� ó���մϴ�");
		//���������� ���������� �����Ͽ� �����ϱ� 
		try{
			response.setCharacterEncoding("utf-8"); //���������� ��� ���ڵ��� utf-8��
			PrintWriter out=response.getWriter(); //Ŭ���̾�Ʈ�� ����� ��½�Ʈ��
			out.print("my servlet Test");
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	//������ �Ҹ��Ҷ� ȣ��Ǵ� �޼��� 
	public void destroy(){
		System.out.println("�� ���� ���ϴ�...");
	}
}

