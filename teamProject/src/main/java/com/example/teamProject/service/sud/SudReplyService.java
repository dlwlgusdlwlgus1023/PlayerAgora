package com.example.teamProject.service.sud;

import java.util.List;

import com.example.teamProject.model.sud.dto.SudReplyDTO;

public interface SudReplyService {
	public List<SudReplyDTO> list(int bno);
	public int count(int bno);
	public void create(SudReplyDTO dto);
}
