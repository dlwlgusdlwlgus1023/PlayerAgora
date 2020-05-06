package com.example.teamProject.service.loa;

import java.util.List;

import com.example.teamProject.model.loa.dto.LoaReplyDTO;

public interface LoaReplyService {
	public List<LoaReplyDTO> list(int bno);
	public int count(int bno);
	public void create(LoaReplyDTO dto);
}
