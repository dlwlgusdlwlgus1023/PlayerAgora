package com.example.teamProject.service.lol;

import java.util.List;

import com.example.teamProject.model.lol.dto.LolReplyDTO;

public interface LolReplyService {
	public List<LolReplyDTO> list(int bno);
	public int count(int bno);
	public void create(LolReplyDTO dto);
}
