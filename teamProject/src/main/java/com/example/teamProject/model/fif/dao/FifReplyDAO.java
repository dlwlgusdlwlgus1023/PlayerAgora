package com.example.teamProject.model.fif.dao;

import java.util.List;

import com.example.teamProject.model.fif.dto.FifReplyDTO;

public interface FifReplyDAO {
	public List<FifReplyDTO> list(int bno);
	public int count(int bno);
	public void create(FifReplyDTO dto);

}
