package com.example.teamProject.model.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.teamProject.model.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	SqlSession sqlSession;

	@Override
	public boolean loginCheck(MemberDTO dto) {
		String name=sqlSession.selectOne("login.login_check", dto);
		//조건식 ? true일 때의 값 : false일 때의 값
		return (name==null) ? false : true;
	}

	@Override
	public MemberDTO viewMember(String userid) {
		return sqlSession.selectOne("login.viewMember", userid);
	}

	@Override
	public List<MemberDTO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMember(MemberDTO dto) {
		sqlSession.insert("login.insertMember", dto);

	}

	@Override
	public boolean checkPw(String userid, String pwd) {
		boolean result=false;
		
		Map<String,String> map=new HashMap<>();
		map.put("userid", userid);
		map.put("pwd", pwd);
		int count=sqlSession.selectOne("login.checkPw", map);
		//비번이 맞으면(1), 틀리면 (0)리턴
		if(count==1) result=true;
		return result;
	}

	@Override
	public void updateMember(MemberDTO dto) {
		sqlSession.update("login.updateMember", dto);

	}

	@Override
	public void deleteMember(String userid) {
		sqlSession.delete("login.deleteMember", userid);

	}

}
