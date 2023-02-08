package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.service.MemberService;
import com.itwillbs.service.MemberServiceImpl;

@Controller
public class MemberController {
	//부모 = 자식 객체생성
//	MemberService memberService=new MemberServiceImpl();
	
	// 멤버변수  부모 = 자식 객체생성
	@Inject
	private MemberService memberService;
	
//	// 생성자를 통해서 전달
//	@Inject
//	public MemberController(MemberService memberService) {
//		this.memberService=memberService;
//	}
//	// set메서드 전달
//	@Inject
//	public void setMemberService(MemberService memberService) {
//		this.memberService = memberService;
//	}
	

//	웹브라우저 가상주소 http://localhost:8080/myweb/member/insert
//	=> /WEB-INF/views/폴더명/파일이름.jsp
//	=> /WEB-INF/views/member/insertForm.jsp
//	=> member/insertForm
@RequestMapping(value = "/member/insert", method = RequestMethod.GET)	
public String insert() {
	// 기본 이동방식 : 주소변경 없이 이동 
	return "member/insertForm";
}


//http://localhost:8080/myweb/member/insertPro   "post"방식
@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)	
public String insertPro(MemberDTO dto) {
//	HttpServletRequest request
	System.out.println("MemberController insertPro() ");
//	MemberDTO dto=new MemberDTO();
//	dto.setId(request.getParameter("id"));
//	dto.setPass(request.getParameter("pass"));
//	dto.setName(request.getParameter("name"));
	// => 자동으로 되는 조건 : insertForm.jsp 태그이름, MemberDTO 멤버변수 이름 동일
	System.out.println(dto.getId());
	System.out.println(dto.getPass());
	System.out.println(dto.getName());
	//MemberFrontController =>  MemberInsertPro  => MemberDAO
	//MemberController => MemberService => MemberDAO
//	MemberService memberService=new MemberServiceImpl();
	memberService.insertMember(dto);
	
	// 이동방식 : 주소변경 하면서 이동 
    // response.sendRedirect() 이동
	return "redirect:/member/login";
}

//웹브라우저 가상주소 http://localhost:8080/myweb/member/login
//=> /WEB-INF/views/폴더명/파일이름.jsp
//=> /WEB-INF/views/member/loginForm.jsp
//=> member/loginForm
@RequestMapping(value = "/member/login", method = RequestMethod.GET)	
public String login() {
	// 기본 이동방식 : 주소변경 없이 이동 
	return "member/loginForm";
}

//http://localhost:8080/myweb/member/loginPro   "post"방식
@RequestMapping(value = "/member/loginPro", method = RequestMethod.POST)	
public String loginPro(MemberDTO dto, HttpSession session) {
	System.out.println("MemberController loginPro() ");
	System.out.println(dto.getId());
	System.out.println(dto.getPass());
	//MemberController => MemberService => MemberDAO
	// MemberService 부모=자식 객체생성
	// 리턴할형없음  userCheck(MemberDTO dto) 
	// 메서드 호출 userCheck(dto)
//	MemberService memberService=new MemberServiceImpl();
	MemberDTO memberDTO=memberService.userCheck(dto);
	// 아이디 비밀번호 일치 => memberDTO 주소담아서 옴 => 세션값 생성 , main 이동
	// 아이디 비밀번호 틀림 => memberDTO null 넘어옴 => "정보틀림" 뒤로이동
	if(memberDTO!=null) {
		// 아이디 비밀번호 일치 => memberDTO 주소담아서 옴 => 세션값 생성 , main 이동
		session.setAttribute("id", memberDTO.getId());
		// 이동방식 : 주소변경 하면서 이동 
		// response.sendRedirect() 이동
		return "redirect:/member/main";
	}else {
		// 아이디 비밀번호 틀림 => memberDTO null 넘어옴 => "정보틀림" 뒤로이동
		// member/msg.jsp 이동
		return "member/msg";
	}
	

}

//웹브라우저 가상주소 http://localhost:8080/myweb/member/main
//=> /WEB-INF/views/member/main.jsp
@RequestMapping(value = "/member/main", method = RequestMethod.GET)	
public String main() {
	// 기본 이동방식 : 주소변경 없이 이동 
	return "member/main";
}
// http://localhost:8080/myweb/member/logout     GET
// => 주소변경되면서 이동 => /member/main
@RequestMapping(value = "/member/logout", method = RequestMethod.GET)	
public String logout(HttpSession session) {
	//로그아웃 처리
	session.invalidate();
	// 이동방식 : 주소변경 하면서 이동 
	// response.sendRedirect() 이동
	return "redirect:/member/main";
}


//웹브라우저 가상주소 http://localhost:8080/myweb/member/info
//=> /WEB-INF/views/member/info.jsp
@RequestMapping(value = "/member/info", method = RequestMethod.GET)	
public String info(HttpSession session,Model model) {
	// 세션값 id에 대한 정보를 디비 조회
	String id=(String)session.getAttribute("id");
	//메서드 호출
	MemberDTO dto=memberService.getMember(id);
	
	// dto  Model model(request) 담기
	model.addAttribute("dto", dto);
	
	// 기본 이동방식 : 주소변경 없이 이동 
	return "member/info";
}

//웹브라우저 가상주소 http://localhost:8080/myweb/member/update
//=> /WEB-INF/views/member/updateForm.jsp
@RequestMapping(value = "/member/update", method = RequestMethod.GET)	
public String update(HttpSession session,Model model) {
	// 세션값 id에 대한 정보를 디비 조회
	String id=(String)session.getAttribute("id");
	//메서드 호출
	MemberDTO dto=memberService.getMember(id);
	
	// dto  Model model(request) 담기
	model.addAttribute("dto", dto);
	// 기본 이동방식 : 주소변경 없이 이동 
	return "member/updateForm";
}

@RequestMapping(value = "/member/updatePro", method = RequestMethod.POST)	
public String updatePro(MemberDTO dto) {
	MemberDTO memberDTO=memberService.userCheck(dto);
	if(memberDTO!=null) {
		// 아이디 비밀번호 일치 => update , main 이동
		memberService.updateMember(dto);
		// 이동방식 : 주소변경 하면서 이동 
		// response.sendRedirect() 이동
		return "redirect:/member/main";
	}else {
		// 아이디 비밀번호 틀림 => memberDTO null 넘어옴 => "정보틀림" 뒤로이동
		// member/msg.jsp 이동
		return "member/msg";
	}
}


//웹브라우저 가상주소 http://localhost:8080/myweb/member/delete
//=> /WEB-INF/views/member/deleteForm.jsp
@RequestMapping(value = "/member/delete", method = RequestMethod.GET)	
public String delete() {
	// 기본 이동방식 : 주소변경 없이 이동 
	return "member/deleteForm";
}

@RequestMapping(value = "/member/deletePro", method = RequestMethod.POST)	
public String deletePro(MemberDTO dto,HttpSession session) {
	MemberDTO memberDTO=memberService.userCheck(dto);
	if(memberDTO!=null) {
		// 아이디 비밀번호 일치 => delete , 세션 초기화, main 이동
		memberService.deleteMember(dto);
		// 세션초기화
		session.invalidate();
		// 이동방식 : 주소변경 하면서 이동 
		// response.sendRedirect() 이동
		return "redirect:/member/main";
	}else {
		// 아이디 비밀번호 틀림 => memberDTO null 넘어옴 => "정보틀림" 뒤로이동
		// member/msg.jsp 이동
		return "member/msg";
	}
}//

//웹브라우저 가상주소 http://localhost:8080/myweb/member/list
//=> /WEB-INF/views/member/list.jsp
@RequestMapping(value = "/member/list", method = RequestMethod.GET)	
public String list(Model model) {
	// 회원정보 전체 조회
	List<MemberDTO> memberList=memberService.getMemberList();
	// 데이터 model 담아서 
	model.addAttribute("memberList", memberList);
	// 기본 이동방식 : 주소변경 없이 이동 
	return "member/list";
}


}//클래스
