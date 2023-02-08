package com.itwillbs.domain;

import java.sql.Timestamp;

public class MemberDTO {
	// 회원가입 한 내용을 담아서 전달해주는 바구니
	// 멤버변수 => 접근 제한 => 데이터 은닉, 캡슐화
	private int mem_num;
	private String mem_id;
	private String mem_pass;
	private String mem_phone;
	private String mem_name;
	private String mem_nname;
	private String mem_email;
	private String mem_address;
	private String mem_account;
	private Timestamp mem_time;

	public int getMem_num() {
		return mem_num;
	}

	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pass() {
		return mem_pass;
	}

	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_nname() {
		return mem_nname;
	}

	public void setMem_nname(String mem_nname) {
		this.mem_nname = mem_nname;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_address() {
		return mem_address;
	}

	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}

	public String getMem_account() {
		return mem_account;
	}

	public void setMem_account(String mem_account) {
		this.mem_account = mem_account;
	}

	public Timestamp getMem_time() {
		return mem_time;
	}

	public void setMem_time(Timestamp mem_time) {
		this.mem_time = mem_time;
	}

}
