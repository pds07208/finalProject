package com.itwillbs.domain;

import java.sql.Timestamp;

public class MemberDTO {
	// 회원가입 한 내용을 담아서 전달해주는 바구니
	// 멤버변수 => 접근 제한 => 데이터 은닉, 캡슐화
	private String id;
	private String pass;
	private String name;
	private Timestamp date;
	// 생성자
	
	//멤버함수(메서드)
	//  set() : 멤버변수에 외부에 데이터를 저장
	//  get() : 외부에서 멤버변수 데이터를 가져다 사용
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
}
