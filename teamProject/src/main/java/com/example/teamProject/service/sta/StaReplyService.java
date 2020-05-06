package com.example.teamProject.service.sta;

import java.util.List;

import com.example.teamProject.model.sta.dto.StaReplyDTO;

public interface StaReplyService {
	public List<StaReplyDTO> list(int bno);
	public int count(int bno);
	public void create(StaReplyDTO dto);
}
