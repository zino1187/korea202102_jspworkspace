package com.koreait.site0622.model.domain;

import lombok.Data;

@Data
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int manager;
	private String hiredate;
	private int sal;
	private int comm;
	private Dept dept;	
}
