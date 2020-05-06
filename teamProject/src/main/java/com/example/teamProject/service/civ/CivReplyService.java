package com.example.teamProject.service.civ;

import java.util.List;

import com.example.teamProject.model.civ.dto.CivReplyDTO;

public interface CivReplyService {
	public List<CivReplyDTO> list(int bno);
	public int count(int bno);
	public void create(CivReplyDTO dto);
}
