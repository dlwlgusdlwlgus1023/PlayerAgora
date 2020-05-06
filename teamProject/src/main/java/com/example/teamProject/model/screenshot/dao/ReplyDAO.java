package com.example.teamProject.model.screenshot.dao;

import java.util.List;

import com.example.teamProject.model.screenshot.dto.ReplyDTO;

public interface ReplyDAO {
	public List<ReplyDTO> list(int bno);
	public int count(int bno);
	public void create(ReplyDTO dto);

}
