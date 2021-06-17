package site0616.board.view.swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//우리가 정의한 DAO 가 정말로 웹 또는 응용분야 모두에서 사용가능한 중립적 클래스인지 
//테스트해보기 위한 Swing 프로그램 구현 
public class RegistForm extends JFrame{
	JTextField t_title;
	JTextField t_writer;
	JTextArea t_content;
	JButton bt;
	
	public RegistForm() {
		t_title = new JTextField(20);
		t_writer = new JTextField(20);
		t_content = new JTextArea(12,20);
		bt = new JButton("등록");
		
		//조립
		setLayout(new FlowLayout());
		add(t_title);
		add(t_writer);
		add(t_content);
		add(bt);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(270,350);
	}
	public static void main(String[] args) {
		new RegistForm();
	}
}










