package com.koreait.mvcframework.view.blood;

import java.awt.Choice;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class BloodMain extends JFrame{
	JComboBox<String> ch;
	JButton bt;
	String[] arr= {"A형","B형","O형","AB형"};
	
	public BloodMain() {
		ch = new JComboBox<String>(arr);
		bt = new JButton("결과보기");
		
		setLayout(new FlowLayout());
		
		add(ch);
		add(bt);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BloodMain();
	}
}













