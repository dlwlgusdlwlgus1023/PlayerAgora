package com.example.teamProject.service.screenshot;

import java.util.List;

import com.example.teamProject.model.screenshot.dto.ReplyDTO;

public interface ReplyService {
	public List<ReplyDTO> list(int bno);
	public int count(int bno);
	public void create(ReplyDTO dto);
}
