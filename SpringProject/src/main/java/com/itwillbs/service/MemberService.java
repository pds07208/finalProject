package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.MemberDTO;

public interface MemberService {
	//추상메서드 정의
	public void insertMember(MemberDTO dto);
	
	// MemberDTO 리턴할형  userCheck(MemberDTO dto)
	public MemberDTO userCheck(MemberDTO dto);
	
	//MemberDTO dto=memberService.getMember(id);
	public MemberDTO getMember(String id);
	
	// memberService.updateMember(dto);
	public void updateMember(MemberDTO dto);
	
//	memberService.deleteMember(dto);
	public void deleteMember(MemberDTO dto);
	
//	List<MemberDTO> memberList=memberService.getMemberList();
	public List<MemberDTO> getMemberList();
	
}
