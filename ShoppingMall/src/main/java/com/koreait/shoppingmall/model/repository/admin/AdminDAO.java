package com.koreait.shoppingmall.model.repository.admin;

import java.util.List;

import com.koreait.shoppingmall.domain.Admin;

public interface AdminDAO {
	public Admin login(Admin admin); //로그인 
	public void regist(Admin admin);//관리자 등록 
	public void update(Admin admin);//관리자 수정
	public void delete(Admin admin); //아이디, 패스워드가 모두 일치할때 탈퇴시켜야 하기 때문...
	public List selectAll();
}
