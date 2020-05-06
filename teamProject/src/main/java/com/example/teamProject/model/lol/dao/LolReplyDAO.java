package com.example.teamProject.model.lol.dao;

import java.util.List;

import com.example.teamProject.model.lol.dto.LolReplyDTO;

public interface LolReplyDAO {
	public List<LolReplyDTO> list(int bno);
	public int count(int bno);
	public void create(LolReplyDTO dto);

}
