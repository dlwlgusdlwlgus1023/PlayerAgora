package com.example.teamProject.model.mps.dao;

import java.util.List;

import com.example.teamProject.model.mps.dto.MpsReplyDTO;

public interface MpsReplyDAO {
	public List<MpsReplyDTO> list(int bno);
	public int count(int bno);
	public void create(MpsReplyDTO dto);

}
