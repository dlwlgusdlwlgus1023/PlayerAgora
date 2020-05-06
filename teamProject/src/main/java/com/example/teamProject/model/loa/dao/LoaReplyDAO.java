package com.example.teamProject.model.loa.dao;

import java.util.List;

import com.example.teamProject.model.loa.dto.LoaReplyDTO;

public interface LoaReplyDAO {
	public List<LoaReplyDTO> list(int bno);
	public int count(int bno);
	public void create(LoaReplyDTO dto);

}
