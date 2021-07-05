package com.eduapp.test;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class MyFrame extends JFrame{
	
	private JComponent t1;
	private JComponent t2;
	private JComponent t3;
	private JComponent bt;
	private JComponent bt2;
	
	public MyFrame(JComponent bt2) {
		this.bt2=bt2;
	}
	
	public void init() {
		setLayout(new FlowLayout());
		Dimension d = new Dimension(20,200);
		
		t1.setPreferredSize(d);
		t2.setPreferredSize(d);
		t3.setPreferredSize(d);
		
		
		add(t1);
		add(t2);
		add(t3);
		add(bt);
		add(bt2);
		
		setSize(300,250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
