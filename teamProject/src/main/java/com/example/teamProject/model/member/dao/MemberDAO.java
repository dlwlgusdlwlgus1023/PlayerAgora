package com.example.teamProject.model.member.dao;

import java.util.List;

import com.example.teamProject.model.member.dto.MemberDTO;

public interface MemberDAO {
	public boolean loginCheck(MemberDTO dto);
	public MemberDTO viewMember(String userid);
	public List<MemberDTO> list();
	public void insertMember(MemberDTO dto);
	public boolean checkPw(String userid, String pwd);
	public void updateMember(MemberDTO dto);
	public void deleteMember(String userid);
}
