package com.example.teamProject.service.member;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.teamProject.model.member.dao.MemberDAO;
import com.example.teamProject.model.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO memberDao;

	@Override
	public boolean loginCheck(MemberDTO dto, HttpSession session) {
		boolean result=memberDao.loginCheck(dto);
		if(result) {//로그인 성공
			//세션변수에 값 저장
			MemberDTO dto2 = viewMember(dto.getUserid());
			//setAttribute(변수명,값)
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", dto2.getName());
			session.setAttribute("nick", dto2.getNick());
			System.out.println(session.getAttribute("userid"));
			System.out.println(session.getAttribute("nick"));
			System.out.println(session.getAttribute("name"));
		}

		return result;
	}

	@Override
	public void logout(HttpSession session) {
		//세션 초기화
		session.invalidate();
	}

	@Override
	public MemberDTO viewMember(String userid) {
		return memberDao.viewMember(userid);
	}

	@Override
	public List<MemberDTO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMember(MemberDTO dto) {
		memberDao.insertMember(dto);

	}

	@Override
	public boolean checkPw(String userid, String pwd) {
		return memberDao.checkPw(userid, pwd);
	}

	@Override
	public void updateMember(MemberDTO dto) {
		memberDao.updateMember(dto);

	}

	@Override
	public void deleteMember(String userid) {
		memberDao.deleteMember(userid);
	}

}
