package com.example.teamProject.model.sta.dao;

import java.util.List;

import com.example.teamProject.model.sta.dto.StaReplyDTO;

public interface StaReplyDAO {
	public List<StaReplyDTO> list(int bno);
	public int count(int bno);
	public void create(StaReplyDTO dto);

}
