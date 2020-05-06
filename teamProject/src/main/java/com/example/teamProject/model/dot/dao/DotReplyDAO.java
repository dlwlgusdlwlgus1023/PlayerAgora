package com.example.teamProject.model.dot.dao;

import java.util.List;

import com.example.teamProject.model.dot.dto.DotReplyDTO;

public interface DotReplyDAO {
	public List<DotReplyDTO> list(int bno);
	public int count(int bno);
	public void create(DotReplyDTO dto);

}
