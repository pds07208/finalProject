package com.itwillbs.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
//import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	// 마이바티스 객체생성 => 멤버변수 자동 주입
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.itwillbs.mappers.memberMapper";
	
//	private DataSource dataSource;
//	private SimpleJdbcTemplate jdbcTemplate;
	
	//set 메서드
//	@Inject
//	public void setDataSource(DataSource dataSource) {
////		this.dataSource = dataSource;
//		jdbcTemplate=new SimpleJdbcTemplate(dataSource);
//		
//	}

//	String insertSql="insert into members(id,pass,name,date) values(?,?,?,?)";
	@Override
	public void insertMember(MemberDTO dto) {
		System.out.println("MemberDAOImpl insertMember()");
		System.out.println(dto.getMem_id());
		System.out.println(dto.getMem_pass());
		System.out.println(dto.getMem_name());
		System.out.println(dto.getMem_nname());
		System.out.println(dto.getMem_num());
		System.out.println(dto.getMem_phone());
		System.out.println(dto.getMem_email());
		System.out.println(dto.getMem_address());
		System.out.println(dto.getMem_phone());
		//날짜
		Timestamp date=new Timestamp(System.currentTimeMillis());
		dto.setMem_time(date);
		
//		jdbcTemplate.update(insertSql, dto.getId(),dto.getPass(),dto.getName(),date);
		//memberMapper.xml 
		sqlSession.insert(namespace+".insertMember",dto);
		//update => sqlSession.update(null);
		//delete => sqlSession.delete(null);
		//select 리턴값 하나 => sqlSession.selectOne(null);
		//select List(배열) 리턴할때 =>  sqlSession.selectList(null);
	}

	@Override
	public MemberDTO userCheck(MemberDTO dto) {
		System.out.println("MemberDAOImpl userCheck()");
		System.out.println(dto.getMem_id());
		System.out.println(dto.getMem_pass());
		
		return sqlSession.selectOne(namespace+".userCheck", dto);
	}

	@Override
	public MemberDTO getMember(String mem_id) {
		return sqlSession.selectOne(namespace+".getMember", mem_id);
	}

	@Override
	public void updateMember(MemberDTO dto) {
		sqlSession.update(namespace+".updateMember", dto);
	}

	@Override
	public void deleteMember(MemberDTO dto) {
		sqlSession.delete(namespace+".deleteMember", dto);
	}

	@Override
	public List<MemberDTO> getMemberList() {
		return sqlSession.selectList(namespace+".getMemberList");
	}
	
	
}
