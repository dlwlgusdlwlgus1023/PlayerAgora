package com.example.teamProject.model.civ.dao;

import java.util.List;

import com.example.teamProject.model.civ.dto.CivReplyDTO;

public interface CivReplyDAO {
	public List<CivReplyDTO> list(int bno);
	public int count(int bno);
	public void create(CivReplyDTO dto);

}
