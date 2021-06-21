package site0621.board.model.domain;

import lombok.Data;

/* 자바 또는 웹개발을 하다보면 @가 자주 등장 
 * @는 Annotation이라고 하며 jdk5 버전부터 등장 
 * 주 용도는 클래스 코드안에서 부가적인 설정, 설명을 하기 위한 메타정보 ,일종의 주석
 * 즉 프로그램에 사용되는 주석 , 메타정보 
 * */
public class Board {
	private int board_id;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int hit;
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
}
