package com.example.teamProject.service.dot;

import java.util.List;

import com.example.teamProject.model.dot.dto.DotReplyDTO;

public interface DotReplyService {
	public List<DotReplyDTO> list(int bno);
	public int count(int bno);
	public void create(DotReplyDTO dto);
}
