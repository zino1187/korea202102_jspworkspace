package com.koreait.model2app.model.domain;

import lombok.Data;

@Data
public class Member {
	private int member_id;
	private String name;
	private String phone;
	private String addr;
	private String photo;
}
