package com.example.teamProject.model.sud.dao;

import java.util.List;

import com.example.teamProject.model.sud.dto.SudReplyDTO;

public interface SudReplyDAO {
	public List<SudReplyDTO> list(int bno);
	public int count(int bno);
	public void create(SudReplyDTO dto);

}
