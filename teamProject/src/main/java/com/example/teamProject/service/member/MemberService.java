package com.example.teamProject.service.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.teamProject.model.member.dto.MemberDTO;

public interface MemberService {
	public boolean loginCheck(MemberDTO dto, HttpSession session);
	public void logout(HttpSession session);
	public MemberDTO viewMember(String userid);
	public List<MemberDTO> list();
	public void insertMember(MemberDTO dto);
	public boolean checkPw(String userid, String pwd);
	public void updateMember(MemberDTO dto);
	public void deleteMember(String userid);
}
