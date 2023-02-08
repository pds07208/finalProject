package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.dao.MemberDAOImpl;
import com.itwillbs.domain.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{
	// 부모= 자식 객체생성
//	MemberDAO memberDAO=new MemberDAOImpl();
	
	//부모= 자식 객체생성
	@Inject  
	private MemberDAO memberDAO;
	
//	// 생성자
//	@Inject
//	public MemberServiceImpl(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}
//	// set 메서드
//	@Inject
//	public void setMemberDAO(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}


	@Override
	public void insertMember(MemberDTO dto) {
		System.out.println("MemberServiceImpl insertMember()");
		System.out.println(dto.getId());
		System.out.println(dto.getPass());
		System.out.println(dto.getName());
		//MemberController => MemberService => MemberDAO
//		MemberDAO memberDAO=new MemberDAOImpl();
		memberDAO.insertMember(dto);
		
	}

	@Override
	public MemberDTO userCheck(MemberDTO dto) {
		System.out.println("MemberServiceImpl userCheck()");
		System.out.println(dto.getId());
		System.out.println(dto.getPass());
		// 객체생성
		//메서드 호출
//		MemberDAO memberDAO=new MemberDAOImpl();
		return memberDAO.userCheck(dto);
		
	}

	@Override
	public MemberDTO getMember(String id) {
		return memberDAO.getMember(id);
	}

	@Override
	public void updateMember(MemberDTO dto) {
		memberDAO.updateMember(dto);
	}

	@Override
	public void deleteMember(MemberDTO dto) {
		memberDAO.deleteMember(dto);
	}

	@Override
	public List<MemberDTO> getMemberList() {
		return memberDAO.getMemberList();
	}
	
	
}
